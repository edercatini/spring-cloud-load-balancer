### Description

Run load-balanced routines (sample usage).

### Requirements
```
Java 11
Maven 3.8.6
```

### Three instances of say-hello must be running:
```
$ cd ./say-hello
$ mvn spring-boot:run
$ SERVER_PORT=9092 mvn spring-boot:run
$ SERVER_PORT=9999 mvn spring-boot:run
```

### One instance of user must be running:
```
$ cd ./user
$ mvn spring:boot-run
```

### Run the following instructions:
```
$ curl http://localhost:8888/hi
$ curl http://localhost:8888/hi?name=Test
```