import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private http: HttpClient) {

  }

  test() {
    this.http.get('/auth/test').subscribe(data => {
      console.log(data);
    });
  }

  test2() {
    //this.http
    //  .post('/api/items/add', body, {
    //    headers: new HttpHeaders().set('Authorization', 'my-auth-token'),
    //  })
    //  .subscribe();
  }

  //https://angular.io/guide/http

}
