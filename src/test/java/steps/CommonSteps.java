package steps;

import driver.Driver;
import lombok.RequiredArgsConstructor;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import service.Wait;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RequiredArgsConstructor
public class CommonSteps {
    private final InternetBankingPage internetBankingPage;
    private final LogInPage logInPage;
    private final P2pTransferPage p2pTransferPage;
    private final HomePage homePage;
    private final AccountStatementPage accountStatementPage;
    service.Wait wait = new Wait(Driver.getDriver());

    public void logInUser(User user) {
        Driver.getDriver().get(homePage.getUrl());
        wait.click(homePage.getMaibOnline());
        wait.click(homePage.getInternetBanking());
        wait.click(internetBankingPage.getIndividualsAuthenticationButton());
        Driver.switchToActualTab();
        logInPage.getUserLoginIDField().clear();
        logInPage.loginUser(user.getUserLoginId(), user.getPassword());
        wait.click(logInPage.getLoginButton());
    }

    public void verifyBalance(User user) {
        wait.click(internetBankingPage.getMenuButton());
        wait.click(internetBankingPage.getViewAllAccountsButton());
        wait.click(internetBankingPage.getDebitCardAccountDropDownBox());
        wait.waitField(internetBankingPage.getAccountBalanceField());
        double amount = Double.parseDouble(internetBankingPage.getAccountBalanceField().getText().replace(",", ""));
        assertTrue(amount > 30);
        user.getBalanceHistory().add(amount);
    }

    public void createSender(User user) {
        wait.sendKeys(p2pTransferPage.getSendersCardNumberField(), user.getCardNumber());
        wait.click(p2pTransferPage.getMonthDropDownBox());
        List<WebElement> months = p2pTransferPage.getMonthDropDownItems().findElements(By.tagName("li"));
        months.get(Integer.parseInt(user.getExpirationMonth()) - 1).click();
        wait.click(p2pTransferPage.getYearDropDownBox());
        List<WebElement> years = p2pTransferPage.getYearDropDownItems().findElements(By.tagName("li"));
        Optional<WebElement> first = years.stream()
                .filter(item -> item.getText().equals(user.getExpirationYear()))
                .findFirst();
        first.ifPresent(el -> wait.click(el));
    }

    public void createReceiver(User user) {
        wait.sendKeys(p2pTransferPage.getReceiversCardNumberField(), user.getCardNumber());
        wait.sendKeys(p2pTransferPage.getNameField(), user.getFirstName());
        wait.sendKeys(p2pTransferPage.getSurnameField(), user.getLastName());
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