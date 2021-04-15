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

    @FindBy(xpath = "//a[@id='MenuTreeViewn27']")
    WebElement localCurrencyTransfer;

    @FindBy(css = "#aspx_preferredaccount_preferredaccount_ascx0bb0805d-9a8f-4f1b-bf33-b86668544f51_buttonViewAllAccounts")
    WebElement viewAllAccountsButton;

    @FindBy(css = "#aspx_accountinformation_accountsummary_ascxACCOUNT_SUMMARY640940dd-3e37-41cd-822a-bba61e2403f5_ImageDebitAccountSummaryLinkButton")
    WebElement debitCardAccountDropDownBox;

    @FindBy(css = "#aspx_accountinformation_accountsummary_ascxACCOUNT_SUMMARY640940dd-3e37-41cd-822a-bba61e2403f5_grdDebitAccountHeader_grdDebitAccountDetails_0_lblAvailableBalance_0")
    WebElement accountBalanceField;

    public InternetBankingPage(WebDriver driver) {
        super(driver, String.valueOf(INTERNET_BANKING_PAGE));
    }
}