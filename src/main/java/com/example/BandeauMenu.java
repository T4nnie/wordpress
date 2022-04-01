package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BandeauMenu {

    @FindBy(xpath ="//li[@id='wp-admin-bar-new-content']/a")
    private WebElement b_creer;
    public PageEdition clickCreer(WebDriver driver){
        b_creer.click();
        return PageFactory.initElements(driver, PageEdition.class);
    }
    
}
