import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WrongSignIn {
    String path;
    WebDriver driver;

    public WrongSignIn(String path) {
        this.path = path;
        System.setProperty("webdriver.chrome.driver" ,this.path);
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
    }


    public String openSite(String url){
        this.driver.get(url);
       return this.driver.getCurrentUrl();
    }

    public String openSigninPage(){
        WebElement signInBtn = this.driver.findElement(By.cssSelector("#MenuContent > a:nth-child(3)"));
        signInBtn.click();
       WebElement signInLabel = this.driver.findElement(By.cssSelector("#Catalog > form > p:nth-child(1)"));
        return signInLabel.getText();
    }

    public String signIn(){
        WebElement usernameInput = this.driver.findElement(By.name("username"));
        usernameInput.sendKeys("chanao");
        WebElement passwordInput = this.driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys("12345");
        WebElement loginBtn = this.driver.findElement(By.name("signon"));
        loginBtn.click();
         WebElement message = this.driver.findElement(By.cssSelector("#Content > ul > li"));
         return message.getText();

    }
    public void quit(){
        this.driver.quit();
    }
}



