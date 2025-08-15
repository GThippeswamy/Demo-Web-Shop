package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By registerLink = By.linkText("Register");
    By loginLink = By.linkText("Log in");
    By logoutLink = By.linkText("Log out");
    By cartLink = By.linkText("Shopping cart");
    By wishlistLink = By.linkText("Wishlist");

    public HomePage(WebDriver driver) { this.driver = driver; }

    public void goToRegister() { driver.findElement(registerLink).click(); }
    public void goToLogin() { driver.findElement(loginLink).click(); }
    public void logout() { 
        try { driver.findElement(logoutLink).click(); } 
        catch(Exception e) { System.out.println("Logout not found"); } 
    }
    public void goToCart() { driver.findElement(cartLink).click(); }
    public void goToWishlist() { driver.findElement(wishlistLink).click(); }
    public void navigateToCategory(String category) {
        driver.findElement(By.linkText(category)).click();
    }
}



