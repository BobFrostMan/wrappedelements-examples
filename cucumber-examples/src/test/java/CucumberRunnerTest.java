import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bobfrostman.config.WrappedElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import wrappedelements.custom.Button;
import wrappedelements.custom.ButtonAnnotationProcessor;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
public class CucumberRunnerTest {


    @BeforeClass
    public static void setUp() {
        WrappedElements.config()
                .driverCreator(() -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setImplicitWaitTimeout(Duration.ofSeconds(10));
                    return new ChromeDriver();
                })
                .registerAnnotationProcessor(Button.class, new ButtonAnnotationProcessor());
    }

    @AfterClass
    public static void tearDown() {
        WrappedElements.getDriver().quit();
    }
}
