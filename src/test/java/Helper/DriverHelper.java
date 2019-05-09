package Helper;

import org.openqa.selenium.WebDriver;

public class DriverHelper {

    private final String CHROMEDRIVER_PATH = "src/test/resource/chromedriver.exe";
    private final String GECKODRIVER_PATH = "src/test/resource/geckodriver.exe";
    private final String CHROME = "webdriver.chrome.driver";
    private final String GECKO = "webdriver.gecko.driver";
    public static WebDriver driver;

    public  WebDriver setupDriver(String browser){
       if (browser == CHROME){
           System.setProperty(CHROME, CHROMEDRIVER_PATH);
       }else {
           System.setProperty(GECKO, GECKODRIVER_PATH);
       }
       return driver;
    }

}
