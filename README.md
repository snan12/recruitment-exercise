Project Overview:
This project involves several exercises using a combination of 
Java, BDD, and various tools like Maven, Cucumber, Gherkin, Selenium, Git, and JUnit.


Topics:
Maven
Java
BDD (Behavior Driven Development)
Cucumber
Gherkin
Selenium
Git
JUnit
Notes:
Cucumber Filter Tags: Use cucumber filter tags to execute the full regression or the test currently in development.

Example: mvn test -Dcucumber.filter.tags="@develop"
Example: mvn test -Dcucumber.filter.tags="@regression"
Running Tests: You can run the Maven goal test or use a JUnit runner within the IDE. Use the VM variable cucumber.filter.tags.

Example: mvn test -Dcucumber.filter.tags="@develop"
Example: mvn test -Dcucumber.filter.tags="@regression"
Git Branches: Use Git branches during development. Create a feature branch for each exercise and merge these back into the develop branch once completed.
•	Feature Branch: ‘git checkout -b feature/your-feature-name’
•	Merge Feature Branch: ‘git checkout develop and git merge feature/your-feature-name’
•	Push to Remote: ‘git push origin develop’

WebDriver Configuration: Define a path for webdriver.chrome.driver using a system property passed in the IDE run configuration and the CLI when executing via Maven goal.

Example: ‘-Dwebdriver.chrome.driver=path/to/driver ‘on the CLI, as the tests shouldn't have the driver hardcoded.
Logging: Consider implementing logging for better traceability and debugging.

Application Code: Ensure the main application code is generic and can work with examples other than those specified in the tests.

Execution: Executing mvn test should succeed.

Example: mvn test -Dwebdriver.chrome.driver=path/to/chromedriver-Dcucumber.filter.tags="@regression"
Exercises
1. How Many Words (Java, JUnit, Git, Maven)
Implement the method to pass the unit test.

2. Account (Cucumber, Java, JUnit, Git, Maven)
The feature file is written and a single step definition is created, although not implemented. Add the remaining step definitions and implement them as well as the corresponding plain Java 'application' code.

3. Google (Selenium, Cucumber, Java, JUnit, Git, Maven)
Implement the pre-written scenarios using Selenium WebDriver. The Driver is configured to use Chrome. You will need to pass in the path to a Chrome driver.

4. Password Change (BDD, Gherkin)
Complete the feature file to describe the scenarios required to test a standard 'password change' functionality. Assume a few rules that the new password must comply with. Specify the current username and password before entering a new password and confirm the new password by re-typing the same. 




