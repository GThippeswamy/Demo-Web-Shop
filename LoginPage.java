package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By email = By.id("Email");
    By password = By.id("Password");
    By loginButton = By.cssSelector("input.button-1.login-button");

    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void loginUser(String emailText, String pass) {
        driver.findElement(email).sendKeys(emailText);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        System.out.println("Logged in");
    }
}



