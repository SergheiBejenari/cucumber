package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundsTransferPage {

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_ddlPayerAccount")
    WebElement payerAccountDropDown;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_ddlBeneficiaryAccount")
    WebElement beneficiaryDropDown;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_btnCreateBeneficiary")
    WebElement createBeneficiaryButton;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_btnEditBeneficiary")
    WebElement editBeneficiaryButton;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_txtAmount")
    WebElement amountField;

    @FindBy(xpath = "//textarea[@id='txtPaymentDetails']")
    WebElement paymentDetailsField;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_rdoNormal")
    WebElement normalTransferTypeCheckBox;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_rdoImmediate")
    WebElement immediateTransferTypeCheckBox;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_rdoUrgant")
    WebElement urgentTransferTypeCheckBox;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_rdoFutureDated")
    WebElement futureDatedTransferTypeCheckBox;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_rdRecPayment")
    WebElement setupAsRecurringPaymentCheckBox;

    @FindBy(css = "#chkSaveAsTemplate")
    WebElement saveAsTemplateCheckBox;

    @FindBy(xpath = "//input[@id='txtTemplateName']")
    WebElement templateNameField;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    WebElement submitButton;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCY284f78f8-6c7c-488d-b6d6-309a6e924444_buttonCancel")
    WebElement cancelButton;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCYe142b8b7-c4fb-4d17-b767-64aba7df78c7_btnMPENoticeYes")
    WebElement acceptPopupButton;

    @FindBy(css = "#aspx_fundstransfer_transferlocalcurrency_ascxTRANSFER_LOCAL_CURRENCYe142b8b7-c4fb-4d17-b767-64aba7df78c7_btnMPENoticeNo")
    WebElement rejectPopupButton;
}
