import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApplicationLaunchTest {

    private WebDriver driver;
    ApplicationLaunch launchPage;

@BeforeTest
    public void setUp() throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("https://applications-test.tut.ac.za/");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.body.style.zoom = '100%';");
        Thread.sleep(1500);
        launchPage = new ApplicationLaunch(driver);
    }
    @Test
    public void LaunchPageTitleTest() {
        String actTitle = launchPage.readPageTitle();
        SoftAssert obj = new SoftAssert();
        obj.assertEquals(actTitle, "ITS Infinity Applications Management");
        obj.assertAll();
        System.out.println("Assert is success");

    }

    @Test
    public void LaunchPageURLTest() {
        String actURL = launchPage.readpageURL();
        SoftAssert obj1 = new SoftAssert();
        obj1.assertEquals(actURL, "https://applications-test.tut.ac.za/");
        obj1.assertAll();
        System.out.println("Assert2 is success");
    }

    @Test
    public void SouthAfricanStudentisSelectedTest() throws InterruptedException {
        Assert.assertTrue(launchPage.SouthAfricanStudentisSelected(), "Checkbox SA Student is selected");
    }

    @Test
    public void StudentNumberisSelectedTest() throws InterruptedException {
        Assert.assertTrue(launchPage.StudentNumberisSelected(), "Checkbox Student Number is selected");
    }

    @Test
    public void ReturningStudentisSelectedTest() throws InterruptedException {
        Assert.assertTrue(launchPage.ReturningStudentisSelected(), "Checkbox ReturningStudent is selected");

    }

    public void tearDown() {
        driver.quit();
    }

}






