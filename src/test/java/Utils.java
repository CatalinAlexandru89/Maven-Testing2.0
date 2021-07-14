import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Utils {
    final static String CHROME_DRIVER_LOCATION = "C:\\Users\\stephanie\\Desktop\\Marven-Testing v2.0\\chromedriver.exe";
    final static String BASE_URL = "C:/Users/stephanie/Desktop/Testing-Env/index.html#";
    final static String SECOND_URL = "C:/Users/stephanie/Desktop/Testing-Env/routes/enrollment.html";
    final static String FORTH_URL = "C:/Users/stephanie/Desktop/Testing-Env/routes/virtual.html";
    final static String FIFTH_URL = "C:/Users/stephanie/Desktop/Testing-Env/routes/hybrid.html";
    final static String SIXTH_URL = "C:/Users/stephanie/Desktop/Testing-Env/routes/in_person.html";
    final static String FACEBOOK_URL = "https://www.facebook.com/";
    final static String LINKEDIN_URL = "https://www.linkedin.com/";
    final static String INSTAGRAM_URL = "https://www.instagram.com/";

    public static void waitForElementToLoad(int timeUnit) {
        try {
            TimeUnit.SECONDS.sleep(timeUnit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForElementToLoad(3);
    }
    public static void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }

}