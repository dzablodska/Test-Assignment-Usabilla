# Prerequisites:

 - java 8
 - Maven 3.6.2
 - chrome
 - firefox 

# How to run:

To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run `mvn verify` from the root of the project in the command line.
By default, the tests will run using Chrome, you can run the tests in Firefox by overriding the driver system property:

```
$ mvn clean verify -Ddriver=firefox

$ mvn clean verify -Ddriver=chrome
```

The test results will be recorded in the `target/site/serenity` directory.

How to generate reports:
```
$ mvn serenity:aggregate
```

Open the following file in the browser: 
`\serenity-cucumber4-starter\target\site\serenity\index.html`