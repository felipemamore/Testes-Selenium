package automatizado.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GooglePO extends BasePO {

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "result-stats")
    public WebElement divResultadoPesquisa;

    /**
     * Construtor para criação da pagina do Google.
     * @param driver Driver da pagina do Google.
     */
    public GooglePO(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Metodo que irá efetuar uma pesquisa no google baseando no texto informado e concluindo com enter.
     * @param texto Texto a ser pesquisado.
     */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**
     * Metodo que retorna o resultado aproximado da pesquisa.
     * @return Retorna o resultado da pesquisa.
     */
    public String obterResultadoDaPesquisa(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    
    // Espera o botão "Ferramentas" estar clicável e clica nele
        WebElement botaoFerramentas = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("hdtb-tls")));
        botaoFerramentas.click();

    // Opcional: espera um curto tempo para a animação/expansão acontecer
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Agora espera o div #result-stats ficar visível
    WebElement div = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));

    return div.getText();
    }

}
