package org.flipkartrun;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FlipkartFeature", glue = "org.flipkartautomate", dryRun = false, monochrome = true, strict = true)

public class FlipkartRun {

}
