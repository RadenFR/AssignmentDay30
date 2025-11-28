import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {

    @Test
    public void test_transaksi_berhasil(){
        System.setProperty("webdriver.gecko.diver", System.getProperty("user.dir")+"/driver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id='login-button']")).click();

        WebElement product = driver.findElement(By.xpath( "//*[@id='inventory_container']/div/div[1]/div[2]"));

        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();

        WebElement cart = driver.findElement(By.xpath("//span[@class='title']"));

        driver.findElement(By.xpath("//*[@id='checkout']")).click();

        WebElement form = driver.findElement(By.xpath("//*[@class='title']"));

        driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys("Raden");
        driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("Fachrul");
        driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("4022");

        driver.findElement(By.xpath("//*[@id='continue']")).click();
        driver.findElement(By.xpath("//*[@id='finish']")).click();

        WebElement complete = driver.findElement(By.xpath("//h2[@class='complete-header']"));

        Assert.assertTrue(complete.isDisplayed(), "Element Tidak Muncul!");

        driver.quit();
    }

}
