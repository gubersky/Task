import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPageLogic {
    SelenideElement titleOfProductInCart = $(By.xpath("//a [@ class=\"cart-product__title\"]"));

    public String titleOfProductInCart() {
        return titleOfProductInCart.text().trim();
    }
}
