package steps;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InternetBankingPage;
import pages.LogInPage;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CommonSteps {
    private final InternetBankingPage internetBankingPage = new InternetBankingPage(Driver.getDriver());
    private final LogInPage logInPage = new LogInPage(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    public void logInUser(String userId, String password) throws InterruptedException {
        internetBankingPage.getIndividualsAuthenticationButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(logInPage.getLoginButton()));
        logInPage.loginUser(userId, password);
        logInPage.getLoginButton().click();
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