package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;
import utils.PropertyReader;

import static enums.Pages.HOME_PAGE;

@Getter
public class HomePage extends BasePage {

    @FindBy(linkText = "/start")
    WebElement homePageUrlString;

    @FindBy(css = "div.holder:nth-child(2) header:nth-child(1) div:nth-child(1) div.container div.col1.menu > a.tab:nth-child(1)")
    WebElement aboutTheBankDropDownButton;

    @FindBy(css = "div.holder:nth-child(2) div.container.menu-lvl2:nth-child(2) div.menu-content.lvl2-1046:nth-child(1) div.menu-lvl3:nth-child(1) h5:nth-child(1) > a:nth-child(1)")
    WebElement aboutTheBankButton;

    @FindBy(xpath = "(//a[contains(text(),'M@IB Online')])[1]")
    WebElement maibOnline;

    @FindBy(xpath = "(//a[text()='Banking'])[1]")
    WebElement internetBanking;

    @FindBy(xpath = "(//a[contains(text(),'rapide')])[1]")
    WebElement p2pTransferButton;

    public HomePage(WebDriver driver) {
        super(driver, HOME_PAGE.getUrl());
    }
}