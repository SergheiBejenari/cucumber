package steps;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.InternetBankingPage;
import pages.LogInPage;
import pages.P2pTransferPage;
import service.UserCreator;
import tests.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransferFundsStep {

    private final HomePage homePage = new HomePage(Driver.getDriver());
    private final LogInPage logInPage = new LogInPage(Driver.getDriver());
    private final P2pTransferPage p2pTransferPage = new P2pTransferPage(Driver.getDriver());
    private final InternetBankingPage internetBankingPage = new InternetBankingPage(Driver.getDriver());
    private final CommonSteps commonSteps = new CommonSteps();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    @Given("Following users have positive bill")
    public void followingUsersHavePositiveBill() throws InterruptedException {
        Driver.getDriver().get(homePage.getUrl());
        wait.withTimeout(Duration.ofSeconds(20));
        homePage.getMaibOnline().click();
        Thread.sleep(2000);
        homePage.getInternetBanking().click();
        Thread.sleep(3000);
        commonSteps.logInUser("User1", "qwerty123456");
        Thread.sleep(10000);
        internetBankingPage.getViewAllAccountsButton().click();
        internetBankingPage.getDebitCardAccountDropDownBox().click();
        UserCreator.USER_1_AMOUNT = Double.parseDouble(internetBankingPage.getAccountBalanceField().getText());
        assertTrue("User1 have a positive Bill", Test.isPositiveBillUser1());
        Driver.closeDriver();

        //Login User2

        commonSteps.logInUser("User2", "qwerty98765");
        logInPage.getLoginButton().click();
        internetBankingPage.getViewAllAccountsButton().click();
        internetBankingPage.getDebitCardAccountDropDownBox().click();
        UserCreator.USER_2_AMOUNT = Double.parseDouble(internetBankingPage.getAccountBalanceField().getText());
        assertTrue("User2 have a positive Bill", Test.isPositiveBillUser2());
        Driver.closeDriver();
    }

    @When("User is willing to perform Person To Person transfer amount to another User")
    public void userIsWillingToPerformPersonToPersonTransferAmountToAnotherUser() {
        homePage.getMaibOnline().click();
        homePage.getP2pTransferButton().click();
        p2pTransferPage.getSendersCardNumberField().sendKeys("1234567890123456");
        p2pTransferPage.select(p2pTransferPage.getMonthDropDownBox(), "3");
        p2pTransferPage.select(p2pTransferPage.getYearDropDownBox(), "2023");
        p2pTransferPage.getAmountField().sendKeys("50");
        p2pTransferPage.getReceiversCardNumberField().sendKeys("1234567890123456");
        p2pTransferPage.getNameField().sendKeys("Serghei");
        p2pTransferPage.getSurnameField().sendKeys("Bejenari");
        p2pTransferPage.getAgreeCheckBox().click();
        p2pTransferPage.getNotRobotCheckBox().click();
        Driver.closeDriver();
    }

    @And("Success message is displayed")
    public void successMessageIsDisplayed() {
        assertTrue("Success message is displayed", p2pTransferPage.success());
    }

    @And("The funds were debited in the amount in which they were sent")
    public void theFundsWereDebitedInTheAmountInWhichTheyWereSent() throws InterruptedException {
        homePage.getMaibOnline().click();
        Thread.sleep(2000);
        homePage.getInternetBanking().click();
        Thread.sleep(3000);
        commonSteps.logInUser("User1", "qwerty123456");
        Thread.sleep(10000);
        internetBankingPage.getViewAllAccountsButton().click();
        internetBankingPage.getDebitCardAccountDropDownBox().click();
        assertEquals("Money was transferred successfully", UserCreator.USER_1_AMOUNT,
                                                                    UserCreator.USER_1_AMOUNT_AFTER_TRANSFER);
        Driver.closeDriver();
    }

    @Then("The user's account has increased by the amount of money that was sent")
    public void anotherUserDataCorrespondsToFollowingDetails() {

    }

    @And("The outgoing Person To Person transfer operation appears on the client's statement")
    public void theOutgoingPersonToPersonTransferOperationAppearsOnTheClientSStatement() {

    }

    @And("The incoming Person To Person transfer operation appears on another client's statement")
    public void theIncomingPersonToPersonTransferOperationAppearsOnAnotherClientSStatement() {

    }
}