package demoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDataProvider1 {
  @Test(dataProvider="create")
  public void testdata(String username, String password) throws Exception {
	  
	//  System.out.println(username+"...."+password+"....."+test);
	  
	  WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		

		WebElement text = driver.findElement(By.xpath("//span[text()='Dashboard']"));
		

		if (text.isDisplayed()) {
			System.out.println("login successfull");

		} else {
			System.out.println("login not successfull");
		}

		driver.close();

  }
  
  @DataProvider (name="create")
  public Object[][] datatest(){
	  Object[][] testdata = new Object[][]{
	  {"Admin","admin123"},
	  {"username1","password1"},
	  {"username2","password2"},
  };
  return testdata;
  }
  
} 
  

