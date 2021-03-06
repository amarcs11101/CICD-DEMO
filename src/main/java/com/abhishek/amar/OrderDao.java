package com.abhishek.amar;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class OrderDao {


    public List<Order> getOrders() {
        return Stream.of(
                new Order(101, "Mobile", 1, 30000),
                new Order(58, "Book", 4, 2000),
                new Order(205, "Laptop", 1, 150000),
                new Order(809, "headset", 1, 1799))
                .collect(Collectors.toList());
    }
    
    public List<Order> addOrders(Integer id) { 
    	 List<Order> list = new ArrayList<>();
    	 list.add(new Order(101, "Mobile", 1, 30000));
    	 list.add(new Order(58, "Book", 4, 2000));
    	 list.add(new Order(205, "Laptop", 1, 150000));
    	 list.add(new Order(809, "headset", 1, 1799));  
    	return list;
    }
}
