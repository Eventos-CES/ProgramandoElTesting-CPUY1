package Ejemplo2_Encapsulando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class CodigoEncapsulado {
	static WebDriver driver;
	static String url = "https://katalon-demo-cura.herokuapp.com/";
	
	@BeforeAll
	static void inicializar() {
		// Driver para Firefox:
		System.setProperty("webdriver.gecko.driver", "/Users/amonroy/Documents/geckodriver");
		driver = new FirefoxDriver();
		
		// Driver para Chrome:
		//System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver.exe");
		//driver = new ChromeDriver();
	}

	@Test
	void hacerReservacion() {
		String usuario = "John Doe";
		String contrasenia = "ThisIsNotAPassword";
		String lugar = "Hongkong CURA Healthcare Center";
		String fecha = "31/03/2019";
		String comentario = "Esto es una prueba";
		
		driver.get(url);
		
		WebElement searchBox = driver.findElement(By.id("btn-make-appointment"));
		searchBox.click();
		
		WebElement user = driver.findElement(By.id("txt-username"));
		user.sendKeys(usuario);
		
		WebElement pass = driver.findElement(By.id("txt-password"));
		pass.sendKeys(contrasenia);
		
		WebElement btnlogin = driver.findElement(By.id("btn-login"));
		btnlogin.submit();
		
		WebElement label = driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")); 
		assertEquals("Make Appointment", label.getText());
		
		WebElement facility = driver.findElement(By.id("combo_facility"));
		facility.sendKeys(lugar);

		WebElement date = driver.findElement(By.id("txt_visit_date"));
		date.sendKeys(fecha);
		
		WebElement comment = driver.findElement(By.id("txt_comment"));
		comment.sendKeys(comentario);
		
		WebElement btnappoint = driver.findElement(By.id("btn-book-appointment"));
		btnappoint.submit();
		
		WebElement label2 = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2"));
		assertEquals("Appointment Confirmation", label2.getText());
		
		WebElement home = driver.findElement(By.linkText("Go to Homepage"));
		home.click();
		
		assertEquals("CURA Healthcare Service", driver.getTitle());
	}
	
	@AfterAll
	static void finalizar() {
		driver.quit();
	}
}
