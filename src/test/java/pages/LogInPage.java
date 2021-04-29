package pages;

import driver.Driver;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;
import service.Wait;

import static enums.Pages.LOGIN_PAGE;

@Getter
public class LogInPage extends BasePage {

    Wait wait = new Wait(Driver.getDriver());

    @FindBy(xpath = "//input[contains(@name,'UserId')]")
    WebElement userLoginIDField;

    @FindBy(xpath = "//input[contains(@name,'Password')][@type='password']")
    WebElement passwordField;

    @FindBy(css = "td.messages:nth-child(2) td.messageText td.loginAreaNEW tbody:nth-child(1) tr:nth-child(2) td:nth-child(2) span.ui-selectmenu-button.ui-widget.ui-state-default.ui-corner-top > span.ui-selectmenu-text")
    WebElement securityDropDownBox;

    @FindBy(xpath = "//input[@id='loginbutton']")
    WebElement loginButton;

    public void loginUser(String loginId, String password) {
        wait.sendKeys(userLoginIDField, loginId);
        wait.sendKeys(passwordField, password);
    }

    public LogInPage(WebDriver driver) {
        super(driver, LOGIN_PAGE.getUrl());
    }
}
