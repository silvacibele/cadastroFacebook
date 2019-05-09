package PuroESimples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.concurrent.TimeUnit;

public class PO {

    WebDriver driver;

    @FindBy(name = "firstname")
    public WebElement txtNome;

    @FindBy(name = "lastname")
    public WebElement txtSobreNome;

    @FindBy(name = "reg_email__")
    public WebElement txtEmailOuCel;

    @FindBy(name = "reg_passwd__")
    public WebElement txtPassword;

    @FindBy(name = "birthday_day")
    public WebElement diaNascimento;

    @FindBy(name = "birthday_month")
    public WebElement mesNascimento;

    @FindBy(name = "birthday_year")
    public WebElement anoNascimento;

    @FindBy(name = "websubmit")
    public WebElement btnInscrevase;

    @FindBy(name = "reg_email_confirmation__")
    public WebElement txtConfirmaEmail;

    @FindBy(id = "reg_error_inner")
    public WebElement msgErro;



    //Cria um construtor com o driver e usa o pageFactory
    public PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void selecionarSexo(String sexo){
        if (sexo.contains("Feminino")){
            sexo = "1";
        }else{
            sexo = "2";
        }
        driver.findElement(By.xpath("//*[@name = 'sex' and @value = "+sexo+" ]")).click();
    }

    public void selecionarDataNascimento(String dia,String mes, String ano){
        diaNascimento.sendKeys(dia);
        mesNascimento.sendKeys(mes);
        anoNascimento.sendKeys(ano);
    }

    public void clicar(WebElement element){
        element.click();
    }

    public void preencherCampoTexto(WebElement element, String texto){
        element.sendKeys(texto);
    }

    public void cadastrarUsuario(String nome, String sobreNome, String emailOuCel, String senha, String sexo,
                                 String dia, String mes, String ano){
        preencherCampoTexto(txtNome,nome);
        preencherCampoTexto(txtSobreNome,sobreNome);
        preencherCampoTexto(txtEmailOuCel,emailOuCel);
        preencherCampoTexto(txtConfirmaEmail,emailOuCel);
        preencherCampoTexto(txtPassword,senha);
        selecionarDataNascimento(dia, mes, ano);
        selecionarSexo(sexo);
        clicar(btnInscrevase);
    }
}
