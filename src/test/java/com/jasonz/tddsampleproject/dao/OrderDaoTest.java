package com.jasonz.tddsampleproject.dao;

import com.jasonz.tddsampleproject.dto.OrderDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderDaoTest {


    @Test
    void getOrderById() {
    }

    @Test
    void getOrders() {
        String[] ids = new String[]{"123", "456"};
        OrderDao dao = new OrderDao();
        assertThat(dao.getOrders(ids).size()).isEqualTo(2);
    }

    @Test
    void newOrder() {
        OrderDao dao = new OrderDao();
        OrderDTO dto = generateFakeOrder("890");
        OrderDTO dtoNew = dao.newOrder(dto);
        assertThat(dtoNew.getOrderReference()).isEqualTo(dto.getOrderReference());
    }

    private OrderDTO generateFakeOrder(String orderReference) {
        OrderDTO dto = new OrderDTO();
        dto.setOrderReference(orderReference);
        return dto;
    }

}