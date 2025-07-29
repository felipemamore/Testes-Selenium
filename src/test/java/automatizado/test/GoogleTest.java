package automatizado.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import automatizado.page.GooglePO;


public class GoogleTest extends BateTest {
    

    private static GooglePO googlePage;

    @BeforeAll
    public static void preperarTestes(){
        googlePage = new GooglePO(driver); 
    }

    @Test
    public void TC001_deveSerPossivelPequisarNoGoogleOTextoBatataFrita(){
  
        googlePage.pesquisar("Batata frita");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado.contains("Aproximadamente"), resultado);

    }

    @Test
    public void TC002_deveSerPossivelPequisarNoGoogleOTextoNutella(){
    
        googlePage.pesquisar("Nutella");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado.contains("resultados"), resultado);

    }

}
