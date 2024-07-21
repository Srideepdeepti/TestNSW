Prerequisite: Eclipse and Maven should be installed on machine

Git Repoistory link: https://github.com/Srideepdeepti/TestNSW.git

### How to import git folder on Eclipse

Steps:
1. Click on File Menu
2. Select -> Git--> Projects from Git
3. Clone URI
4. Paste URI <https://github.com/Srideepdeepti/TestNSW.git>
5. Click Finish

### After project is imported in Eclipse, find below steps to run the TestRunner file to execute test

Steps:
1. Go to TestNSW project
2. Find testRunner file at location /TestNSW/src/test/java/cucumber/Options/testRunner.java
3. Click testRunner.java and Run this as JUnit test

This file will execute the Cucumber Feature File present in location : /TestNSW/src/test/java/features/selection_Clear_All.feature

This Feature File has two Scenarios

Scenario1: Validate the Apply Filter functionality

You can provide any number of Ministers in the Feature File itself by adding or removing the values.

Scenario2: Validate the Clear All functionality



###Reporting

1.After running the test json report can be found at /TestNSW/target/jsonReport
2. For Cucumber-html-reports , you need to execute command <mvn test verify> at project level , Report gets generated at : /TestNSW/target/cucumber-html-reports





# TestNSW