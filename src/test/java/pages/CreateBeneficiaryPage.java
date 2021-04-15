package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBeneficiaryPage {

    @FindBy(css = "#aspx_maintainbeneficiarylocalcurrency_setupbeneficiarylocalcurrency_ascxTRANSFER_LOCAL_CURRENCY79689330-dd93-4202-ac3a-71abe3ef699c_txtAccountNumber")
    WebElement beneficiaryIbanField;

    @FindBy(xpath = "//textarea[@id='txtBeneficiaryName']")
    WebElement beneficiaryNameField;

    @FindBy(css = "#aspx_maintainbeneficiarylocalcurrency_setupbeneficiarylocalcurrency_ascxTRANSFER_LOCAL_CURRENCY79689330-dd93-4202-ac3a-71abe3ef699c_CheckRes")
    WebElement residentCheckBox;

    @FindBy(css = "#aspx_maintainbeneficiarylocalcurrency_setupbeneficiarylocalcurrency_ascxTRANSFER_LOCAL_CURRENCY79689330-dd93-4202-ac3a-71abe3ef699c_txtFiscalCode")
    WebElement fiscalCodeField;

    @FindBy(css = "#aspx_maintainbeneficiarylocalcurrency_setupbeneficiarylocalcurrency_ascxTRANSFER_LOCAL_CURRENCY79689330-dd93-4202-ac3a-71abe3ef699c_txtBankCode")
    WebElement bankCodeField;

    @FindBy(css = "#aspx_maintainbeneficiarylocalcurrency_setupbeneficiarylocalcurrency_ascxTRANSFER_LOCAL_CURRENCY79689330-dd93-4202-ac3a-71abe3ef699c_txtBankName")
    WebElement bankNameField;

    @FindBy(xpath = "//textarea[@id='txtPaymentDestination']")
    WebElement paymentDescriptionField;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    WebElement submitButton;

    @FindBy(css = "#aspx_maintainbeneficiarylocalcurrency_setupbeneficiarylocalcurrency_ascxTRANSFER_LOCAL_CURRENCY79689330-dd93-4202-ac3a-71abe3ef699c_btnBack")
    WebElement backButton;

    @FindBy(css = "#aspx_maintainbeneficiarylocalcurrency_setupbeneficiarylocalcurrency_ascxTRANSFER_LOCAL_CURRENCY79689330-dd93-4202-ac3a-71abe3ef699c_btnCancel")
    WebElement cancelButton;

    @FindBy(xpath = "//input[@id='btnOK']")
    WebElement okPopupButton;
}