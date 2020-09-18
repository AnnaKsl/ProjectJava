package Steps;

import org.openqa.selenium.WebDriver;

public class CommonDriver {
    private static WebDriver commonDriver;
    //Tworzę wspólny driver dla classy FirstTaskSteps i SecondTaskSteps

    //za pomocą settera przekazuję drivera
    public static void setDriver(WebDriver driver){
        commonDriver = driver;
    }

    //za pomocą geterra przekazuję drivera do clas steps
    public static WebDriver getDriver() {
        return commonDriver;
    }
}
