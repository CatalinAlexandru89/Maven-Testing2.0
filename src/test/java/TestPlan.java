import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
        PersonalInformation second = new PersonalInformation(driver);
        second.navigateToPersonalInformation();
    }

    //Test 3

    @Test(testName = "Contact information page")
    public static void goToContactInformation() {
        driver.get(Utils.SECOND_URL);
        PersonalInformation second = new PersonalInformation(driver);
        second.navigateToPersonalInformation();

        ContactInformation third = new ContactInformation(driver);
        third.navigateToContactInformation();
    }

    //Test 4

    @Test(testName = "Check course option")
    public static void testCourseOptions() {
        driver.get(Utils.SECOND_URL);
        PersonalInformation second = new PersonalInformation(driver);
        second.navigateToPersonalInformation();

        ContactInformation third = new ContactInformation(driver);
        third.navigateToContactInformation();

        CourseOptions fourth = new CourseOptions(driver);
        fourth.navigateToCourseOptions();
    }

    //Test 5

    @Test(testName = "Check payment information")
    public static void testCourseOptionAndPaymentInformation() {
        driver.get(Utils.SECOND_URL);
        PersonalInformation second = new PersonalInformation(driver);
        second.navigateToPersonalInformation();

        ContactInformation third = new ContactInformation(driver);
        third.navigateToContactInformation();

        CourseOptions fourth = new CourseOptions(driver);
        fourth.navigateToCourseOptions();

        PaymentInformation fifth = new PaymentInformation(driver);
        fifth.navigateToPaymentInformation();
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

    @Test(testName = "Check facebook Jane Doe")
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

    @Test(testName = "Check unhappy flow newsletter")
    public static void testUnhappyNewsletter() {
        driver.get(Utils.BASE_URL);
        MainPage testOpt = new MainPage(driver);
        testOpt.fillNewsletter();
        testOpt.clickSubmitNewsletter();
        Utils.waitForElementToLoad(5);
    }

    //Test 11

    @Test(testName = "Check happy flow newsletter")
    public static void testHappyNewsletter() {
        driver.get(Utils.BASE_URL);
        MainPage testNoua = new MainPage(driver);
        testNoua.fillNewsletterTwo();
        Utils.waitForElementToLoad(2);
        testNoua.clickSubmitNewsletterTwo();
        Utils.waitForElementToLoad(3);
        testNoua.closePopUpTwo();
        Utils.waitForElementToLoad(2);
    }

    //Test 12

    @Test(testName = "Navigate back to top")
    public static void testBackToTopButton() {
        driver.get(Utils.BASE_URL);
        MainPage testUnsprezece = new MainPage(driver);
        testUnsprezece.waitFooterScroll();
        Utils.waitForElementToLoad(2);
        testUnsprezece.clickArrowTop();
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(testUnsprezece.verifyTextHeaderDoi(), "Certified Software Tester");
        Utils.waitForElementToLoad(1);
    }

    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
