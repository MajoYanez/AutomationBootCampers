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
	
	//User 
By UserLinkLocator = By.xpath("/html/body/app-root/app-home-page/div/div[2]/div/div[1]/app-article-list/app-article-preview[1]/div/app-article-meta/div/div/a");
By ImageSmileLocator = By.xpath("/html/body/app-root/app-profile-page/div/div[1]/div/div/div/img");	
By BtnFollowLocator = By.xpath("/html/body/app-root/app-profile-page/div/div[1]/div/div/div/app-follow-button/button");

By RegisterLocator = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/h1");

   //CreateAccount
By NeedAccountLocator = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/p/a");
By UserLocator = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[1]/input");
By EmailLocator = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[2]/input");
By PasswordLocator = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[3]/input");
By FooterLocator = By.xpath("/html/body/app-root/app-layout-footer/footer/div");
By BtnSignUpLocator = By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/button");

   //Profile and Article
By FeedLocator = By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/app-article-list/div[2]");
By GlobalFeedLocator = By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[2]/a");
By ArticleLocator = By.xpath("/html/body/app-root/app-layout-header/nav/div/ul/li[2]/a");
By ArticleTitleLocator = By.xpath("/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[1]/input");
By AboutLocator = By.xpath("/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[2]/input");
By MarkdownLocator = By.xpath("/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[3]/textarea");
By TagsLocator = By.xpath("/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[4]/input");
By BtnPublishLocator = By.xpath("/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/button");
By DeleteArticleLocator = By.xpath("/html/body/app-root/app-article-page/div/div[1]/div/app-article-meta/div/span[1]/button");
By CommentLocator = By.xpath("/html/body/app-root/app-article-page/div/div[2]/div[3]/div/div/form/fieldset/div[1]/textarea");
By BtnPostCommentLocator = By.xpath("/html/body/app-root/app-article-page/div/div[2]/div[3]/div/div/form/fieldset/div[2]/button");


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa-task.backbasecloud.com/");
		
	
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void user() throws InterruptedException {
		driver.findElement(UserLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(ImageSmileLocator).isDisplayed()) {
			driver.findElement(BtnFollowLocator).click();
		}
		else {
			System.out.println("User not found");
		}
		
		driver.findElement(RegisterLocator).isDisplayed();
	}
	
	@Test
	public void signIn () throws InterruptedException {
		driver.findElement(NeedAccountLocator).click();
		if(driver.findElement(FooterLocator).isDisplayed()) {
			driver.findElement(UserLocator).sendKeys("TEST");
			driver.findElement(EmailLocator).sendKeys("test@gmail.com");
			driver.findElement(PasswordLocator).sendKeys("1234");
			driver.findElement(BtnSignUpLocator).click();
			Thread.sleep(2000);
			
		}
		
		else
			System.out.println("error with sign up");
		
	}
	
	@Test
	public void profile () throws InterruptedException {
		driver.findElement(FeedLocator).isDisplayed();
		driver.findElement(GlobalFeedLocator).click();
		driver.findElement(ArticleLocator).click();
		driver.findElement(ArticleTitleLocator).sendKeys("Java Script");
		driver.findElement(AboutLocator).sendKeys("Structure of Java Script");	
		driver.findElement(MarkdownLocator).sendKeys("Test text area");
		driver.findElement(TagsLocator).sendKeys("Programing");
		driver.findElement(BtnPublishLocator).click();
		if(driver.findElement(DeleteArticleLocator).isDisplayed()) {
			driver.findElement(CommentLocator).sendKeys("All good");
			driver.findElement(BtnPostCommentLocator).click();
			Thread.sleep(2000);
		}
		else
			
			System.out.println("Article not Found");
	}
}
