package pages;

import io.cucumber.datatable.DataTable;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;
import pages.common.FormService;

import java.util.Map;

import static enums.Pages.P2P_PAGE;

@Getter
public class P2pTransferPage extends BasePage implements FormService {

    @FindBy(xpath = "//body/div[@id='maib-p2p-app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement sendersCardNumberField;

    @FindBy(xpath = "//*[@id='transfer-intro-box']/div[1]/div[1]/div[1]/div[2]/div/div[1]")
    WebElement monthDropDownBox;

    @FindBy(xpath = "//*[@id='transfer-intro-box']/div[1]/div[1]/div[1]/div[2]/div/div[1]/ul")
    WebElement monthDropDownItems;

    @FindBy(xpath = "//*[@id='transfer-intro-box']/div[1]/div[1]/div[1]/div[2]/div/div[2]")
    WebElement yearDropDownBox;

    @FindBy(xpath = "//*[@id='transfer-intro-box']/div[1]/div[1]/div[1]/div[2]/div/div[2]/ul")
    WebElement yearDropDownItems;

    @FindBy(xpath = "//body/div[@id='maib-p2p-app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]")
    WebElement receiversCardNumberField;

    @FindBy(xpath = "//body/div[@id='maib-p2p-app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
    WebElement nameField;

    @FindBy(xpath = "//body/div[@id='maib-p2p-app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]")
    WebElement surnameField;

    @FindBy(xpath = "//*[@id='transfer-intro-box']/div[1]/div[2]/div[2]/input")
    WebElement amountField;

    @FindBy(xpath = "//span[contains(@class, 'checkbox-icon')]")
    WebElement agreeCheckBox;

    @FindBy(xpath = "//a[contains(text(),'Success')]")
    WebElement successMessage;

    public P2pTransferPage(WebDriver driver) {
        super(driver, P2P_PAGE.getUrl());
    }

    public boolean success() {
        return successMessage.getText().contains("Success");
    }

    @Override
    public void fillForm(final DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        amountField.sendKeys(data.get("amount"));
    }
}
