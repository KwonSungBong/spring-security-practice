import { Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  token;

  constructor(private http: HttpClient) {

  }

  getToken() {
    this.http.get('/auth/token').subscribe(data => {
      this.token = data;
      console.log(this.token);
    });
  }

  login() {
    const body = {};

    this.http.post('/login', body, {
      headers: new HttpHeaders().set('X-XSRF-TOKEN', this.token.token),
      params: new HttpParams().set('username', 'user').set('password', 'password'),
    }).subscribe(data => {
      console.log(data);
    });
  }

  logout() {
    const body = {};

    this.http.post('/logout', body, {
      headers: new HttpHeaders().set('X-XSRF-TOKEN', this.token.token),
    }).subscribe(data => {
      console.log(data);
    });
  }

  me() {
    this.http.get('/auth/me').subscribe(data => {
      console.log(data);
    });
  }

}
