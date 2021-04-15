package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;
import pages.common.FormService;

import java.util.Map;

import static enums.Pages.P2P_PAGE;

public class P2pTransferPage extends BasePage implements FormService {

    @FindBy(xpath = "//body/div[@id='maib-p2p-app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement sendersCardNumberField;

    @FindBy(xpath = "//span[contains(@class,'month')]")
    WebElement monthDropDownBox;

    @FindBy(xpath = "//span[contains(@class,'year')]")
    WebElement yearDropDownBox;

    @FindBy(xpath = "(//input[contains(@class,'check-value card-input-field select-input has-error')])[2]")
    WebElement receiversCardNumberField;

    @FindBy(xpath = "////body/div[@id='maib-p2p-app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
    WebElement nameField;

    @FindBy(xpath = "//body/div[@id='maib-p2p-app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]")
    WebElement surnameField;

    @FindBy(xpath = "//input[contains(@class,'check-value number-input has-error')]")
    WebElement amountField;

    @FindBy(xpath = "//span[contains(@class, 'checkbox-icon')]")
    WebElement agreeCheckBox;

    @FindBy(xpath = "//div[contains(@class,'recaptcha-checkbox-border')]")
    WebElement notRobotCheckBox;

    public P2pTransferPage(WebDriver driver) {
        super(driver, String.valueOf(P2P_PAGE));
    }

    @Override
    public void fillForm(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        sendersCardNumberField.sendKeys(data.get(""));
    }
}
