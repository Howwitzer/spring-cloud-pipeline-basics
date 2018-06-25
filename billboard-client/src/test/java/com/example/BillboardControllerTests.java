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
@AutoConfigureStubRunner(ids="com.example:message-service",
        // REPO_WITH_BINARIES comes from sc-pipelines
        repositoryRoot = "${REPO_WITH_BINARIES:https://qconny2018.jfrog.io/qconny2018/libs-release-local}",
        stubsMode = StubRunnerProperties.StubsMode.REMOTE)
public class BillboardControllerTests {

    @Autowired
    private BillboardController controller;

    @Test
    public void should_return_a_quote() {
        // when:
        String quote = controller.get();
        // then:
        BDDAssertions.then(quote).isEqualTo("to be or not to be -- Shakesheeper");
    }


}