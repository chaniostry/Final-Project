import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Search {
    String path;
    WebDriver driver;

    public Search(String path) {
        this.path = path;
        System.setProperty("webdriver.chrome.driver" ,this.path);
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
    }
    public String openSite(String url) {
        this.driver.get(url);
        return this.driver.getCurrentUrl();
    }
    public String searchPoodle(){
        WebElement searchInput = this.driver.findElement(By.name("keyword"));
        searchInput.sendKeys("poodle");
        WebElement searchBtn = this.driver.findElement(By.name("searchProducts"));
        searchBtn.sendKeys(Keys.ENTER);
        WebElement productID = this.driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(2) > b > a > font"));
        return productID.getText();
    }
    public void quit(){
        this.driver.quit();
    }

    }



