package Calculator_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {
	
	WebDriver driver; 
		//global declaration so that all methods can access this variable.
		@BeforeMethod       // the setup of beginning of performing operations
		public void setup()
		{
			System.setProperty("webdriver.crome.driver", "E:\\POONAM-Java\\chrome-win64\\chrome.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.calculator.net/");
			
		}

	@Test   //the actual test we need to check
	public void MultiplicatinTest() throws InterruptedException
	{
			
		driver.findElement(By.xpath("//span[contains(text(),'4')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'2')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'3')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'5')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'2')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'5')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'=')]")).click();
		Thread.sleep(2000);
		
		String actual=driver.findElement(By.id("sciOutPut")).getText();
		String expected=" 222075";
		Assert.assertEquals(actual, expected); //if the actual and expected matches then only the username and password will be entered
		System.out.println("String match......Test passed ");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'AC')]")).click();
		Thread.sleep(5000);

	}
		@AfterTest
		public void TearDown()
		{
			driver.close();
		}
}
