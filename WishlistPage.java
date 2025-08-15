package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class WishlistPage {
    WebDriver driver;

    public WishlistPage(WebDriver driver) { this.driver = driver; }

    public void addFirstBookToWishlist() {
        driver.findElement(By.linkText("Books")).click();
        List<WebElement> items = driver.findElements(By.cssSelector("input[value='Add to wishlist']"));
        if (!items.isEmpty()) items.get(0).click();
    }

    public int getWishlistCount() {
        driver.findElement(By.linkText("Wishlist")).click();
        List<WebElement> count = driver.findElements(By.cssSelector(".wishlist-content .product-name"));
        return count.size();
    }
}


