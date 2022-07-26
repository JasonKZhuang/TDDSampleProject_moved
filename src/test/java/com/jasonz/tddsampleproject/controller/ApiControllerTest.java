package com.jasonz.tddsampleproject.controller;

import com.jasonz.tddsampleproject.dto.OrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiControllerTest {

    @LocalServerPort
    private int serverPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    //Mocking a WebClient in Spring
    //Two main options for mocking in our tests:
    //Use Mockito to mimic the behavior of WebClient
    //Use WebClient for real, but mock the service it calls by using MockWebServer
//    @Autowired
//    private WebTestClient webTestClient;


    @BeforeEach
    void setUp() {
//        apiController = new ApiController();
    }

    @Test
    void getOrder() {
        // arrange
        String baseURL = "http://localhost:" + serverPort + "/api/v1/orders";

        // act
        ResponseEntity<OrderDTO[]> response = testRestTemplate.getForEntity(baseURL, OrderDTO[].class);

        // assert
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().length).isGreaterThanOrEqualTo(2);

    }

    @Test
    void givenANewOrder_PostOrderEndpoint_ShouldAddNewOrder() {
        // arrange
        String baseURL = "http://localhost:" + serverPort + "/api/v1/orders";
        String orderReference = "789";
        OrderDTO payLoad = generateFakeOrder(orderReference);

        // act
        ResponseEntity<OrderDTO> response = testRestTemplate.postForEntity(baseURL, payLoad, OrderDTO.class);

        // assert
        OrderDTO dto = response.getBody();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertEquals(orderReference,dto.getOrderReference(),"what is wrong");
    }

    private OrderDTO generateFakeOrder(String orderReference) {
        OrderDTO dto = new OrderDTO();
        dto.setOrderReference(orderReference);
        return dto;
    }

}