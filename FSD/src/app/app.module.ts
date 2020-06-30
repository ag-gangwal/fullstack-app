import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import {ProjectComponent} from './project/project.component';
import {TabsComponent} from './tabs/tabs.component';
import {TabComponent} from './tabs/tab.component';
import { DirDirective } from './dir.directive';
import { TaskComponent } from './task/task.component';
import { UserComponent } from './user/user.component';
import { UserSearchComponent } from './user-search/user-search.component';
const appRoutes: Routes = [
  { path: 'project', component: ProjectComponent },
  { path: 'task',      component: TaskComponent }
];
@NgModule({
  declarations: [
    AppComponent,
    ProjectComponent,
    TabsComponent,
    TabComponent,
    DirDirective,
    TaskComponent,
    UserComponent,
    UserSearchComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} // <-- debugging purposes only
    ),
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
