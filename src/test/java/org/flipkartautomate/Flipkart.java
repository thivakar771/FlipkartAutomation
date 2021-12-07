package org.flipkartautomate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public WebDriver driver;
	public JavascriptExecutor jse;
	public Robot r;

	@Given("To launch the flipkart page in chromebrowser")
	public void to_launch_the_flipkart_page_in_chromebrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}

	@When("Enter the any one product in search bar")
	public void enter_the_any_one_product_in_search_bar() {
		WebElement search = driver
				.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		search.sendKeys("samsung");
	}

	@When("Enter the Search key")
	public void enter_the_Search_key() throws AWTException {
		r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

	}

	@When("To click the one product")
	public void to_click_the_one_product() throws InterruptedException {
		WebElement cl = driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy F22 (Denim Blue, 128 GB)']"));

		jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].click()", cl);

		Thread.sleep(4000);
	}

	@When("click the addcart")
	public void click_the_addcart() throws InterruptedException {

		Set<String> windowHandles = driver.getWindowHandles();

		ArrayList<Object> wIds = new ArrayList<Object>(windowHandles);
		driver.switchTo().window((String) wIds.get(1));

		WebElement add = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		add.click();

		Thread.sleep(3000);

	}

	@When("click the place order button")
	public void click_the_place_order_button() {
		WebElement order = driver.findElement(By.xpath(" //span[text()='Place Order']"));
		order.click();

	}

	@When("Enter the valid username")
	public void enter_the_valid_username() {
		WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
		userName.sendKeys("9500632981");

	}

	@When("click the continue button")
	public void click_the_continue_button() throws InterruptedException {
		WebElement cont = driver.findElement(By.xpath("//span[text()='CONTINUE']"));
		cont.click();
		Thread.sleep(3000);

	}

	@When("enter the valid password")
	public void enter_the_valid_password() {
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));

		pass.sendKeys("Vairamuthu123");

	}

	@When("click the login button")
	public void click_the_login_button() throws InterruptedException {
		WebElement log = driver.findElement(By.xpath("//span[text()='Login']"));
		log.click();
	}

	@When("select address")
	public void select_address() throws InterruptedException {
		WebElement add = driver.findElement(By.xpath("//div[@id='CNTCTAF4F434B943C4E11B74BBCA0A']"));

		jse.executeScript("arguments.click()", add);

	}

	@When("click the delivery button")
	public void click_the_delivery_button() throws InterruptedException {

		WebElement delivery = driver.findElement(By.xpath("//button[text()='Deliver Here']"));

		jse.executeScript("arguments.click()", delivery);
	}

	@Then("select the payment option")
	public void select_the_payment_option() {

		WebElement payoption = driver.findElement(By.xpath("(//div[@class='_1XFPmK'])[1]"));
		payoption.click();

	}

	@When("click the flikart exp")
	public void click_the_flikart_exp() {
		WebElement plus = driver.findElement(By.xpath("//a[text()='Explore']"));
		plus.click();
	}

	@When("click the add cart")
	public void click_the_add_cart() {
		WebElement cart = driver.findElement(By.xpath("//span[text()='Cart']"));
		cart.click();

	}

	@Then("remove the product")
	public void remove_the_product() {
		WebElement price = driver.findElement(By.xpath("//span[text()='14,999']"));
		String productprice = price.getText();
		Assert.assertEquals(productprice, "14,999");

		WebElement remove = driver.findElement(By.xpath("//div[text()='Remove']"));
		remove.click();
	}

}
