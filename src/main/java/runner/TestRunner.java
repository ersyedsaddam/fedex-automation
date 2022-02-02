package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/fedex.feature",
        glue = {"src/main/java/stepDefinitions"},
        format = {"pretty", "html:test-output", "json:json_output/cucmber.json", "junit:junit_xml/cucumber.xml"},
        monochrome = true, // display the console output in a proper readable format
        strict = true, // it will check if any step is not defined in step definition file
        dryRun = false // to check the mapping is proper between feature file and step def file
)

public class TestRunner {
}
