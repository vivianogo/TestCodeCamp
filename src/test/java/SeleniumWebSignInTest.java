import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignInTest {
    //importing selenium webDriver
    private WebDriver driver;

    @BeforeTest
    public void begin() throws InterruptedException {
        //Locate Chrome Driver directory
        System.setProperty("web-driver.chrome.driver","resources/chromedriver.exe");
        //Open your browser
        driver = new ChromeDriver();
        //1.Input konga URL("https://www.konga.com/")
        driver.get("https://www.konga.com/");
        if(driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("Success");
        else
            System.out.println("Incorrect web page");
        //Wait for 5ms
        Thread.sleep(5000);
        //2.Maximise browser window
        driver.manage().window().maximize();
        //3. Display the title of the page
        System.out.println(driver.getTitle());
        //4.Click on sig in/signup button to open the login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
    }

    @Test (priority = 0)
        public void negativeSignIn() throws InterruptedException {
        //5.Input Email address in the Email Address or Phone Number field
        driver.findElement(By.id("username")).sendKeys("ogochukwu@mailinatior.com");

        //6.Input Password in the Password field
        driver.findElement(By.id("password")).sendKeys("ogochukwu@mailinatior.com");
        //7.Click on login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //Wait again for 5ms
        Thread.sleep(5000);
    }
    @Test (priority = 1)
        public void Clickonlogout() throws InterruptedException {
        //8.Click logout
        driver.findElement(By.name("logout")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 2)
        public void positiveSignIn() throws InterruptedException {
            //
            //5.Input Email address in the Email Address or Phone Number field
            driver.findElement(By.id("username")).sendKeys("ogochukwu@mailinatior.");

            //6.Input Password in the Password field
            driver.findElement(By.id("password")).sendKeys("ogochukwu@mailinatior.");
            //7.Click on login button
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            //Wait again for 5ms
            Thread.sleep(5000);

        }
    @Test (priority = 3)
        public void ClickonlogoutAgain() throws InterruptedException {
           //8.Click logout
            driver.findElement(By.name("logout")).click();
            Thread.sleep(5000);
        }
        private void closeBrowser() {
            //9.close browser
            driver.quit();
        }


}
