package com.jasonz.tddsampleproject.controller;

import com.jasonz.tddsampleproject.dao.OrderDao;
import com.jasonz.tddsampleproject.dto.OrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class ApiController {

    @Autowired
    private OrderDao orderDao;

    @GetMapping("/{orderId}")
    public OrderDTO getOrder(@PathVariable("orderId") String orderId){
        OrderDTO retOrder = new OrderDTO();
        orderDao.getOrderById(orderId);
        retOrder.setOrderReference("123");
        return  retOrder;
    }

    @GetMapping()
    public List<OrderDTO> getOrders(){
        List<OrderDTO> orders = new ArrayList<>();
        OrderDTO dto  = new OrderDTO();
        dto.setOrderReference("123");
        orders.add(dto);

        dto = new OrderDTO();
        dto.setOrderReference("456");
        orders.add(dto);
        return  orders;
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> order(@RequestBody OrderDTO order){
        ModelMapper modelMapper = new ModelMapper();
        OrderDTO retOrder = modelMapper.map(order, OrderDTO.class);
//        return new ResponseEntity<>(retOrder, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(retOrder);
    }

}
