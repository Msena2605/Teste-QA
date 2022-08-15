// Pacotes
package saucedemo;

// Bibliotecas
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

//Class
public class DesafioSauce {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		// Abrir navegador
		System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com"); // Acessar o site
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit(); // Fechar navegador
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
		// Efetuando o login
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
			
		TimeUnit.SECONDS.sleep(05); // Tempo de resposta
						
		driver.findElement(By.id("login-button")).click();
		
		// Ordenando (low to high
		
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		driver.findElement(By.xpath("//option[@value='lohi']")).click();
		TimeUnit.SECONDS.sleep(05);
		
		// Colocando item no carrinho
		
		driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		TimeUnit.SECONDS.sleep(05);
		
		//acessando CHECKOUT
		
		driver.findElement(By.id("checkout")).click();
		TimeUnit.SECONDS.sleep(05);
		
		//CHECKOUT: Informações para o envio
		
		driver.findElement(By.id("first-name")).clear();
		driver.findElement(By.id("first-name")).sendKeys("Matheus");
		driver.findElement(By.id("last-name")).clear();
		driver.findElement(By.id("last-name")).sendKeys("Sena");
		driver.findElement(By.id("postal-code")).clear();
		driver.findElement(By.id("postal-code")).sendKeys("28905001");
		driver.findElement(By.id("continue")).click();
		TimeUnit.SECONDS.sleep(05);
		
		// Finalizando a compra
		
		driver.findElement(By.id("finish")).click();
		
		//Retorno tela inicial
		
		driver.findElement(By.id("back-to-products")).click();
		
			
		
	}

}
