import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Http, Response, Headers, URLSearchParams , RequestOptions } from '@angular/http';
import { map, filter, scan } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class AppService {

  private baseURL:string= "http://localhost:8080/getmydriver/main/";
  constructor(private _http: Http) { }

  getDriver(userName:string, userCurrentLatitude: any,
    userCurrentLongitude: any):Observable<any>{
    var httpUrl = this.baseURL+"getdriver/?userName="+userName+"&userLatitude="+userCurrentLatitude+"&userLongitude="+userCurrentLongitude;
    let headers = new Headers({
      'Content-Type':'application/json'
    });
    let options =new RequestOptions({ headers: headers }); 
      return this._http.get(httpUrl)
            .pipe(map((response: Response) => <any> response.text().toString()))
  }

  getDriverStatus():Observable<any[]>{
    var httpUrl = this.baseURL+"driverstatus/";
      return this._http.get(httpUrl)
            .pipe(map((response: Response) => <any[]> response.json()));
  }

}
