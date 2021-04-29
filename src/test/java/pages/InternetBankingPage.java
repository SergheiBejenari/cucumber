package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;

import static enums.Pages.INTERNET_BANKING_PAGE;

@Getter
public class InternetBankingPage extends BasePage {

    @FindBy(xpath = "(//a[contains(text(),'Autentificare')])[1]")
    WebElement individualsAuthenticationButton;

    @FindBy(xpath = "//img[@id='btnMenu']")
    WebElement menuButton;

    @FindBy(xpath = "//a[@id='MenuTreeViewn24']")
    WebElement fundsTransactions;

    @FindBy(xpath = "//a[@id='MenuTreeViewn0']")
    WebElement accountInformationDropDownBox;

    @FindBy(xpath = "//a[@id='MenuTreeViewn2']")
    WebElement accountStatementButton;

    @FindBy(xpath = "//a[@id='MenuTreeViewn27']")
    WebElement localCurrencyTransfer;

    @FindBy(xpath = "//a[contains(@id,'buttonViewAllAccounts')]")
    WebElement viewAllAccountsButton;

    @FindBy(xpath = "//span[contains(@id,'LnkDebit')]")
    WebElement debitCardAccountDropDownBox;

    @FindBy(xpath = "//span[contains(@id,'lblAvailableBalance')]")
    WebElement accountBalanceField;

    @FindBy(xpath = "//input[contains(@id, 'buttonClose')]")
    WebElement exitButton;


    public InternetBankingPage(WebDriver driver) {
        super(driver, INTERNET_BANKING_PAGE.getUrl());
    }
}
