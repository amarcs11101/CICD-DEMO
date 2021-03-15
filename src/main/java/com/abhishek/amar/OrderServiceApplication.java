package com.abhishek.amar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class OrderServiceApplication {

    @Autowired
    private OrderDao orderDao;

    @GetMapping
    public List<Order> fetchOrders() {
        return orderDao.getOrders().stream().
                sorted(Comparator.comparing(Order::getPrice)).collect(Collectors.toList());
    }
    
    @GetMapping("/demo")
	String home() {
		System.out.println("Hii its demo !!!!!!");
		return "Spring is here!";
	}
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id")Integer id){
    	return new ResponseEntity<Object>(orderDao.addOrders(id),HttpStatus.OK);
    }
    
    @GetMapping("/details")
    public ResponseEntity<Object> getOrderDetails(){
    	List<Order> list = new ArrayList<>();
   	 list.add(new Order(1, "Abhishek", 1, 30000));
   	 list.add(new Order(2, "Amar", 4, 2000));
   	 list.add(new Order(3, "Sharath Sir", 1, 150000));
   	 list.add(new Order(4, "Demo application", 1, 1799)); 
    	return new ResponseEntity<Object>(list,HttpStatus.OK);
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}