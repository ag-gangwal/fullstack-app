import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Project} from './project';


@Injectable({
  providedIn: 'root'
})

export class ProjectService {
  private projectUrl = 'localhost:8080/fullstack/project';  // URL to web api
  constructor(private http: HttpClient) { }
  /** GET heroes from the server */
  getProject(): Observable<Project[]> {
    return this.http.get<Project[]>(this.projectUrl);
  }


}
