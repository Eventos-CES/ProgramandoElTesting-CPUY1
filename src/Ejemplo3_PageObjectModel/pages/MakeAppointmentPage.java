package Ejemplo3_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MakeAppointmentPage {
	private WebDriver driver;

	public MakeAppointmentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void seleccionarLugar(String lugar) {
		driver.findElement(By.id("combo_facility")).sendKeys(lugar);
	}
	
	public void ingresarSolicitarReadmision(boolean solicitarReadmision) {
		// Cuidado! Este código no verifica si ya esta seleccionado
		if (solicitarReadmision) driver.findElement(By.id("chk_hospotal_readmission")).click();
	}
	
	public void seleccionarProgramaDeSalud(String programaDeSalud) {
		driver.findElement(By.xpath("//input[@value=\"" + programaDeSalud + "\"]")).click();
	}
	
	public void ingresarFecha(String fecha) {
		driver.findElement(By.id("txt_visit_date")).sendKeys(fecha);
	}
	
	public void ingresarComentario(String comentario) {
		driver.findElement(By.id("txt_comment")).sendKeys(comentario);
	}
	
	public void clickAgendar() {
		driver.findElement(By.id("btn-book-appointment")).submit();
	}
}
