package com.example;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static WebDriver driver;




    @BeforeClass
    public static void set(){
        //System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();       
    }
    
    @Before
    public void setBeforeEach(){
        driver.get("http://localhost/wordpress/wp-login");
        driver.manage().window().maximize();
    }

    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testConnexion(){
        Properties conf = new Properties();
        try {
            conf.load(new FileInputStream("src/main/resources/JDD/conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        PageConnexion pc = PageFactory.initElements(driver, PageConnexion.class);
        PageAccueil pa = pc.seConnecter(driver, conf.getProperty("identifiant"), conf.getProperty("password"));
        assert(pa.isMe());
        PageEdition pe = pa.clickCreer(driver);
        w4it(1000);
        (new Actions(driver)).click().build() .perform();
        //assert(driver.findElement(By.xpath("//title")).getText().contains("Ajouter"));
        pe.titrer("! VIVA LA PROPAGANDA !");
        
        pe.enregistrer();
        w4it(2000);
        pe.clickOnW(driver);

    }

    

    @After
    public void end(){
        w4it(3000);
    }

    @AfterClass
    public static void down(){
        //driver.quit();
    }

    public void w4it(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
