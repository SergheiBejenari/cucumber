package pages;

import enums.Pages;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;

@Getter
public class AccountStatementPage extends BasePage {

    @FindBy(xpath = "//select[contains(@id,'ddlAccount')]")
    WebElement accountDropDownBox;

    @FindBy(xpath = "//input[@id='txtfromDate']")
    WebElement fromDateField;

    @FindBy(xpath = "//input[@id='txtToDate']")
    WebElement toDateField;

    @FindBy(xpath = "//input[contains(@id,'btnSubmit')]")
    WebElement submitButton;

    @FindBy(xpath = "//input[contains(@id,'btnCancel')]")
    WebElement cancelButton;

    @FindBy(xpath = "//input[contains(@id,'btnClear')]")
    WebElement deleteButton;

    @FindBy(xpath = "//span[contains(@id,'lblDebit_0')]")
    WebElement debitField;

    public AccountStatementPage(WebDriver driver) {
        super(driver, String.valueOf(Pages.ACCOUNT_STATEMENT_PAGE));
    }
}
