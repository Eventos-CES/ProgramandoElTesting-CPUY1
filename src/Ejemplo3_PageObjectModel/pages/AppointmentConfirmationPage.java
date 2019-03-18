package Ejemplo3_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentConfirmationPage {
	private WebDriver driver;
	
	public AppointmentConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String valorLugar() {
		return driver.findElement(By.id("facility")).getText();
	}
	
	public String valorSolicitarReadmision() {
		return driver.findElement(By.id("hospital_readmission")).getText();
	}
	
	public String valorProgramaSalud() {
		return driver.findElement(By.id("program")).getText();
	}
	
	public String valorFecha() {
		return driver.findElement(By.id("visit_date")).getText();
	}
	
	public String valorComentario() {
		return driver.findElement(By.id("comment")).getText();
	}

}
