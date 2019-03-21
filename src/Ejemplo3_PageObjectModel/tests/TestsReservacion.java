package Ejemplo3_PageObjectModel.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Ejemplo3_PageObjectModel.pages.AppointmentConfirmationPage;
import Ejemplo3_PageObjectModel.pages.LoginPage;
import Ejemplo3_PageObjectModel.pages.MakeAppointmentPage;

class TestsReservacion {
	static WebDriver driver;
	static String url = "https://katalon-demo-cura.herokuapp.com/profile.php#login";
	
	@BeforeAll
	static void inicializar() {
		// Driver para Firefox:
		System.setProperty("webdriver.gecko.driver", "/Users/amonroy/Documents/geckodriver");
		driver = new FirefoxDriver();
		
		// Driver para Chrome:
		//System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		// Con el siguiente codigo le decimos a Selenium que vuelva a intentar cuando no encuentra un objeto
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	void hacerReservacion() {
		// Datos de prueba
		String usuario = "John Doe";
		String contrasenia = "ThisIsNotAPassword";
		String lugar = "Hongkong CURA Healthcare Center";
		boolean solicitarReadmision = false;
		String programaSalud = "Medicare";
		String fecha = "31/03/2019";
		String comentario = "Esto es una prueba";
		
		driver.get(url);
		
		// Login
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(usuario, contrasenia); // Llamada simplificada, no nos preocupamos por esto en nuestro test
		
		// Ingresamos los datos en el formulario
		MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
		makeAppointmentPage.seleccionarLugar(lugar);
		makeAppointmentPage.ingresarSolicitarReadmision(solicitarReadmision);
		makeAppointmentPage.seleccionarProgramaDeSalud(programaSalud);
		makeAppointmentPage.ingresarFecha(fecha);
		makeAppointmentPage.ingresarComentario(comentario);
		makeAppointmentPage.clickAgendar();
		
		// Revision de datos en pantalla de confirmacion
		AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
		assertEquals(lugar, appointmentConfirmationPage.valorLugar(), "El lugar no coincide con el ingresado.");
		assertEquals(solicitarReadmision==true ? "Yes" : "No", appointmentConfirmationPage.valorSolicitarReadmision(), 
				"Solicitar readmisión no coincide con el ingresado.");
		assertEquals(programaSalud, appointmentConfirmationPage.valorProgramaSalud(), "El programa de salud no coincide con el ingresado.");
		assertEquals(fecha, appointmentConfirmationPage.valorFecha(), "La fecha no coincide con la ingresada.");
		assertEquals(comentario, appointmentConfirmationPage.valorComentario(), "El comentario no coincide con el ingresado.");
	}
	
	@AfterAll
	static void finalizar() {
		driver.quit();
	}
}
