package selenium;



import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void completeCheckout(String firstName, String lastName, String email) throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/cart");

        WebElement terms = wait.until(ExpectedConditions.elementToBeClickable(By.id("termsofservice")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", terms);
        terms.click();

        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        checkoutBtn.click();

        try {
            WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("billing-address-select")));
            new Select(dropdown).selectByIndex(0);
        } catch (TimeoutException e) {
            clearAndType(By.id("BillingNewAddress_FirstName"), firstName);
            clearAndType(By.id("BillingNewAddress_LastName"), lastName);
            clearAndType(By.id("BillingNewAddress_Email"), email);
            new Select(driver.findElement(By.id("BillingNewAddress_CountryId"))).selectByVisibleText("India");
            type(By.id("BillingNewAddress_City"), "Anantapur");
            type(By.id("BillingNewAddress_Address1"), "Main Street");
            type(By.id("BillingNewAddress_ZipPostalCode"), "515001");
            type(By.id("BillingNewAddress_PhoneNumber"), "9876543210");
        }

        click(By.cssSelector("input.button-1.new-address-next-step-button"));
        Thread.sleep(2000);

        click(By.id("PickUpInStore"));
        click(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]"));
        Thread.sleep(2000);

        click(By.xpath("//ul[@class='method-list']/li//input[@id='shippingoption_2']"));
        click(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[3]"));
        Thread.sleep(2000);

        click(By.xpath("//div[@id='paymentmethod_1']//input"));
        click(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[4]"));
        Thread.sleep(2000);

        click(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[5]"));
        Thread.sleep(2000);

        click(By.xpath("//input[@value='Confirm']"));
        Thread.sleep(2000);

        System.out.println("✅ Checkout completed successfully");
    }
}
