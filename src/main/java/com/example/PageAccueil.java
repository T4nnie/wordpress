package com.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageAccueil extends BandeauMenu {

    @FindBy(xpath = "//div[@class='welcome-panel-header']//h2")
    private WebElement bienvenue;

    public boolean isMe() {
        return bienvenue.getText().contains("Bienvenue sur WordPress");
    }
    
}
