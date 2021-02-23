import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.remote.server.handler.FindElement;

public class Sample extends BaseClass
{
public static void main(String[] args) 
{
launchBrowser();
launchUrl("https://www.facebook.com/");
LoginPage l=new LoginPage();
l.login("hema", "1234");
}
}

