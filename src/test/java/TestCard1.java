import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCard1 {

    WebDriver driver;

    @BeforeAll
    static void setDriverPath() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver  = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void cardTest() throws InterruptedException {
        driver.get("http://localhost:9999");
        Thread.sleep(5000);
    }
}
