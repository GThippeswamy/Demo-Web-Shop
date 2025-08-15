package selenium;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(id = "termsofservice") WebElement termsCheckbox;
    @FindBy(id = "checkout") WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkout() {
        termsCheckbox.click();
        checkoutBtn.click();
    }
}
