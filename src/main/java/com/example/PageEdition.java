package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageEdition {

    @FindBy(xpath ="//div[@class='edit-post-visual-editor__post-title-wrapper']/h1")
    private WebElement titre;
    public void titrer(String s){
        titre.clear();
        titre.sendKeys(s);
    }

    @FindBy(xpath = "//button[.='Enregistrer le brouillon']")
    private WebElement b_enregistre;
    public void enregistrer(){
        b_enregistre.click();
    }

    @FindBy(xpath = "//div[@class='edit-post-header']/div[1]/a")
    private WebElement b_hautGauche;
    public PageArticles clickOnW(WebDriver driver){
        b_hautGauche.click();
        return PageFactory.initElements(driver, PageArticles.class);
    }
    public boolean isMe() {
        return false;
    }


}
