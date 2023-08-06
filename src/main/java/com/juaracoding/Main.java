package com.juaracoding;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\SMK\\Juara Coding\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://shop.demoqa.com/");
        System.out.println("Open Browser, Open URL");

        //login akun
        driver.findElement(By.className("woocommerce-store-notice__dismiss-link")).click();
        driver.findElement(By.partialLinkText("My Account")).click();
        driver.findElement(By.id("username")).sendKeys("qurrotulaini0325@gmail.com");
        driver.findElement(By.id("password")).sendKeys("juaracoding2023" + Keys.ENTER);
        String login = driver.findElement(By.className("woocommerce-MyAccount-content")).getText();

        if (login.contains("Hello")){
            System.out.println("Login Pass");
        }
        else {
            System.out.println("Login Fail");
        }

        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.partialLinkText("Orders")).click();
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.partialLinkText("Browse products")).click();

        //pilih produk
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.cssSelector("a.hover-device[href='https://shop.demoqa.com/product/black-cross-back-maxi-dress/']")).click();

        //pilih warna
        js.executeScript("window.scrollBy(0,500)");
        WebElement ddColour = driver.findElement(By.id("pa_color"));
        Select selectDdColour = new Select(ddColour);
        selectDdColour.selectByValue("black");

        //pilih ukuran
        WebElement ddSize = driver.findElement(By.id("pa_size"));
        Select selectDdSize = new Select(ddSize);
        selectDdSize.selectByValue("medium");

        //add to cart
        driver.findElement(By.className("single_add_to_cart_button")).click();

        String addToCart = driver.findElement(By.className("woocommerce-message")).getText();

        if (addToCart.contains("has been added to your cart")) {
            System.out.println("Add to Cart Pass");
        }
        else {
            System.out.println("Add to Cart Fail");
        }
        delay();
        driver.quit();
        System.out.println("Quit browser");
    }

    public static void delay(){
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
