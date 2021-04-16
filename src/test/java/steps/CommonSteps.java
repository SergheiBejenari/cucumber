package steps;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import service.Wait;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertTrue;

public class CommonSteps {
    private final InternetBankingPage internetBankingPage = new InternetBankingPage(Driver.getDriver());
    private final LogInPage logInPage = new LogInPage(Driver.getDriver());
    private final P2pTransferPage p2pTransferPage = new P2pTransferPage(Driver.getDriver());
    private final HomePage homePage = new HomePage(Driver.getDriver());
    private final AccountStatementPage accountStatementPage = new AccountStatementPage(Driver.getDriver());
    service.Wait wait = new Wait(Driver.getDriver());

    public void logInUser(String userId, String password) {
        wait.click(homePage.getMaibOnline());
        wait.click(homePage.getInternetBanking());
        wait.click(internetBankingPage.getIndividualsAuthenticationButton());
        logInPage.getUserLoginIDField().clear();
        logInPage.loginUser(userId, password);
        wait.click(logInPage.getLoginButton());
    }

    public void verifyBalance(String user, Double amount, boolean isPositive) {
        wait.click(internetBankingPage.getMenuButton());
        wait.click(internetBankingPage.getViewAllAccountsButton());
        wait.click(internetBankingPage.getDebitCardAccountDropDownBox());
        amount = Double.parseDouble(internetBankingPage.getAccountBalanceField().getText());
        assertTrue(user + " have a positive Bill", isPositive);
        Driver.closeDriver();
    }

    public void createSenders(String cardNumber, String month, String year) {
        wait.sendKeys(p2pTransferPage.getSendersCardNumberField(), cardNumber);
        select(p2pTransferPage.getMonthDropDownBox(), month);
        select(p2pTransferPage.getYearDropDownBox(), year);
    }

    public void createReceivers(String cardNumber, String name, String surname) {
        wait.sendKeys(p2pTransferPage.getReceiversCardNumberField(), cardNumber);
        wait.sendKeys(p2pTransferPage.getNameField(), name);
        wait.sendKeys(p2pTransferPage.getSurnameField(), surname);
    }

    public void getLastTransactions() {
        wait.click(internetBankingPage.getMenuButton());
        wait.click(accountStatementPage.getAccountDropDownBox());
        select(accountStatementPage.getFromDateField(), getCurrentDate());
        select(accountStatementPage.getToDateField(), getCurrentDate());
        wait.click(accountStatementPage.getSubmitButton());
    }

    public void select(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public static String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return ZonedDateTime.now().format(formatter);
    }
}