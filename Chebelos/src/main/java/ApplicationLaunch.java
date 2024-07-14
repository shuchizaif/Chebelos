import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ApplicationLaunch
{
private WebDriver driver;

//Constructor
    public ApplicationLaunch(WebDriver driver)
{
    this.driver= driver;

 }
//Application launch page locators
By SAStudentcheckbox = By.xpath("//label[@for='isLocalStudentInput2-input']//span[@class='mat-radio-inner-circle']");

    By StudentNumbercheckbox = By.xpath("//label[@for='hasStudentNumberInput1-input']//span[@class='mat-radio-inner-circle']");

    By Returningcheckbox =By.xpath("//label[@for='isReturningToApplicationInput1-input']//span[@class='mat-radio-inner-circle']");

//Action Methods

    public String readPageTitle()
    {
        String lauchpagetitle = driver.getTitle();
        System.out.println("Application launch Page title is " + lauchpagetitle);
         return lauchpagetitle;
    }

    public String readpageURL()
    {
        String launchPageUrl= driver.getCurrentUrl();
        System.out.println("Application Page Url is " + launchPageUrl);
        return launchPageUrl;
    }

    public boolean SouthAfricanStudentisSelected()
    {
        driver.findElement(SAStudentcheckbox).click();
        System.out.println("first checkbox is selected");
        return driver.findElement(SAStudentcheckbox).isEnabled();
    }

    public boolean StudentNumberisSelected()
    {
        driver.findElement(StudentNumbercheckbox).click();
        System.out.println("second checkbox is selected");
        return driver.findElement(StudentNumbercheckbox).isEnabled();
    }

        public boolean ReturningStudentisSelected()
        {
            driver.findElement(Returningcheckbox).click();
        System.out.println("third checkbox is selected");
        return driver.findElement(Returningcheckbox).isEnabled();
    }

}
