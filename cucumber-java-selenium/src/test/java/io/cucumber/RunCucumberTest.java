package io.cucumber;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
//import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
//@SelectPackages("io.cucumber") // Scans for your Runner and Glue
@ConfigurationParameter(key = "cucumber.glue", value = "io.cucumber") //
@ConfigurationParameter(key = "cucumber.features", value = "src/test/resources/io/cucumber/features") //
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:target/cucumber-report/cucumber.html") //
public class RunCucumberTest {
}