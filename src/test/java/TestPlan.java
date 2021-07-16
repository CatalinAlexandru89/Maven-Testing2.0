import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.security.PrivateKey;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    //Test 1

    @Test(testName = "Click Questions Navbar")
    public static void clickButtonOne() {
        driver.get(Utils.BASE_URL);
        MainPage firstTest = new MainPage(driver);
        firstTest.clickQuestionsNavbar();
        Utils.waitForElementToLoad(3);
        firstTest.clickQuestionOne();
        Utils.waitForElementToLoad(2);
        firstTest.clickQuestionTwo();
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(firstTest.checkTextTestOne(), "Frequently Asked Questions");
    }

    //Test 2

    @Test(testName = "Click start enrollment and Personal Information Page")
    public static void clickStartEnrollment() {
        driver.get(Utils.BASE_URL);
        PersonalInformation secondTest = new PersonalInformation(driver);
        secondTest.clickStartEnrollment();
        Utils.waitForElementToLoad(2);

        driver.get(Utils.SECOND_URL);
        secondTest.fillFirstName();
        secondTest.fillLastName();
        secondTest.fillUserName();
        secondTest.fillPassword();
        secondTest.fillConfirmPassword();
        Utils.waitForElementToLoad(3);
        secondTest.clickNext();
        Utils.waitForElementToLoad(1);
        Assert.assertEquals(secondTest.checkTextContactInformation(), "Contact information");
        Utils.waitForElementToLoad(2);
    }

    //Test 2.5

    @Test(testName = "Click start enrollment and Personal Information Page negative flow")
    public static void clickStartEnrollmentTwo() {
        driver.get(Utils.BASE_URL);
        PersonalInformation secondTestTwo = new PersonalInformation(driver);
        secondTestTwo.clickStartEnrollment();
        Utils.waitForElementToLoad(2);

        driver.get(Utils.SECOND_URL);
        secondTestTwo.fillFirstName();
        secondTestTwo.fillPassword();
        secondTestTwo.fillConfirmPassword();
        Utils.waitForElementToLoad(2);
        secondTestTwo.clickNext();
        Utils.waitForElementToLoad(3);
    }

    //Test 3

    @Test(testName = "Contact information page")
    public static void goToContactInformation() {
        driver.get(Utils.SECOND_URL);
        PageNavigation thirdTest = new PageNavigation(driver);
        thirdTest.navigateThroughPages(PageNavigation.Pages.navigatePersonalInformation);

        ContactInformation third = new ContactInformation(driver);
        Utils.waitForElementToLoad(1);
        third.fillEmail();
        third.fillPhoneNumber();
        Utils.waitForElementToLoad(2);
        third.deletePhoneNumber();
        Utils.waitForElementToLoad(1);
        third.fillPhoneNumberThree();
        third.fillCountry();
        third.fillCity();
        third.fillPostCode();
        Utils.waitForElementToLoad(1);
        third.clickNextThree();
        Assert.assertEquals(third.checkTextCourseOptions(), "Course options");
        Utils.waitForElementToLoad(2);
    }

    //Test 4

    @Test(testName = "Check course options")
    public static void testCourseOptions() {
        driver.get(Utils.SECOND_URL);
        PageNavigation fourthTest = new PageNavigation(driver);
        fourthTest.navigateThroughPages(PageNavigation.Pages.navigateContactInformation);

        CourseOptions fourth = new CourseOptions(driver);
        fourth.clickAutomationAndManual();
        Utils.waitForElementToLoad(3);
        fourth.clickNextForth();
    }

    //Test 5

    @Test(testName = "Check payment information")
    public static void testPaymentInformation() {
        driver.get(Utils.SECOND_URL);
        PageNavigation fifthTest = new PageNavigation(driver);
        fifthTest.navigateThroughPages(PageNavigation.Pages.navigateCourseOptions);

        PaymentInformation fifth = new PaymentInformation(driver);
        Utils.waitForElementToLoad(2);
        fifth.fillCardHolderName();
        fifth.fillCardNumber();
        fifth.fillCVC();
        Utils.waitForElementToLoad(2);
        fifth.clickMonthDropdown();
        Utils.waitForElementToLoad(3);
        fifth.clickPickMonth();
        Utils.waitForElementToLoad(2);
        fifth.clickYearDropdown();
        Utils.waitForElementToLoad(3);
        fifth.clickPickYear();
        Utils.waitForElementToLoad(2);
        fifth.clickNextFifth();
        Utils.waitForElementToLoad(1);
        Assert.assertEquals(fifth.checkTextSuccess(), "Success!");
        Utils.waitForElementToLoad(3);
    }

    //Test 6

    @Test(testName = "Check Virtual read more")
    public static void testVirtualReadMore() {
        driver.get(Utils.BASE_URL);
        MainPage sixthTest = new MainPage(driver);
        sixthTest.waitVirtualScroll();
        sixthTest.clickVirtualReadMore();
        Utils.waitForElementToLoad(2);

        driver.get(Utils.FORTH_URL);
        VirtualPage sixth = new VirtualPage(driver);
        sixth.clickReturnVirtual();
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(sixthTest.checkTextTestFour(), "Virtual");
    }

    //Test 7

    @Test(testName = "Check hybrid read more")
    public static void testHybridReadMore() {
        driver.get(Utils.BASE_URL);
        MainPage seventhTest = new MainPage(driver);
        seventhTest.waitHybridScroll();
        seventhTest.clickHybridReadMore();
        Utils.waitForElementToLoad(2);

        driver.get(Utils.FIFTH_URL);
        HybridPage seventh = new HybridPage(driver);
        seventh.clickReturnHybrid();
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(seventhTest.checkTextTestFive(), "Hybrid");
    }

    //Test 8

    @Test(testName = "Check In Person read more")
    public static void testInPersonReadMore() {
        driver.get(Utils.BASE_URL);
        MainPage eighthTest = new MainPage(driver);
        eighthTest.waitInPersonScroll();
        eighthTest.clickInPersonReadMore();
        Utils.waitForElementToLoad(2);

        driver.get(Utils.SIXTH_URL);
        InPersonPage eighth = new InPersonPage(driver);
        eighth.clickReturnInPerson();
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(eighthTest.checkTextTestSix(), "In Person");
    }

    //Test 9

    @Test(testName = "Check social media Jane Doe")
    public static void testFacebookJaneDoe() {
        driver.get(Utils.BASE_URL);
        MainPage ninthTest = new MainPage(driver);
        ninthTest.clickInstructorsNavBar();
        Utils.waitForElementToLoad(3);
        Assert.assertEquals(ninthTest.checkTextTestSeventh(), "Our Instructors");
        ninthTest.clickFacebookJaneDoe();
        Utils.waitForElementToLoad(3);

        driver.get(Utils.FACEBOOK_URL);
        ninthTest.back();
        Utils.waitForElementToLoad(3);
        Assert.assertEquals(ninthTest.checkTextTestSeventh(), "Our Instructors");

        driver.get(Utils.BASE_URL);
        ninthTest.clickLinkedInJaneDoe();
        Utils.waitForElementToLoad(3);

        driver.get(Utils.LINKEDIN_URL);
        ninthTest.back();
        Utils.waitForElementToLoad(3);
        Assert.assertEquals(ninthTest.checkTextTestSeventh(), "Our Instructors");

        driver.get(Utils.BASE_URL);
        ninthTest.clickInstagramJaneDoe();
        Utils.waitForElementToLoad(3);

        driver.get(Utils.INSTAGRAM_URL);
        ninthTest.back();
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(ninthTest.checkTextTestSeventh(), "Our Instructors");
    }

    //Test 10

    @Test(testName = "Check negative flow newsletter")
    public static void testUnhappyNewsletter() {
        driver.get(Utils.BASE_URL);
        MainPage tenthTest = new MainPage(driver);
        tenthTest.fillNewsletter();
        tenthTest.clickSubmitNewsletter();
        Utils.waitForElementToLoad(5);
    }

    //Test 11

    @Test(testName = "Check happy flow newsletter")
    public static void testHappyNewsletter() {
        driver.get(Utils.BASE_URL);
        MainPage eleventhTest = new MainPage(driver);
        eleventhTest.fillNewsletterTwo();
        Utils.waitForElementToLoad(2);
        eleventhTest.clickSubmitNewsletterTwo();
        Utils.waitForElementToLoad(3);
        eleventhTest.closePopUpTwo();
        Utils.waitForElementToLoad(2);
    }

    //Test 12

    @Test(testName = "Navigate back to top")
    public static void testBackToTopButton() {
        driver.get(Utils.BASE_URL);
        MainPage twelfthTest = new MainPage(driver);
        twelfthTest.waitFooterScroll();
        Utils.waitForElementToLoad(2);
        twelfthTest.clickArrowTop();
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(twelfthTest.verifyTextHeaderDoi(), "Certified Software Tester");
        Utils.waitForElementToLoad(1);
    }

    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
