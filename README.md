# DevCom test task



to execute all tests in command line use maven

`mvn test`

for single test execution:

`mvn test -Dtest=RunCucumberTest`

to choose between firefox and chrome driver use:

`mvn test -Dbrowser=firefox`
also default browser is set in cucumber.properties