package com.jasonz.tddsampleproject.dao;

import com.jasonz.tddsampleproject.dto.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDao {

    public OrderDTO getOrderById(String id){
        return new OrderDTO();
    }

    public List<OrderDTO> getOrders(String[] ids){
        List<OrderDTO> retOrders = new ArrayList<>();

        OrderDTO dto = new OrderDTO();
        dto.setOrderReference(ids[0]);
        retOrders.add(dto);

        dto = new OrderDTO();
        dto.setOrderReference(ids[1]);
        retOrders.add(dto);

        return retOrders;
    }

    public OrderDTO newOrder(OrderDTO obj){
        OrderDTO dto = new OrderDTO();
        dto.setOrderReference(obj.getOrderReference());
        return dto;
    }
}
