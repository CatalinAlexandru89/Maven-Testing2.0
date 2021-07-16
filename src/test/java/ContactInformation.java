import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformation extends PageObject{

    private final String TypeEmail = "jack_daniels89@gmail.com";
    private final String TypeCountry = "Romania";
    private final String TypeCity = "Brasov";
    private final String TypePostCode = "500789";
    private final String TypePhoneNumber = "0799.899.999";
    private final String SecondTypePhoneNumber = "0799-222-101";

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[1]/button")
    private WebElement next;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneNumber;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneNumberTwo;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneNumberThree;
    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElement country;
    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement city;
    @FindBy(xpath = "//*[@id=\"postCode\"]")
    private WebElement postCode;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/button[2]")
    private WebElement nextThree;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/h3")
    private WebElement textCourseOptions;

    public void fillEmail() {
        this.email.sendKeys(TypeEmail);
    }
    public void fillPhoneNumber() {
        this.phoneNumber.sendKeys(TypePhoneNumber);
    }
    public void deletePhoneNumber() {
        this.phoneNumberTwo.clear();
    }
    public void fillPhoneNumberThree() {
        this.phoneNumber.sendKeys(SecondTypePhoneNumber);
    }
    public void fillCountry() {
        this.country.sendKeys(TypeCountry);
    }
    public void fillCity() {
        this.city.sendKeys(TypeCity);
    }
    public void fillPostCode() {
        this.postCode.sendKeys(TypePostCode);
    }
    public void clickNextThree() {
        this.nextThree.click();
    }
    public String checkTextCourseOptions() {
        return this.textCourseOptions.getText();
    }

    public void navigateToContactInformation() {
        fillEmail();
        fillPhoneNumberThree();
        fillCountry();
        fillCity();
        fillPostCode();
        clickNextThree();
        checkTextCourseOptions();
    }

    public ContactInformation(WebDriver driver) {
        super(driver);
    }
}
