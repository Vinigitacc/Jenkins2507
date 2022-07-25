package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags= {"@address"},snippets = SnippetType.CAMELCASE, strict = true, dryRun = false, plugin = { "pretty",
		"json:target/api.json" }, monochrome = true, features = "src/test/resources", glue = "com.stepdefinition")
/**
 * 
 * @author Dell
 * @Description To execute the program
 *@CreationDate 26/06/2022
 */
public class TestRunnerClass {

	@AfterClass
	public static void afterClass() {
		Reporting.generatejvmReport(System.getProperty("user.dir") + "\\target\\api.json");
	}

}
