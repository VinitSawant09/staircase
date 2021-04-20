Staircase problem solution - a pet project to demonstrate technology experience in Java8, Spring Boot, Rest etc.

Problem Statement- 

A stairwell has a number of flights of stairs separated by landings.
Each flight is a straight line of steps that you can climb without stopping.  One can
stride more than one step at a time when climbing each flight.
It takes two strides to turn on the landing and start again on the next flight of stairs.
As input, you are given an array listing the number of steps in each flight of stairs in the stairwell. One can also
receive the number of steps you can cover with each stride (you could climb 2 steps per stride, or 3 steps per
stride if you were tall and fit).
The stairwell has between 1 and 30 flights inclusive. Each flight can have a maximum of 20 steps. You can
stride between 1 and 4 steps inclusive.
For a given input, the minimum number of strides necessary to get to the top of the stairwell have been evaluated.

Tech and version - 

Java 8
Spring Boot 2.4.4
HSQL 2.4.0
Hibernate and JPA
Maven 4.0.0
Junit 

Process of running through Command prompt.

1)Open cmd
2)Traverse to the target folder in maven.
3)Run command java -jar staircase-0.0.1-SNAPSHOT.jar
4)Application is ready to be used

Methods

1)Calculate minimum strides. (/stride?)

request: GET http://localhost:8080/stride?flights=17&stepsPerStride=3

result status: 200 OK

result data: 6

request: GET http://localhost:8080/stride?flights=17,17&stepsPerStride=3

result status: 200 OK

result data: 14

request: GET http://localhost:8080/stride?flights=4,9,8,11,7,20,14&stepsPerStride=2

result status: 200 OK

result data: 50



2)Get all requests (stride/request?)

request: GET http://localhost:8080/stride/request?threshold=10&limit=100
result status: 200 OK
result body: [
{
"request": {
"flights": [
17
],
"stepsPerStride": 3
},
"result": 6
}
]

Authentication
Basic Auth has been used with username:user and password:password for accessing get all requests service.


If you need anymore details. Kindly let me know on my email id.




