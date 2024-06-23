package com.juaracoding;

import com.juaracoding.pages.AddToCartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestCases {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @BeforeClass
    public void setup() {
        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add assertions for successful login
        // Example:
        // Assert.assertTrue(assertionCondition, "Login successful");
    }

    @Test(priority = 2)
    public void testAddToCart() {
        AddToCartPage cartPage = new AddToCartPage(driver);
        cartPage.addToCart();
        cartPage.goToCart();

        // Add assertions for successful cart addition and navigation to cart
    }

    @Test(priority = 3)
    public void testCheckout() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutInformation("John", "Doe", "12345");
        checkoutPage.checkout();

        // Add assertions for successful checkout process
    }

    @AfterClass
    public void teardown() {
        // Close the WebDriver instance
        driver.quit();
    }
}
