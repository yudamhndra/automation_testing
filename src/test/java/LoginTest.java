import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    @Test
    public void testLogin() {
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");

            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("student");

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Password123");

            WebElement loginButton = driver.findElement(By.id("submit"));
            loginButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.urlContains("practicetestautomation.com/logged-in-successfully/"));
            System.out.println("URL verification passed");

            WebElement congratsMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Congratulations')]")));
            if (congratsMessage != null) {
                System.out.println("Congratulations message verification passed");
            } else {
                System.out.println("Congratulations message verification failed");
            }

            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Log out')]")));
            if (logoutButton != null) {
                System.out.println("Logout button verification passed");
            } else {
                System.out.println("Logout button verification failed");
            }

            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("post-title")));

            String expectedMessage = "Logged In Successfully";
            String actualMessage = successMessage.getText();

            if (expectedMessage.equals(actualMessage)) {
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}