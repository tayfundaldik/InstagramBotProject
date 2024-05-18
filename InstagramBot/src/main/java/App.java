import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class App extends Locators {
    WebDriver driver;
    // Set the chrome driver and target url, maximize the chrome tab
    public App() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BaseUrl);
        driver.manage().window().maximize();
    }
   // Entering Instagram login credentials
    public void Login(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }
   // Waiting for objects to appear for functions to work
    public void WaitForSmt(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // Navigate to account that user wants to like
    public void Navigate(String accountName){
        WaitForSmt(instagramButtonLocator);
       driver.navigate().to(BaseUrl+accountName);
    }
    // Find all post of target account
    private List<WebElement> findAll(){
        WaitForSmt(photoLocator);
        return driver.findElements(photoLocator);
    }
    private void FindFirstPhoto(){
        findAll().get(0).click();
    }
    // Like all posts of target account
    public void LikeAllPhotos(){
    // Find first photo out of all target account posts and start from there
        FindFirstPhoto();
        int count= Integer.parseInt(driver.findElement(postCountLocator).getText());
        while (count>0){
        WaitForSmt(likeButtonLocator);
        driver.findElement(likeButtonLocator).click();
        driver.findElement(htmlTag).sendKeys(Keys.ARROW_RIGHT);
        count--;
        }
    }

}
