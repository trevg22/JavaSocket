/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        Receiver classUnderTest = new Receiver();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
