import { Component, OnInit, SimpleChanges } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'cab booker';
  userName: string;
  userCurrentLatitude: string;
  userCurrentLongitude: string;
  driverName: string;
  driverStatusResponse: any[] = [];
  


  constructor(private _appService: AppService) { }

  ngOnInit() {
    this._appService.getDriverStatus().subscribe(
      driverStatusResponse => {
        this.driverStatusResponse = driverStatusResponse;
        console.log(driverStatusResponse);
      }
    );
  }


  findMe() {
    if (window.navigator && window.navigator.geolocation) {
      window.navigator.geolocation.getCurrentPosition((position) => {
        this.showPosition(position);
      });
    } else {
      alert("Geolocation is not supported by this browser.");
    }
  }

  showPosition(position) {
    this.userCurrentLatitude = position.coords.latitude;
    this.userCurrentLongitude = position.coords.longitude;
  }

  getDriver() {
    if (this.userName != null && this.userCurrentLatitude != null && this.userCurrentLongitude != null) {
      this._appService.getDriver(this.userName, this.userCurrentLatitude, this.userCurrentLongitude).subscribe(
        driverName => {
          this.driverName = driverName;
          this.getDriverStatus();
        }
      );
    }
    
  }

  getDriverStatus(): void {
    this._appService.getDriverStatus().subscribe(
      driverStatusResponse => {
        this.driverStatusResponse = driverStatusResponse;
      }
    );
  }

}
