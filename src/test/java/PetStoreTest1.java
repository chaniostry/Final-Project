import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class PetStoreTest1 {
    @Test
    public void signInTestN() {

        System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\user1\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        driver.getCurrentUrl();
        String expectedUrl = "https://petstore.octoperf.com/actions/Catalog.action";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

       WebElement signInBtn = driver.findElement(By.cssSelector("#MenuContent > a:nth-child(3)"));
       signInBtn.click();
       String expectedLabel = "Please enter your username and password.";
       String actualLabel =  driver.findElement(By.cssSelector("#Catalog > form > p:nth-child(1)")).getText();
       Assert.assertEquals(expectedLabel,actualLabel);

       WebElement usernameInput = driver.findElement(By.name("username"));
       usernameInput.sendKeys("chanao");
       WebElement passwordInput = driver.findElement(By.name("password"));
       passwordInput.clear();
       passwordInput.sendKeys("12345");
       WebElement loginBtn = driver.findElement(By.name("signon"));
       loginBtn.click();
       String expectedMessage = "Invalid username or password. Signon failed.";
       String actualMessage = driver.findElement(By.cssSelector("#Content > ul > li")).getText();
       Assert.assertEquals(expectedMessage,actualMessage);
       driver.quit();
    }

    @Test
    public void searchTest(){
        System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\user1\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        driver.getCurrentUrl();
        String expectedUrl = "https://petstore.octoperf.com/actions/Catalog.action";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        WebElement searchInput = driver.findElement(By.name("keyword"));
        searchInput.sendKeys("poodle");
        WebElement searchBtn = driver.findElement(By.name("searchProducts"));
        searchBtn.sendKeys(Keys.ENTER);
        String expectedProductID = "K9-PO-02";
        String actualProductID = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(2) > b > a > font")).getText();
        Assert.assertEquals(expectedProductID,actualProductID);
        driver.quit();
    }

    }



