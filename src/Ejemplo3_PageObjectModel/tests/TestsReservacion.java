package Ejemplo3_PageObjectModel.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Ejemplo3_PageObjectModel.pages.LoginPage;
import Ejemplo3_PageObjectModel.pages.MakeAppointmentPage;

class TestsReservacion {
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
		boolean solicitarReadmision = false;
		String programaSalud = "Medicare";
		String fecha = "31/03/2019";
		String comentario = "Esto es una prueba";
		
		driver.get(url);
		
		LoginPage loginPage = new LoginPage(driver);
		MakeAppointmentPage makeAppointmentPage = loginPage.login(usuario, contrasenia);
		
		makeAppointmentPage.ingresarReservacion(lugar, solicitarReadmision, programaSalud, fecha, comentario);
		// TODO completar
	}
	
	@AfterAll
	static void finalizar() {
		driver.quit();
	}
}
