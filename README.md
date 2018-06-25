# GetMyDriver
A web application that gives you nearest driver available based on your current location for your ride.</br>

This application is developed using Angular 6 and Spring Boot.</br>
`getmydriver-ui` is the front end Angular application and `getmydriver` is the backend REST API service. </br>
To run spring boot application, go to root directory of `getmydriver` and run below command.</br>
      `mvn clean install`
</br>
Run the `Application.java` as a Java Application, this will start the REST API service. </br>


<b>REST API </b></br>
 - To get the nearest driver, use below REST end point. </br>
`http://hostname:port/getmydriver/main/getdriver?userName=test&userLatitude=19.157935&userLongitude=72.993476`
</br>

 - To get the driver status, use below REST end point. </br>
 `http://hostname:port/getmydriver/main/driverstatus`
 </br>

<b>Angular application</b>
To run the angular application, make sure you have node.js installed on your machine. Go to directory `getmydriver-ui` and run below command.</br>
`npm install` and then </br>
`npm start` </br>
This will make your application running on `localhost:4200` .

