package com.slkj;

import org.activiti.engine.RepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TlSlkjApplicationTests {

    @Autowired
    RepositoryService repositoryService;

    @Test
    void contextLoads() {

        repositoryService.createDeployment()
                .addClasspathResource("classPath:process/*")
                .name("请假流程单")
                .deploy();

    }

}
