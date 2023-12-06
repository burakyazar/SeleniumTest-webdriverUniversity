package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.sql.Timestamp;

import static driver.DriverFactory.cleanupDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {

    @Before
    public void setupLogin() {

getDriver();

    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario){
        if (scenario.isFailed()){
            //this will be saving as long value we will make it as String
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds= Long.toString(timestamp.getTime());
            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds);

        }
    }

    @After
    public void tearDownLogin() {
        cleanupDriver();


    }

}
