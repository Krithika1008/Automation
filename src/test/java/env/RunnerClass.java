package env;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
			 "pretty",
		     "html:target/cucumber/Html-Report",
			 "json:target/cucumber-json-report.json",
			 "json:target/cucumber.json",
			 "junit:target/cucumber-reports/junit-reports/junit-reports.txt"
		     },
		features = "classpath:features/google.feature",
		glue = {
				"info.seleniumcucumber.userStepDefintions"
			   },
		tags= {"@RunAll"},
		monochrome=true
)

public class RunnerClass extends DriverUtil{
	
	public static void start() {
		System.out.println("Start execution");
	}
}

//GIT link: https://github.com/gsmisra/AutomationMasterRepo.git
//mvn clean test -U -Dtest=RunnerClass
//mvn net.masterthought:maven-cucumber-reporting:generate
