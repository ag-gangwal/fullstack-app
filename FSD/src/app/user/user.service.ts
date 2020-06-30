import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { User } from './user';
import {Observable, of} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  configUrl = 'http://localhost:8080/fullstack/user';
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.configUrl);
      /*.pipe(
        tap(_ => {
          catchError(console.error(error))};
        }))
      );
      ;*/
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>(this.configUrl, user, this.httpOptions);
  }

  updateUser(user: User): Observable<User> {
    return this.http.put<User>(this.configUrl, user, this.httpOptions);
  }

  deleteUser(user: User): Observable<User> {
    const url = `${this.configUrl}/` + user.userId;
    return this.http.delete<User>(url);
  }

    searchUsers(term: string): Observable<User[]> {
      if (!term.trim()) {
      // if not search term, return empty hero array.
      return this.getUsers();
    }
      return this.http.get<User[]>(`${this.configUrl}/${term}`);
  }
}
