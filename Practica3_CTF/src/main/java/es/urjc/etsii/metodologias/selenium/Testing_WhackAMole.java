package es.urjc.etsii.metodologias.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Testing_WhackAMole {
    public static void main(String[] args) throws InterruptedException {
        var driver = createWebDriver();
        String score = "10000";

        // Visitamos la URL en el navegador
        driver.get("http://localhost");

        while(!Objects.equals(driver.findElement(By.id("score")).getText(), score)) {
            try{
                WebElement mole = driver.findElement(By.className("mole"));
                mole.click();
            } catch (Exception e){
                // System.out.println("Se produjo una excepción: " + e.getMessage());
            }
        }

        // Esperamos 30 segundos para copiar la flag y cerramos
        Thread.sleep(30000);
        driver.quit();
    }


    public static WebDriver createWebDriver(){
        // Path al driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    }
}

// python -m http.server 80