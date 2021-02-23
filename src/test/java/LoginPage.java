import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass
{
	public LoginPage() 
	{
	PageFactory.initElements(driver, this);	
	}
	@CacheLookup
	@FindBys({@FindBy(id="email"),
		      @FindBy(xpath="//input[@name='email']")})
	private WebElement txtUsername;
	@FindAll({@FindBy(id="pass"),
		      @FindBy(xpath="//input[@name='password']")})
	private WebElement txtPassword;
	@FindBy(xpath="//button[@name='login']")
	private WebElement btnLogin;
	public WebElement getTxtUsername() {
		return txtUsername;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public void login(String user,String pass)
	{
	fillTextBox(getTxtUsername(), user);
	fillTextBox(getTxtPassword(), pass);
	btnClick(getBtnLogin());
	}
	
}
