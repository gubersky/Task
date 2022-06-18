import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Test {

    @BeforeMethod
    public void before() {

        Configuration.startMaximized = true;
        open("https://rozetka.com.ua/");
    }

    @org.testng.annotations.Test
    public void testProductCart(){
        new MainPageLogic().findProductInSearchField()
                .openProductPage()
                .addProductToTheCart().closeCartPopup()
                .goToTheMainPage().openCartPage();

        Assert.assertEquals(new ProductPageLogic().titleOfProduct(), new CartPageLogic().titleOfProductInCart());
    }

    @AfterMethod
    public void after() {
        closeWebDriver();
    }
}
