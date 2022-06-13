package SmokeTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTest {
	
	private WebDriver driver;
	

   //CreateAccount negative
By SignUp = By.xpath("/html/body/app-root/app-layout-header/nav/div/ul/li[3]/a");
By UserLocator = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[1]/input");
By EmailLocator = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[2]/input");
By PasswordLocator = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[3]/input");
By Header = By.xpath("/html/body/app-root/app-layout-header/nav");
By BtnSignUpLocator = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/button");

	//Login
By SignIn = By.xpath("/html/body/app-root/app-layout-header/nav/div/ul/li[2]/a");
By Email = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[2]/input");
By Password = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[3]/input");
By SignInBtn = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/button");
By TitleLogin = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/h1");


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
		
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	
	@Test //If the user is already in use
	public void signUp () throws InterruptedException {
		driver.findElement(SignUp).click();
		if(driver.findElement(Header).isDisplayed()) {
			driver.findElement(UserLocator).sendKeys("TEST");
			driver.findElement(EmailLocator).sendKeys("test@gmail.com");
			driver.findElement(PasswordLocator).sendKeys("1234");
			driver.findElement(BtnSignUpLocator).click();
			Thread.sleep(2000);
			
		}
		
		else
			System.out.println("error with sign up");
		
	}
	
	@Test //If the user is new
	public void signUpnew () throws InterruptedException {
		driver.findElement(SignUp).click();
		if(driver.findElement(Header).isDisplayed()) {
			driver.findElement(UserLocator).sendKeys("Maria201429");
			driver.findElement(EmailLocator).sendKeys("makiwokis28@gmail.com");
			driver.findElement(PasswordLocator).sendKeys("1234");
			driver.findElement(BtnSignUpLocator).click();
			Thread.sleep(2000);
			
		}
		
		else
			System.out.println("error with sign up");
		
	}
	
	@Test //login
	public void signIn () throws InterruptedException {
		driver.findElement(SignIn).click();
		if(driver.findElement(TitleLogin).isDisplayed()) {
			driver.findElement(Email).sendKeys("makiwokis@gmail.com");
			driver.findElement(Password).sendKeys("1234");
			driver.findElement(SignInBtn).click();
			Thread.sleep(2000);
			
		}
		
		else
			System.out.println("error with sign in");
		
	}
		
	}

