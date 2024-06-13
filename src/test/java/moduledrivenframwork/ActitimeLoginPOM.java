package moduledrivenframwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeLoginPOM 
{
	@FindBy(name = "username")
	private WebElement username ;
	@FindBy(name = "pwd")
	private WebElement password ;
	@FindBy(id = "loginButton")
	private WebElement loginButton ;
	
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	public ActitimeLoginPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
