package Ejemplo3_PageObjectModel.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakeAppointmentPage {
	private WebDriver driver;

	public MakeAppointmentPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals("https://katalon-demo-cura.herokuapp.com/#appointment")) {
			throw new IllegalStateException("No es la pagina de crear reservación");
		}
	}
	
	public void ingresarReservacion(String lugar, boolean solicitarReadmision, String programaSalud, String fecha, String comentario) {
		WebElement label = driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")); 
		assertEquals("Make Appointment", label.getText());
		
		WebElement facility = driver.findElement(By.id("combo_facility"));
		facility.sendKeys(lugar);
		
		WebElement applyReadmission = driver.findElement(By.id("chk_hospotal_readmission"));
		if (solicitarReadmision) applyReadmission.click();
		
		WebElement healthCareProgram = driver.findElement(By.xpath("//input[@value=\"" + programaSalud + "\"]"));
		healthCareProgram.click();

		WebElement date = driver.findElement(By.id("txt_visit_date"));
		date.sendKeys(fecha);
		
		WebElement comment = driver.findElement(By.id("txt_comment"));
		comment.sendKeys(comentario);
		
		WebElement btnappoint = driver.findElement(By.id("btn-book-appointment"));
		btnappoint.submit();
	}
}
