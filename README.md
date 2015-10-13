[![Build Status](https://travis-ci.org/imscaradh/srs.svg)](https://travis-ci.org/imscaradh/srs)
[![codecov.io](http://codecov.io/github/imscaradh/srs/coverage.svg?branch=master)](http://codecov.io/github/imscaradh/srs?branch=master)
# SRS Store
This repo provides a dynamic reservation system for different environments. The project is build with maven and uses JavaFX. 

For more informations about the project, see [Maven Site of the Smart Reservation System](https://s3.eu-central-1.amazonaws.com/travisupload/srs/index.html)

## Setup

### Software
Your system should have installed the following software:
* Maven 3+: [Install instructions](https://maven.apache.org/install.html)
* Java Developent Kit 8+ (openjdk **doesn't** work with the actual project setup): [Download JDK8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

### Configure CalendarFX License
In order to use the full functionality of CalendarFX, you have to configure the license. Put the license key into a new file called `~/.calendarfx/licensekey`. 

### Install JavaFX application

To build your project, step into the directory of the cloned repository and run the following command:
```bash
mvn package
```
After that, you will have a new directory called `target` under the root of the repository. To run the builded application, execute the following command:
```bash
java -jar target/jfx/app/srs-jfx.jar
```

Enjoy!
