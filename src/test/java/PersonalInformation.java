import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformation extends PageObject {

    private final String TypeFirstName = "Jack";
    private final String TypeLastName = "Daniels";
    private final String TypeUsername = "Jack89";
    private final String TypePassword = "***********";
    private final String TypeConfirmPassword = "***********";

    @FindBy(xpath = "/html/body/section[1]/div/div/div/a")
    private WebElement startEnrollment;
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstName;
    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement lastName;
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement userName;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"cpassword\"]")
    private WebElement confirmPassword;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[1]/button")
    private WebElement next;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/h3")
    private WebElement textContactInformation;

    public void clickStartEnrollment() {
        this.startEnrollment.click();
    }
    public void fillFirstName() {
        this.firstName.sendKeys(TypeFirstName);
    }
    public void fillLastName() {
        this.lastName.sendKeys(TypeLastName);
    }
    public void fillUserName() {
        this.userName.sendKeys(TypeUsername);
    }
    public void fillPassword() {
        this.password.sendKeys(TypePassword);
    }
    public void fillConfirmPassword() {
        this.confirmPassword.sendKeys(TypeConfirmPassword);
    }
    public void clickNext() {
        this.next.click();
    }
    public String checkTextContactInformation() {
        return this.textContactInformation.getText();
    }

    public void navigateToPersonalInformation() {
        fillFirstName();
        fillLastName();
        fillUserName();
        fillPassword();
        fillConfirmPassword();
        Utils.waitForElementToLoad(2);
        clickNext();
        Utils.waitForElementToLoad(1);
        checkTextContactInformation();
        Utils.waitForElementToLoad(1);
    }

    public PersonalInformation(WebDriver driver) {
        super(driver);
    }
}
