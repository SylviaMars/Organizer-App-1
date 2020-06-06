import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FlatModel } from 'src/app/models/flat.model';
import { MatTableDataSource } from '@angular/material/table';
import { NotificationsService } from 'src/app/services/notifications.service';
import { HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { EventModel } from 'src/app/models/event.model';
import { UserModel } from 'src/app/models/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  private user: UserModel;
  constructor(
    private router: Router,
    private userService: UserService,
    private notificationsService: NotificationsService
  ) { }

  ngOnInit(): void {
    this.userService.getUserFlats().subscribe((response: HttpResponse<FlatModel[]>) => {
      if (response.status !== 204) {
        sessionStorage.setItem('flatsList', JSON.stringify(response.body));
      } else {
        this.notificationsService.getNoContentNotification();
      }}, error => this.notificationsService.getErrorNotification(error.status)
    );
    this.userService.getUserEvents(false).subscribe((response: HttpResponse<EventModel[]>) => {
      if (response.status !== 204) {
        sessionStorage.setItem('eventsList', JSON.stringify(response.body));
      } else {
        this.notificationsService.getNoContentNotification();
      }}, error => this.notificationsService.getErrorNotification(error.status)
    );

  }
  logOut() {
    localStorage.clear();
    sessionStorage.clear();
    this.router.navigateByUrl('/');
  }

}
