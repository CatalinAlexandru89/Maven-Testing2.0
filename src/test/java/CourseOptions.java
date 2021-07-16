import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseOptions extends PageObject {

    @FindBy(xpath = "//*[@id=\"flexRadioButton3\"]") //click Course Option
    private WebElement automationAndManual;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/button[2]")
    private WebElement nextForth;

    public void clickAutomationAndManual() {
        this.automationAndManual.click();
    }
    public void clickNextForth() {
        this.nextForth.click();
    }

    public void navigateToCourseOptions() {
        clickAutomationAndManual();
        clickNextForth();
    }

    public CourseOptions(WebDriver driver) {
        super(driver);
    }
}
