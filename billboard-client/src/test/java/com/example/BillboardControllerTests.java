package com.example;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids="com.example:message-service",stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class BillboardControllerTests {

    @Autowired
    private BillboardController controller;

    @Test
    public void get() {
        // when:
        String quote = controller.get();
        // then:
        BDDAssertions.then(quote).isEqualTo("to be or not to be -- Shakesheeper");
    }


}