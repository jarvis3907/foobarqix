package com.wemanity.foobarqix.bdd;

import com.wemanity.foobarqix.FoobarqixApplication;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Class to use spring application context while running cucumber
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = FoobarqixApplication.class, loader = SpringBootContextLoader.class)
@Slf4j
public class CucumberSpringContextConfiguration {


    /**
     * Need this method so the cucumber will recognize this class as glue and load spring context configuration
     */
    @Before
    public void setUp() {
        log.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }
}
