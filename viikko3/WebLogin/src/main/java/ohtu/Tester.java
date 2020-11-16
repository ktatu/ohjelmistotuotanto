package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {
    
    static Random r = new Random();

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        // Login testi onnistuu
        /*
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        */

        // Login testi epäonnistuu - väärä salasana
        /*
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("wrong_pass");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        */
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        String randomInt = String.valueOf(r.nextInt(10000000));
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka" + randomInt);
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep" + randomInt);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep" + randomInt);
        
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        
        // Jäi epäselväksi pitikö erikseen olla että rekisteröi ja sitten kirjautuu ulos, tein sen tähän perään
        
        sleep(2);
        driver.findElement(By.linkText("continue to application mainpage")).click();
        sleep(2);
        driver.findElement(By.linkText("logout")).click();
        
        
        sleep(3);
        
        driver.quit();
        
        
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
