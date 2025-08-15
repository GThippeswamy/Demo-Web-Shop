package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchAndAddToCart(String keyword, int qty) {
        driver.findElement(By.name("q")).sendKeys(keyword);
        driver.findElement(By.cssSelector("input[value='Search']")).click();
        driver.findElement(By.linkText("Simple Computer")).click();

        // Select attributes
        driver.findElement(By.id("product_attribute_75_5_31_96")).click();
        driver.findElement(By.id("product_attribute_75_6_32_99")).click();
        driver.findElement(By.id("product_attribute_75_3_33_102")).click();
        driver.findElement(By.id("product_attribute_75_8_35_107")).click();

        WebElement qtyBox = driver.findElement(By.id("addtocart_75_EnteredQuantity"));
        qtyBox.clear();
        qtyBox.sendKeys(String.valueOf(qty));
        driver.findElement(By.id("add-to-cart-button-75")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));
        driver.get("https://demowebshop.tricentis.com/");
    }

    public void addProductFromCategory(String category, int productIndex) {
        driver.findElement(By.linkText(category)).click();
        List<WebElement> products = driver.findElements(By.xpath("//h2[@class='product-title']/a"));
        if (products.size() > productIndex) {
            products.get(productIndex).click();
            driver.findElement(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']")).click();
        }
    }
}



