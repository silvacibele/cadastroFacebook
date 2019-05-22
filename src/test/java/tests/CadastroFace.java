package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.PO;

import java.util.concurrent.TimeUnit;

public class CadastroFace {

    String urlFace = "https://www.facebook.com";
    WebDriver driver;
    WebDriverWait wait;
    PO pageObjects;

    String nome = "Teste";
    String sobreNome = "Auto";
    String emailOuCel = "teste@teste.com";
    String senha = "Teste001122";
    String sexo = "Masculino";
    String dia = "12";
    String mes = "Dezembro";
    String ano = "1912";


    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src\\test\\resource\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(urlFace);
    }

    @Test
    public void cadastrarUserFace() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageObjects = new PO(driver);
        pageObjects.cadastrarUsuario(nome, sobreNome, emailOuCel, senha, sexo, dia, mes, ano);
        Assert.assertNotNull(pageObjects.msgCadastro);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
