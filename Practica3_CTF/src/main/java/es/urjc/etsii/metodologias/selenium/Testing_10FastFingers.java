package es.urjc.etsii.metodologias.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing_10FastFingers {
    public static void main(String[] args) throws InterruptedException {

        // Creamos driver y visitamos una URL en el navegador
        var driver = createWebDriver();
        driver.get("file:///C:/Users/Gabriel/Desktop/10FastFingers/index.html");

        for (int i=0;i<20;i++){
            try{
                String word = "word_" + (i+1);
                WebElement text = driver.findElement(By.id(word));
                String a = text.getText();
                a += " ";
                System.out.println(a);

                WebElement gap = driver.findElement(By.id("textInput"));
                gap.sendKeys(a);

            } catch (Exception e){
                System.out.println("Se produjo una excepción: " + e.getMessage());
            }

        }

        Thread.sleep(10000);
        //driver.quit();
    }


    public static WebDriver createWebDriver(){
        // Indicamos path al driver aqui
        System.setProperty("webdriver.chrome.driver","Practica3_CTF/src/main/resources/chromedriver.exe");

        return new ChromeDriver();
    }
}

// python -m http.server 80