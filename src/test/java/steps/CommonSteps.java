package steps;

import driver.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InternetBankingPage;
import pages.LogInPage;

public class CommonSteps {
    private final InternetBankingPage internetBankingPage = new InternetBankingPage(Driver.getDriver());
    private final LogInPage logInPage = new LogInPage(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    public void logInUser(String userId, String password) throws InterruptedException {
        internetBankingPage.getIndividualsAuthenticationButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(logInPage.getLoginButton()));
        Thread.sleep(9000);
        logInPage.loginUser(userId, password);
        Thread.sleep(10000);
        logInPage.getLoginButton().click();

    }
}
