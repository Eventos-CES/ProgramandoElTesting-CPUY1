import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals("https://katalon-demo-cura.herokuapp.com/profile.php#login")) {
			throw new IllegalStateException("No es la pagina de login");
		}
	}
	
	public MakeAppointmentPage login(String usuario, String password) {
		WebElement user = driver.findElement(By.id("txt-username"));
		 user.sendKeys(usuario);
		 WebElement pass = driver.findElement(By.id("txt-password"));
		 pass.sendKeys(password);
		 WebElement btnlogin = driver.findElement(By.id("btn-login"));
		 btnlogin.submit(); 
		 return new MakeAppointmentPage(driver);
	}

}
