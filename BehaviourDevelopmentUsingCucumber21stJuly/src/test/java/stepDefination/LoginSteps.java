package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;
	String url = "https://practicetestautomation.com/practice-test-login/";

	@Given("User Should Open Chrome Browser")
	public void user_should_open_chrome_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@When("User Should enter Url in Browser")
	public void user_should_enter_url_in_browser() {
		driver.get(url);
	}

	@When("User Should Navigate Homepage")
	public void user_should_navigate_homepage() {
		String homepage = driver.getTitle();
		System.out.println(homepage);
	}

	@When("User Enter Username and Password in Edit Box")
	public void user_enter_username_and_password_in_edit_box() {
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password@123");
	}

	@When("Click On Login PushButton")
	public void click_on_login_push_button() {
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
		System.out.println("Login Successfully");
	}

	@Then("The Browser should Be Closed")
	public void the_browser_should_be_closed() {
		// Write code here that turns the phrase above into concrete actions
		driver.quit();
		throw new io.cucumber.java.PendingException();
	}

}
