import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class BasicTest {

	@Test
	void test() {
		 WebDriver driver = new ChromeDriver();
		 //driver.get("http://www.google.com/xhtml");
		 driver.get("https://katalon-demo-cura.herokuapp.com/");
		 //Thread.sleep(5000);  // Let the user actually see something!
		 WebElement searchBox = driver.findElement(By.id("btn-make-appointment"));
		 //searchBox.sendKeys("ChromeDriver");
		 //searchBox.submit();
		 searchBox.click();
		 //Thread.sleep(5000);  // Let the user actually see something!
		 WebElement user = driver.findElement(By.id("txt-username"));
		 user.sendKeys("John Doe");
		 WebElement pass = driver.findElement(By.id("txt-password"));
		 pass.sendKeys("ThisIsNotAPassword");
		 WebElement btnlogin = driver.findElement(By.id("btn-login"));
		 btnlogin.submit();
		 WebElement label = driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")); 
		 assertEquals("Make Appointment", label.getText());
		 
		 
		 WebElement facility = driver.findElement(By.id("combo_facility"));
		 facility.sendKeys("Hongkong CURA Healthcare Center");
		 WebElement date = driver.findElement(By.id("txt_visit_date"));
		 date.sendKeys("31/03/2019");
		 WebElement comment = driver.findElement(By.id("txt_comment"));
		 comment.sendKeys("comentario de prueba");
		 
		 WebElement btnappoint = driver.findElement(By.id("btn-book-appointment"));
		 btnappoint.submit();
		 
		 WebElement label2 = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2"));
		 assertEquals("Appointment Confirmation", label2.getText());
		 
		 WebElement home = driver.findElement(By.linkText("Go to Homepage"));
		 home.click();
		 
		 assertEquals("CURA Healthcare Service", driver.getTitle());
		 driver.quit();
	}

	
}
