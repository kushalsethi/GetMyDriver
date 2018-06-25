import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';  
import { HttpModule } from '@angular/http';
import { AppService } from './app.service';
import { AppComponent } from './app.component';
import { AppPipe } from './app.pipe';

@NgModule({
  declarations: [
    AppComponent, AppPipe
  ],
  imports: [
    BrowserModule, FormsModule, HttpModule, CommonModule
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
