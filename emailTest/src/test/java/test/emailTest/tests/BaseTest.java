package test.emailTest.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import test.emailTest.patterns.SingletonWebDriver;
import java.util.concurrent.TimeUnit;
import static java.util.Objects.isNull;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
        SingletonWebDriver.getInstance().manage().window().maximize();
        SingletonWebDriver.getInstance().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void reset() {
        SingletonWebDriver.getInstance().quit();
    }

    public void sleep(Long delay) {
        try {
            if (isNull(delay)) {
                delay = 1000L;
            }
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}