package es.urjc.etsii.metodologias.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Loteria {
    private static final int MAX_NUMBER = 1_234_000_100;

    public static void main(String[] args) throws InterruptedException {
        var driver = createWebDriver();
        driver.get("https://r1-ctf-vulnerable.numa.host/");
        // Nos guardamos un valor aproximado al de la semilla
        long millis = System.currentTimeMillis();

        // Enviamos un valor cualquiera
        WebElement searchBox = driver.findElement(By.id("number"));
        searchBox.sendKeys("2");
        searchBox.submit();

        // Esperamos a que cargue el que era el número correcto
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("il")));

        // Nos guardamos ese número correcto
        String sol1 = driver.findElement(By.tagName("il")).getText();
        int number = Integer.parseInt(sol1);

        boolean found = false;
        int lotteryNumber = 0;

        // Hasta que no demos con el número correcto decrementamos la semilla (milisegundos)
        while (millis > 0 && !found){
            Random random = new Random(millis);
            int currentToken = random.nextInt(MAX_NUMBER);
            if (currentToken == number){
                found = true;
                lotteryNumber = random.nextInt(MAX_NUMBER);
            }
            millis--;
        }

        System.out.println("El numero de la loteria es: " + lotteryNumber);

        // Le damos al botón de Try again
        driver.findElement(By.tagName("a")).click();

        // Enviamos el número de la lotería
        WebElement searchBox2 = driver.findElement(By.id("number"));
        searchBox2.sendKeys(String.valueOf(lotteryNumber));
        searchBox2.submit();

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
