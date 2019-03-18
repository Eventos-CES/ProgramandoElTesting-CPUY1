package Ejemplo3_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String usuario, String contrasenia) {
		ingresarUsuario(usuario);
		ingresarContrasenia(contrasenia);
		clickLogin();
 	}
	
	public void ingresarUsuario(String usuario) {
		driver.findElement(By.id("txt-username")).sendKeys(usuario);
	}
	public void ingresarContrasenia(String contrasenia) {
		driver.findElement(By.id("txt-password")).sendKeys(contrasenia);
	}
	public void clickLogin() {
		driver.findElement(By.id("btn-login")).submit(); 
	}
}
