import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentInformation extends PageObject {

    private final String TypeCardHolderName = "Jack Daniels";
    private final String TypeCardNumber = "3547-3321-0897-6589";
    private final String TypeCVC = "203";

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[2]/input")
    private WebElement cardHolderName;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[1]/input")
    private WebElement cardNumber;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[2]/input")
    private WebElement CVC;
    @FindBy(xpath = "//*[@id=\"month\"]")
    private WebElement monthDropdown;
    @FindBy(xpath = "//*[@id=\"month\"]/option[8]")
    private WebElement pickMonth;
    @FindBy(xpath = "//*[@id=\"year\"]")
    private WebElement yearDropdown;
    @FindBy(xpath = "//*[@id=\"year\"]/option[11]")
    private WebElement pickYear;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[4]/button[2]")
    private WebElement nextFifth;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[5]/h3")
    private WebElement textSuccess;

    public void fillCardHolderName() {
        this.cardHolderName.sendKeys(TypeCardHolderName);
    }
    public void fillCardNumber() {
        this.cardNumber.sendKeys(TypeCardNumber);
    }
    public void fillCVC() {
        this.CVC.sendKeys(TypeCVC);
    }
    public void clickMonthDropdown() {
        this.monthDropdown.click();
    }
    public void clickPickMonth() {
        this.pickMonth.click();
    }
    public void clickYearDropdown() {
        this.yearDropdown.click();
    }
    public void clickPickYear() {
        this.pickYear.click();
    }
    public void clickNextFifth() {
        this.nextFifth.click();
    }
    public String checkTextSuccess() {
        return this.textSuccess.getText();
    }

    public void navigateToPaymentInformation() {
        fillCardHolderName();
        fillCardNumber();
        fillCVC();
        Utils.waitForElementToLoad(2);
        clickMonthDropdown();
        Utils.waitForElementToLoad(1);
        clickPickMonth();
        clickYearDropdown();
        Utils.waitForElementToLoad(1);
        clickPickYear();
        Utils.waitForElementToLoad(2);
        clickNextFifth();
        checkTextSuccess();
        Utils.waitForElementToLoad(2);
    }

    public PaymentInformation(WebDriver driver) {
        super(driver);
    }
}
