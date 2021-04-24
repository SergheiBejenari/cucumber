package steps;

import driver.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.User;
import org.openqa.selenium.WebDriver;
import pages.*;
import service.UserCreator;
import service.Wait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static service.ScenarioContext.TRANSACTION_AMOUNT;

public class TransferFundsStep {

    private final WebDriver driver = Driver.getDriver();
    private final HomePage homePage = new HomePage(driver);
    private final P2pTransferPage p2pTransferPage = new P2pTransferPage(driver);
    private final InternetBankingPage internetBankingPage = new InternetBankingPage(driver);
    private final AccountStatementPage accountStatementPage = new AccountStatementPage(driver);
    private final LogInPage logInPage = new LogInPage(driver);
    private final CommonSteps commonSteps = new CommonSteps(
            internetBankingPage,
            logInPage,
            p2pTransferPage,
            homePage,
            accountStatementPage
    );
    private final Wait wait = new Wait(Driver.getDriver());
    private final User firstUser = UserCreator.createFirstUser();
    private final User secondUser = UserCreator.createSecondUser();

    @Given("Users have positive bill")
    public void usersHavePositiveBill() {
        commonSteps.logInUser(firstUser);
        commonSteps.verifyBalance(firstUser);
        commonSteps.logInUser(secondUser);
        commonSteps.verifyBalance(secondUser);
    }

    @When("User is willing to perform Person To Person transfer {string} to another User")
    public void userIsWillingToPerformPersonToPersonTransferAmountToAnotherUser(String field, DataTable dataTable) {
        Driver.getDriver().get(homePage.getUrl());
        wait.click(homePage.getMaibOnline());
        wait.click(homePage.getP2pTransferButton());
        commonSteps.createSender(firstUser);
        commonSteps.createReceiver(secondUser);
        wait.click(p2pTransferPage.getAmountField());
        p2pTransferPage.fillForm(dataTable);
        wait.click(p2pTransferPage.getAgreeCheckBox());
    }

    @And("Success message is displayed")
    public void successMessageIsDisplayed() {
        assertTrue("Success message is displayed", p2pTransferPage.success());
    }

    @Then("The funds were debited in the amount in which they were sent")
    public void theFundsWereDebitedInTheAmountInWhichTheyWereSent() {
        commonSteps.logInUser(firstUser);
        commonSteps.verifyBalance(firstUser);
        double initialBalance = firstUser.getBalanceHistory().get(0);
        double balanceAfterTransaction = firstUser.getBalanceHistory().get(1);
        assertEquals("Money were transferred successfully",
                (initialBalance - balanceAfterTransaction), TRANSACTION_AMOUNT, 0.0);
    }

    @And("The outgoing Person To Person transfer operation appears on the client's statement")
    public void theOutgoingPersonToPersonTransferOperationAppearsOnTheClientSStatement() {
        commonSteps.logInUser(firstUser);
        commonSteps.getLastTransactions();
        double actualTransactionAmount = Double.parseDouble(accountStatementPage.getDebitField().getText());
        double expectedTransactionAmount = -TRANSACTION_AMOUNT;
        assertEquals("Current amount equals transferred amount", expectedTransactionAmount, actualTransactionAmount);
    }

    @And("The incoming Person To Person transfer operation appears on another client's statement")
    public void theIncomingPersonToPersonTransferOperationAppearsOnAnotherClientSStatement() {
        commonSteps.logInUser(secondUser);
        commonSteps.getLastTransactions();
        double actualTransactionAmount = Double.parseDouble(accountStatementPage.getDebitField().getText());
        assertEquals("Current amount equals transferred amount", TRANSACTION_AMOUNT, actualTransactionAmount);
    }

    @And("The user's account has increased by the amount of money that was sent")
    public void theUserSAccountHasIncreasedByTheAmountOfMoneyThatWasSent() {
        commonSteps.logInUser(secondUser);
        commonSteps.verifyBalance(secondUser);
        double initialBalance = secondUser.getBalanceHistory().get(0);
        double balanceAfterTransaction = secondUser.getBalanceHistory().get(1);
        assertEquals("Money were transferred successfully",
                (balanceAfterTransaction - initialBalance), TRANSACTION_AMOUNT, 0.0);
    }
}