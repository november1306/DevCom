# DevCom test task

to execute all tests in command line use maven

`mvn test`

for single test execution:

`mvn clean test -Dtest=ToDoMvcTest`

in case there's no maven available, another option is to use
running-tests-console-launcher

[https://junit.org/junit5/docs/5.0.0-M5/user-guide/#running-tests-console-launcher]()

`java -jar junit-platform-console-standalone-<version>.jar`

or just open project in IDE and run tests