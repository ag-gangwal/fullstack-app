import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserService} from './user.service';
import {User} from './user';
import {Observable, Subject, Subscription} from 'rxjs';
import {debounceTime, distinctUntilChanged, switchMap} from 'rxjs/operators';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  constructor(private fb: FormBuilder, private userService: UserService) { }
  userForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    employeeId: ['', [Validators.required, Validators.pattern('[0-9]*')]]
  });
  @Input() users: User[];
  users$: Observable<User[]>;
  isEdit = false;
  allUsers = true;
  sortBy = 'firstName';
  private searchTerms = new Subject<string>();

  ngOnInit(): void {
    this.getAllUsers();
    this.isEdit = false;

    // @ts-ignore
    this.users$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),

      // ignore new term if same as previous term
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      switchMap((term: string) => this.userService.searchUsers(term)),
    );
  }
  search(term: string): void {
    this.searchTerms.next(term);
    this.allUsers = false;
    if (!term.trim()) {
      // if not search term, return empty hero array.
      this.allUsers = true;
    }
  }

  getAllUsers(): void {
    this.userService.getUsers()
      .subscribe(data => {
        this.users = data;
        this.sortData('employeeId');
      });
  }

   sortData(sortField: string) {
    return this.users.sort((a, b) => {
      switch (sortField) {
        case 'firstName': return this.compare(a.firstName, b.firstName);
        case 'lastName': return this.compare(a.lastName, b.lastName);
        case 'employeeId': return this.compare(a.employeeId, b.employeeId);
        default: return 0;
      }
    });
  }

 compare(a: number | string, b: number | string) {
    return (a < b ? -1 : 1) ;
  }


  addUser(user: User): void {
    this.userService.addUser(user)
      .subscribe(newuser => {
          this.users.push(user);
        }
      );
  }

  updateUser(user: User): void {
    this.userService.updateUser(user)
      .subscribe(newuser => {// this.users.push(Object.assign({}, newuser));
                             const pos = this.users.map( usr =>  usr.userId).indexOf(user.userId);
                             this.users.splice(pos, 1);
                             this.users.push(user);
        }
      );
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user).subscribe((res) => {
      const pos = this.users.map( usr =>  usr.userId).indexOf(user.userId);
      this.users.splice(pos, 1);
    });
  }

  editUser(user: User): void {
    console.log('edit userid ' + user.userId);

    this.isEdit = true;
    this.userForm = this.fb.group({
      firstName: [user.firstName, Validators.required],
      lastName: [user.lastName],
      employeeId: [user.employeeId],
      userId : [user.userId]
    });
  }

  reset(): void {
    this.getAllUsers();
    this.isEdit = false;
    this.allUsers = true;
    this.sortBy = 'firstName';
    this.getAllUsers();
  }
}
