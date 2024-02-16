package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\Tools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        System.out.println("Open web Shopping");

        WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");
        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addToCartButton.click();
        WebElement CartButton = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        CartButton.click();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Utils.assertLogin(currentUrl, expectedUrl);

        String expectedUrlAdd = "https://www.saucedemo.com/inventory.html";
        String currentUrlAdd = driver.getCurrentUrl();
        System.out.println(currentUrlAdd);
        Utils.assertAddCart(currentUrlAdd, expectedUrlAdd);

        //Get inventory
        String expectedUrlInventory = "https://www.saucedemo.com/cart.html";
        String currentUrlInventory = driver.getCurrentUrl();
        System.out.println(currentUrlInventory);
        Utils.assertAddCart(currentUrlInventory, expectedUrlInventory);


        Utils.delay(3); // 3 detik
        driver.quit();
    }
}