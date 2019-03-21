package Ejemplo1_Cascada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class CodigoEnCascada {

	@Test
	/**
	 * Este test registra un appointment y regresa al home
	 * Se verifica que llegue al home
	 */
	void hacerReservacion() {
		// Driver para Firefox:
		System.setProperty("webdriver.gecko.driver", "/Users/amonroy/Documents/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		// Driver para Chrome:
		//System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver.exe");
		//WebDriver  driver = new ChromeDriver();
		
		//accedemos a la aplicacion
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		
		//click al boton "make appointment"
		WebElement searchBox = driver.findElement(By.id("btn-make-appointment"));
		searchBox.click();
		
		//ingreso de usuario
		WebElement user = driver.findElement(By.id("txt-username"));
		user.sendKeys("John Doe");
		
		//ingreso de contraseña
		WebElement pass = driver.findElement(By.id("txt-password"));
		pass.sendKeys("ThisIsNotAPassword");
		
		//click a "Login"
		WebElement btnlogin = driver.findElement(By.id("btn-login"));
		btnlogin.submit();
		
		//Verificamos que estamos en la pantalla para hacer el apponintment
		WebElement label = driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")); 
		assertEquals("Make Appointment", label.getText());
		
		//Llenamos en formulario
		WebElement facility = driver.findElement(By.id("combo_facility"));
		facility.sendKeys("Hongkong CURA Healthcare Center");

		WebElement date = driver.findElement(By.id("txt_visit_date"));
		date.sendKeys("31/03/2019");
		
		WebElement comment = driver.findElement(By.id("txt_comment"));
		comment.sendKeys("comentario de prueba");
		
		WebElement btnappoint = driver.findElement(By.id("btn-book-appointment"));
		btnappoint.submit();
		
		//Verificamos la confirmacion del appointment
		WebElement label2 = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2"));
		assertEquals("Appointment Confirmation", label2.getText());
		
		//Navegamos al home y verificamos que estamos en el home
		WebElement home = driver.findElement(By.linkText("Go to Homepage"));
		home.click();
		
		assertEquals("CURA Healthcare Service", driver.getTitle());
		driver.quit();
	}
	
}
