# DevCom test task



to execute all tests in command line use maven

`mvn test`

to choose between firefox and chrome driver use:

also default browser is set in cucumber.properties

`mvn test -Dbrowser=firefox`



for single test execution:

`mvn test -Dtest=RunCucumberTest`

or launch tests from  RunCucumberTest.class in IDE