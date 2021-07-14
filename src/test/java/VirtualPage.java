import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VirtualPage extends PageObject {

    @FindBy(xpath = "/html/body/a")
    private WebElement returnVirtual;

    public void clickReturnVirtual() {
        this.returnVirtual.click();
    }

    public VirtualPage(WebDriver driver) {
        super(driver);
    }
}
