package Calculator_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2 {
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
	@Test
	public void DivisionTest() throws InterruptedException
	{
		
	//Division Test 
	driver.findElement(By.xpath("//span[contains(text(),'4')]")).click();
	driver.findElement(By.xpath("//span[@class='scinm'][contains(text(),'0')]")).click();
	
	driver.findElement(By.xpath("//span[@class='scinm'][contains(text(),'0')]")).click();
	
	driver.findElement(By.xpath("//span[@class='scinm'][contains(text(),'0')]")).click();
	Thread.sleep(1000);
			
	driver.findElement(By.xpath("//span[@class='sciop'][contains(text(),'/')]")).click();
	Thread.sleep(2000);
		
	driver.findElement(By.xpath("//span[contains(text(),'2')]")).click();
	driver.findElement(By.xpath("//span[@class='scinm'][contains(text(),'0')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[@class='scinm'][contains(text(),'0')]")).click();
	driver.findElement(By.xpath("//span[contains(text(),'=')]")).click();
	Thread.sleep(2000);
	
	
	String expectedString=" 20";		
	String actualString=driver.findElement(By.id("sciOutPut")).getText();
	
	//if the actual and expected matches then only the username and password will be entered
	Assert.assertEquals(actualString, expectedString); 
	System.out.println("String match......Test passed ");
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
	
}
