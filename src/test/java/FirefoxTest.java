import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {
    @Test
    public void test() {
        WebDriver driver;
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://sv.ugm.ac.id/");

        String title = driver.getTitle();
        System.out.println(title);

        driver.quit();
    }
}
