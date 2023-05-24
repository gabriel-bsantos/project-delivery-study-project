# Project - Growth Area - Product Delivery
This project was created as part of my growth area objective, that was study CI/CD and implement a pipeline that would run unit tests in an Android project.

The pipeline of unit tests that was implemented in a YAML file and is ran by GitHub Actions, you can find this file as `tests_pipeline.yml` in the path `.github/workflows`. 

# Explaining the pipeline
The pipeline, as usually is, is divided by some steps: 
- Definition of its trigger behaviour: I defined that I wanted to trigger the automation when I open a pull request to the `master` branch, and every branch that has an opened PR to master will trigger the automation when receiving an update. 
- Definition of the wanted virtual machine OS: I defined that I wanted to use the Ubuntu OS, a Linux distribution. 
- Definition of `actions/checkout`: with this step, the pipeline ensures the pipeline has access to the true codebase in the virtual machine.
- Setup of JDK in the VM: in this step, I setup the JDK that it needs to run the project build.
- Making gradlew script executable: with the line `chmod +x ./gradlew`, I make the `./gradlew` script executable.
- Run the unit tests: with the script `./gradlew testDebugUnitTest`, I run all the unit tests that exists in the app and are located in the Debug package.
- [Android Test Report action](https://github.com/asadmansr/android-test-report-action): with that I get a report containing the tests data, that shows info like: tests count, errors, failures etc. It is a Action created by a GitHub user called Asad Mansor.



