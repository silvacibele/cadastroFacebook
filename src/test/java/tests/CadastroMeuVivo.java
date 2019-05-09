package tests;

import Helper.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.MasterPO;

public class CadastroMeuVivo {
    String browser = "CHROME";
    MasterPO master;
    WebDriver driver;
    WebDriverWait wait;




    @Test
    public void teste() {
        DriverHelper driverHelper = new DriverHelper();
        driverHelper.setupDriver(browser);
        wait = new WebDriverWait(driver, 30);
    }
}
