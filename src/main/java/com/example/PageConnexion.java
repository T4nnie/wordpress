package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageConnexion {

    public PageAccueil seConnecter(WebDriver driver, String userName, String passwd){

        remplirIdentifiant(userName);
        remplirPasswd(passwd);
        submit();

        return PageFactory.initElements(driver, PageAccueil.class);
    }

    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement f_identifiant;
    private void remplirIdentifiant(String userName) {
        f_identifiant.clear();
        f_identifiant.sendKeys(userName);
    }

    @FindBy(xpath = "//input[@id='user_pass']")
    private WebElement f_pwd;
    private void remplirPasswd(String userName) {
        f_pwd.clear();
        f_pwd.sendKeys(userName);
    }
    
    @FindBy(xpath = "//input[@id='wp-submit']")
    private WebElement b;
    private void submit() {
        b.click();
    }
}
