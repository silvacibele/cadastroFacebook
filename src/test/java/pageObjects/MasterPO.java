package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MasterPO {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy (id = "campoRegional")
    public WebElement txtRegional;

    @FindBy (className = "bt_cliente_n")
    public WebElement btnNaoSouCliente;

    @FindBy (id = "btn-fazer-cadastro-we")
    public WebElement btnCadastreseAgora;


    public MasterPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 30);
    }

    public void clicar(WebElement elemento){
        elemento.click();
    }

    public  void preencherCampo(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }
    public void selecionarEstado(String estado){
        wait.until(ExpectedConditions.elementToBeClickable(txtRegional)).sendKeys(estado);
        driver.findElement(By.linkText(estado)).click();
        clicar(btnNaoSouCliente);
    }

    public CadastroPO clicarCadastrar(){
        clicar(btnCadastreseAgora);
        return new CadastroPO(driver);
    }




}
