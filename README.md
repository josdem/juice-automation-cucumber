Juice Automation
----------------------------------------

This project shows how to test an API using[Cucumber Framework](https://cucumber.io/) and a third-party library [juice-webclient](https://github.com/josdem/juice-webclient)

#### To test the project with Gradle

```bash
gradle test
```

### To run a single test with Gradle

```bash
gradle test --tests ${testName}
```

where:

- `${testName}` is the test name you want to execute

#### To test the project with Maven

```bash
mvn test
```

### To run a single test with Maven

```bash
mvn test -Dtest ${testName}
```

#### To run tests with Jacoco and Sonarqube

```bash
gradle jacocoTestReport sonarqube test
```

**Note:** This project requires [juice-webclient](https://github.com/josdem/juice-webclient) as a dependency

#### For more information:

Visit our wiki page: [Wiki page](https://github.com/josdem/juice-automation/wiki)

#### Read this as reference:

* https://josdem.io/techtalk/spring/spring_boot_webclient/
* https://josdem.io/techtalk/spring/spring_webflux_client/
* https://josdem.io/techtalk/spring/spring_webflux_artifactory_library/