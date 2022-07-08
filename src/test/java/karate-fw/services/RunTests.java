package features.usuarios;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static karate-fw.services.support.javautils.cucumber.CucumberUtils.generateReport;


public class RunTests {

    private static final Logger log = LoggerFactory.getLogger(RunTests.class);

    @Test
    void runTests() {

        /**
         * classpath the tests will run
         */
        //Test classpath
        Runner.Builder testBuilder = Runner.path("classpath:karate-fw");

        //Tags setup
        //testBuilder.tags("");

        String env = System.getProperty("karate.env");
        String tags = System.getProperty("karate.options");

        /**
         * number of threads that will run in parallel.
         * If you want to increase, it is advisable to have a maximum of 5 threads.
         * Just change the amount in (int numberOfThreads = 1;)
         */
        //Parallel setup
        String threadsProperty = System.getProperty("threads");
        int numberOfThreads = 1;

        if (threadsProperty != null) {
            try {
                numberOfThreads = Integer.parseInt(threadsProperty);
            } catch (NumberFormatException err) {
                log.warn(err.toString());
                log.warn("Fallback to single thread execution...");
            }
        }

        //Run tests
        Results results = testBuilder.parallel(numberOfThreads);
        generateReport(results.getReportDir());
    }

}
