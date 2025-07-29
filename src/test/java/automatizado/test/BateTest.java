package automatizado.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BateTest {
    
    protected static WebDriver driver;
    private static final String URL_BASE = "https://www.google.com/" ;
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver.exe";

    private static final String CHROME_USER_DATA_DIR = "C:/Users/felipe.mamore/AppData/Local/Google/Chrome/User Data";

    @BeforeAll
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);

        ChromeOptions options = new ChromeOptions();

        // Usar perfil real do Chrome (diminui chances de CAPTCHA)
        options.addArguments("user-data-dir=" + CHROME_USER_DATA_DIR);

        // Opções para "disfarçar" Selenium e evitar detecção
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    
    @AfterAll
    public static void finalizar(){
     if (driver != null) {
            driver.quit();
        }
    }
}

