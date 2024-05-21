
![256px-Instagram_icon](https://github.com/tayfundaldik/InstagramBotProject/assets/79011413/86b5fa5c-fa8f-49ad-b5bd-73f41dc2d214)

# Instagram Bot Project
<br/>

## Introduction
I made an Instagram Bot that uses a user's given account and likes all the posts of specified account user wants to.
<br/>
### App Class
App class contains the main functions of this bot.
```java
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
```

### Locators Class
Locators class contains url and all the locators used by App class.
```java
    String BaseUrl = "https://www.instagram.com/";
    By usernameLocator = new By.ByCssSelector("input[name='username']");
    By passwordLocator = new By.ByCssSelector("input[name='password']");
    By loginButtonLocator = new By.ByCssSelector("button[class=' _acan _acap _acas _aj1- _ap30']");
    By instagramButtonLocator = new By.ByCssSelector("div[class='_aagx']");
    By photoLocator = new By.ByCssSelector("div[class='_aagu']");
    By likeButtonLocator = new By.ByCssSelector("span[class='x1rg5ohu xp7jhwk']");
    By postCountLocator = By.xpath("//li/span/span");
    By htmlTag = By.tagName("html");
```

### Main Class
Main class is responsible for make the bot work.
```java
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println("Enter which account you want to like: ");
        String account = sc.nextLine();

        App app = new App();
        app.Login(username, password);
        app.Navigate(account);
        app.LikeAllPhotos();
```
