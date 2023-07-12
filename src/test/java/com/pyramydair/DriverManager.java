package com.pyramydair;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverManager {
    private static volatile WebDriver driver;

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
                            WebDriverManager.chromedriver().setup();
                            localDriver = new ChromeDriver();
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
