import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  @Input() name: string;
   constructor(private fb: FormBuilder) {
}

  projectForm = this.fb.group({
    projectName: ['', Validators.required],
    startDate: [''],
    endDate: [''],
    priority: [''],
    manager:['']
  });
  ngOnInit(): void {
  }
}
