package moduledrivenframwork;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PomRunner {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://desktop-6aohfh7/login.do");
		ActitimeLoginPOM act = new ActitimeLoginPOM(driver) ;
		act.getUsername().sendKeys("admin");
		Thread.sleep(1000);
		act.getPassword().sendKeys("maager");
		act.getLoginButton().click();
		
		
		
	}

}
