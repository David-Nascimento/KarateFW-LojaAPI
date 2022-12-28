package lojaVirtual.services;

import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RunTests {

    private static final Logger log = LoggerFactory.getLogger(RunTests.class);

    @Test
    void runTests() {
        /**
         * classpath the tests will run
         */
        //Test classpath
        Runner.Builder testBuilder = Runner.path("classpath:lojaVirtual");

        //Tags setup
        testBuilder.tags("@userExistente");

        String env = System.getProperty("karate.env");
        String tags = System.getProperty("karate.options");
    }

}
