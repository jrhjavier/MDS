package es.urjc.etsii.metodologias.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Testing_Blog {
    public static void main(String[] args) throws InterruptedException {
        var driver = createWebDriver();

        try{
            // Cola de URLs no repetidas
            Queue<String> uniqueURLs = new LinkedList<>();
            // Lista de URLs visitadas
            List<String> visited = new ArrayList<>();
            // Contador de URJC
            int counter = 0;
            uniqueURLs.add("https://r2-ctf-vulnerable.numa.host/");

            while (!uniqueURLs.isEmpty()){
                counter += URJCsearch(uniqueURLs, visited, driver);
                visited.add(uniqueURLs.poll());
            }

            System.out.println(counter);

        } catch (Exception e){
            System.out.println("Se produjo una excepción: " + e.getMessage());
        }

        driver.quit();
    }


    public static WebDriver createWebDriver(){
        // Path al driver
        System.setProperty("webdriver.chrome.driver","Practica3_CTF/src/main/resources/chromedriver.exe");

        return new ChromeDriver();
    }


    public static int URJCsearch(Queue<String> cola, List<String> visited, WebDriver driver){
        int counter = 0;
        // Se coge la primera URL de la cola
        driver.get(cola.peek());

        // Se buscan los posibles links que haya en esa página
        List<WebElement> links = driver.findElements(By.xpath("//h2[contains(@class,'card-title')]/a"));

        for (WebElement link : links) {
            if (link != null) {
                String linkURL = link.getAttribute("href");
                String actualURL = driver.getCurrentUrl();

                // Se añaden los links a la cola si cumplen con las condiciones:
                if (linkURL.startsWith("https://r2-ctf-vulnerable.numa.host/") && !visited.contains(linkURL)
                        && !cola.contains(linkURL) && !linkURL.equals(actualURL)) {
                    cola.add(linkURL);
                }
            }
        }

        // Se coge el texto de la página
        String textURL = driver.findElement(By.tagName("body")).getText();
        // Se busca URJC en el texto
        counter += URJCfind(textURL);

        return counter;
    }

    public static int URJCfind(String text){
        int counter = 0;
        // Regex para encontrar la expresión "URJC"
        Pattern urjc = Pattern.compile("\\bURJC\\b");
        Matcher m = urjc.matcher(text);
        // Se busca en el texto
        while(m.find()){
            counter++;
        }

        return counter;
    }
}
