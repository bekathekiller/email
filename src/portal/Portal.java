/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portal;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 *
 * @author hp
 */
public class Portal {
    
    static PrintWriter out = null;
    public static void main(String[] args) throws IOException{
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        WebDriver driver;
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://portal.aait.edu.et");
        
//        Thread.sleep(2000);
        driver.findElement(By.id("UserName")).sendKeys("Enter id gere ");
        driver.findElement(By.id("Password")).sendKeys("Enter your password here");
        driver.findElement(By.tagName("form")).findElement(By.className("btn")).click();
        
        driver.get("https://portal.aait.edu.et/Grade/GradeReport");
        
        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]"));
//        
//        File file = new File("GradeReport.txt");
//        BufferedWriter wr = new BufferedWriter(new FileWriter(file));
//            wr.write(element.getText());
try{
        FileWriter report = new FileWriter("GradeReport.txt",true);
            BufferedWriter vbuffer = new BufferedWriter(report);
            out = new PrintWriter(vbuffer);
            
            out.println(element.getText());
            
            out.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
        driver.quit();
        
        System.out.println(element.getText());
    }
    
}
