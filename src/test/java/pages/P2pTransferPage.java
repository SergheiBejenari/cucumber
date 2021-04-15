package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.common.BasePage;

import static enums.Pages.P2P_PAGE;

@Getter
public class P2pTransferPage extends BasePage {

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

    @FindBy(xpath = "//a[contains(text(),'Success')]")
    WebElement successMessage;

    public P2pTransferPage(WebDriver driver) {
        super(driver, String.valueOf(P2P_PAGE));
    }

    public boolean success() {
        if (successMessage.getText().toString().contains("Success")) {
            return true;
        } else
            return false;
    }

    public void select(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText("3");
    }
}