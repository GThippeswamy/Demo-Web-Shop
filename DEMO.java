package PROJECTS;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import selenium.*;

import java.time.Duration;

public class DEMO {

    WebDriver driver;
    HomePage home;
    RegisterPage register;
    LoginPage login;
    WishlistPage wishlist;
    ProductPage product;
    CheckoutPage checkout;

    String email = "krishna" + System.currentTimeMillis() + "@gmail.com";
    String password = "Krishna123";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");

        home = new HomePage(driver);
        register = new RegisterPage(driver);
        login = new LoginPage(driver);
        wishlist = new WishlistPage(driver);
        product = new ProductPage(driver);
        checkout = new CheckoutPage(driver);
    }

    @Test(priority = 1)
    public void registrationTest() {
        home.goToRegister();
        register.registerUser("Krishna", "Yadav", email, password);
    }

    @Test(priority = 2)
    public void logoutAfterRegister() {
        home.logout();
    }

    @Test(priority = 3)
    public void loginTest() {
        home.goToLogin();
        login.loginUser(email, password);
    }

    @Test(priority = 4)
    public void wishlistTest() {
        wishlist.addFirstBookToWishlist();
        int count = wishlist.getWishlistCount();
        System.out.println("Wishlist items: " + count);
    }

    @Test(priority = 5)
    public void searchAndAddToCartTest() {
        product.searchAndAddToCart("computer", 2);
    }

    @Test(priority = 6)
    public void addCategoriesTest() {
        String[] categories = {"Books", "Computers", "Electronics", "Apparel & Shoes", 
                               "Digital downloads", "Jewelry", "Gift Cards"};
        for (String cat : categories) {
            product.addProductFromCategory(cat, 1); // adds second product from each category
        }
    }

    @Test(priority = 7)
    public void checkoutTest() throws InterruptedException {
        home.goToCart();
        checkout.completeCheckout("Krishna", "Yadav", email);
    }

    @Test(priority = 8)
    public void finalLogout() {
        home.logout();
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
