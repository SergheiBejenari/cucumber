package steps;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountStatementPage;
import pages.HomePage;
import pages.InternetBankingPage;
import pages.P2pTransferPage;
import service.UserCreator;
import service.Wait;
import tests.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransferFundsStep {

    private final HomePage homePage = new HomePage(Driver.getDriver());
    private final P2pTransferPage p2pTransferPage = new P2pTransferPage(Driver.getDriver());
    private final InternetBankingPage internetBankingPage = new InternetBankingPage(Driver.getDriver());
    private final CommonSteps commonSteps = new CommonSteps();
    private final AccountStatementPage accountStatementPage = new AccountStatementPage(Driver.getDriver());
    Wait wait = new Wait(Driver.getDriver());

    @Given("Users have positive bill")
    public void usersHavePositiveBill() {
        Driver.getDriver().get(homePage.getUrl());
        commonSteps.logInUser("User1", "qwerty123456");
        commonSteps.verifyBalance("User1", UserCreator.USER_1_AMOUNT, Test.isPositiveBillUser1());
        commonSteps.logInUser("User2", "qwerty98765");
        commonSteps.verifyBalance("User2", UserCreator.USER_2_AMOUNT, Test.isPositiveBillUser2());
    }

    @When("User is willing to perform Person To Person transfer amount to another User")
    public void userIsWillingToPerformPersonToPersonTransferAmountToAnotherUser() {
        wait.click(homePage.getMaibOnline());
        wait.click(homePage.getP2pTransferButton());
        commonSteps.createSenders("1234567890123456", "3", "2021");
        wait.sendKeys(p2pTransferPage.getAmountField(), "50");
        commonSteps.createReceivers("1234567890123456", "Serghei", "CardHolder");
        wait.click(p2pTransferPage.getAgreeCheckBox());
        wait.click(p2pTransferPage.getNotRobotCheckBox());
        Driver.closeDriver();
    }

    @And("Success message is displayed")
    public void successMessageIsDisplayed() {
        assertTrue("Success message is displayed", p2pTransferPage.success());
    }

    @Then("The funds were debited in the amount in which they were sent")
    public void theFundsWereDebitedInTheAmountInWhichTheyWereSent() {
        commonSteps.logInUser("User1", "qwerty123456");
        wait.click(internetBankingPage.getMenuButton());
        wait.click(internetBankingPage.getViewAllAccountsButton());
        wait.click(internetBankingPage.getDebitCardAccountDropDownBox());
        assertEquals("Money was transferred successfully", UserCreator.USER_1_AMOUNT,
                UserCreator.USER_1_AMOUNT_AFTER_TRANSFER);
        Driver.closeDriver();
    }

    @And("The outgoing Person To Person transfer operation appears on the client's statement")
    public void theOutgoingPersonToPersonTransferOperationAppearsOnTheClientSStatement() {
        commonSteps.logInUser("User1", "qwerty123456");
        commonSteps.getLastTransactions();
        UserCreator.USER_1_CURRENT_AMOUNT_AFTER_TRANSFER = Double.parseDouble(accountStatementPage.getDebitField().getText());
        assertEquals("Current amount equals transferred amount", UserCreator.USER_1_AMOUNT_AFTER_TRANSFER,
                UserCreator.USER_1_CURRENT_AMOUNT_AFTER_TRANSFER);
        Driver.closeDriver();
    }

    @And("The incoming Person To Person transfer operation appears on another client's statement")
    public void theIncomingPersonToPersonTransferOperationAppearsOnAnotherClientSStatement() throws InterruptedException {
        commonSteps.logInUser("User1", "qwerty123456");
        commonSteps.getLastTransactions();
        UserCreator.USER_2_CURRENT_AMOUNT_AFTER_TRANSFER = Double.parseDouble(accountStatementPage.getDebitField().getText());
        assertEquals("Current amount equals transferred amount", UserCreator.USER_2_AMOUNT_AFTER_TRANSFER,
                UserCreator.USER_2_CURRENT_AMOUNT_AFTER_TRANSFER);
        Driver.closeDriver();
    }

    @And("The user's account has increased by the amount of money that was sent")
    public void theUserSAccountHasIncreasedByTheAmountOfMoneyThatWasSent() throws InterruptedException {
        commonSteps.logInUser("User1", "qwerty123456");
        commonSteps.getLastTransactions();
        assertEquals("Money was transferred successfully", UserCreator.USER_2_AMOUNT,
                UserCreator.USER_2_AMOUNT_AFTER_TRANSFER);
        Driver.closeDriver();
    }
}