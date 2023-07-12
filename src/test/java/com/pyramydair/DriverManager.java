package com.pyramydair;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverManager {
    private static volatile WebDriver driver;
    @RegisterExtension
    static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    private DriverManager() {
    }


    public static WebDriver getDriver() {
        WebDriver localDriver = driver;
        if (localDriver == null) {
            synchronized (DriverManager.class) {
                localDriver = driver;
                if (localDriver == null) {
                    Properties properties = new Properties();
                    try (InputStream inputStream = DriverManager.class.getClassLoader().getResourceAsStream("cucumber.properties")) {
                        properties.load(inputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String browser = System.getProperty("browser", properties.getProperty("browser", "chrome"));

                    switch (browser) {
                        case "chrome":
                            seleniumJupiter.getConfig().enableScreenshotWhenFailure();
                            seleniumJupiter.getConfig().setOutputFolder("target/screenshots/");
                            WebDriverManager.chromedriver().setup();
                            ChromeOptions options = new ChromeOptions();
                            options.addArguments("--no-sandbox");
                            options.addArguments("--disable-dev-shm-usage");
                            options.addArguments("--window-size=1920,1080");
                            options.addArguments("--headless");


                            localDriver = new ChromeDriver(options);
                            break;
                        case "firefox":
                            WebDriverManager.firefoxdriver().setup();
                            localDriver = new FirefoxDriver();
                            break;
                        default:
                            System.out.println("unknown browser " + browser);
                    }
                    driver = localDriver;
                }
            }
        }
        return localDriver;
    }


    public static void quitDriver() {
        WebDriver localDriver = driver;
        if (localDriver != null) {
            synchronized (DriverManager.class) {
                localDriver = driver;
                if (localDriver != null) {
                    localDriver.quit();
                    driver = null;
                }
            }
        }
    }
}
