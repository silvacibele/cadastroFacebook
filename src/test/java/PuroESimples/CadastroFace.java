package PuroESimples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.sun.jmx.snmp.ThreadContext.contains;

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
    public void cadastrarUserFace(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageObjects = new PO(driver);
        pageObjects.cadastrarUsuario(nome, sobreNome, emailOuCel, senha, sexo, dia, mes, ano);
        String validaMsgErro = pageObjects.msgErro.getText();
        Assert.assertEquals(validaMsgErro,validaMsgErro);
    }



}
