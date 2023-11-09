package com.orojasb.mapdtotest;

import com.orojasb.mapdtotest.controllers.UserRestController;
import com.orojasb.mapdtotest.dtos.UserInformationDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MapDtoProjectionTestApplicationTests {
    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRestController controller;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(controller).isNotNull();
    }

    @Test
    void dataTest() throws Exception {
        List data = this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/users/",
                List.class);
        data.forEach(System.out::println);
        Assertions.assertThat(data).isNotNull();
    }


    @Test
    void dataMappingDtoTestTime() throws Exception {
        System.out.println("########################################## START #############################################");
        int loops = 100;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) {
            System.out.println("########################################## "+ i +" #############################################");
            List data = this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/users/",
                    List.class);
            Assertions.assertThat(data).isNotNull();
        }
        long totalTime = startTime - System.currentTimeMillis();
        System.out.println("it takes ----> " + totalTime + "{0} ms in total and takes " + totalTime / loops + "{1} ms in average ");
    }

}

