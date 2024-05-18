import org.openqa.selenium.By;

public class Locators {
    String BaseUrl = "https://www.instagram.com/";
    By usernameLocator = new By.ByCssSelector("input[name='username']");
    By passwordLocator = new By.ByCssSelector("input[name='password']");
    By loginButtonLocator = new By.ByCssSelector("button[class=' _acan _acap _acas _aj1- _ap30']");
    By instagramButtonLocator = new By.ByCssSelector("div[class='_aagx']");
    By photoLocator = new By.ByCssSelector("div[class='_aagu']");
    By likeButtonLocator = new By.ByCssSelector("span[class='x1rg5ohu xp7jhwk']");
    By postCountLocator = By.xpath("//li/span/span");
    By htmlTag = By.tagName("html");

}
