import org.openqa.selenium.WebDriver;

public class PageNavigation {
    private static WebDriver driver;

    enum Pages {
        navigatePersonalInformation,
        navigateContactInformation,
        navigateCourseOptions,
        navigatePaymentInformation
    }

    public void navigateThroughPages(Pages page) {
        switch (page) {
            case navigatePersonalInformation:
                navigateToPersonalInformation();
                break;
            case navigateContactInformation:
                navigateToPersonalInformation();
                navigateToContactInformation();
                break;
            case navigateCourseOptions:
                navigateToPersonalInformation();
                navigateToContactInformation();
                navigateToCourseOptions();
                break;
            case navigatePaymentInformation:
                navigateToPersonalInformation();
                navigateToContactInformation();
                navigateToCourseOptions();
                navigateToPaymentInformation();
                break;
        }
    }

    private void navigateToPersonalInformation() {
        PersonalInformation firstPage = new PersonalInformation(driver);
        firstPage.fillFirstName();
        firstPage.fillLastName();
        firstPage.fillUserName();
        firstPage.fillPassword();
        firstPage.fillConfirmPassword();
        firstPage.clickNext();
    }

    private void navigateToContactInformation() {
        ContactInformation secondPage = new ContactInformation(driver);
        secondPage.fillEmail();
        secondPage.fillPhoneNumberThree();
        secondPage.fillCountry();
        secondPage.fillCity();
        secondPage.fillPostCode();
        secondPage.clickNextThree();
        secondPage.checkTextCourseOptions();
    }

    private void navigateToCourseOptions() {
        CourseOptions thirdPage = new CourseOptions(driver);
        thirdPage.clickAutomationAndManual();
        thirdPage.clickNextForth();
    }

    private void navigateToPaymentInformation() {
        PaymentInformation fourthPage = new PaymentInformation(driver);
        fourthPage.fillCardHolderName();
        fourthPage.fillCardNumber();
        fourthPage.fillCVC();
        fourthPage.clickMonthDropdown();
        fourthPage.clickPickMonth();
        fourthPage.clickYearDropdown();
        fourthPage.clickPickYear();
        fourthPage.clickNextFifth();
    }

    public PageNavigation(WebDriver driver) {
        this.driver = driver;
    }
}
