package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.Contact;
import com.example.demo.model.Example;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
/*@Autowired
ProductRepository resp;

@RequestMapping("/app")
@ResponseBody
public List<Product> viewAll(){
List<Product>	product=resp.findAll();
return product;
}
*/
	@Autowired
	ProductService service;
	@RequestMapping("/create")
	public ResponseEntity<String> create(@Valid @RequestBody Product product) {
		Address addr=product.getContact().getAddress();
		System.out.println("address "+addr.getAddress()+" state "+addr.getState()+" country "+addr.getCountry()+" pincode "+addr.getPincode());
		service.save(product);
		return ResponseEntity.ok().body("given records is inserted");
	}
	@RequestMapping("/fetch")
	@ResponseBody	
	public String countRecords() {
		List<Product> product=service.viewAll();
		//if(product.isEmpty()) {
		//	return "this is records count"+product.size();
		//}
		product.forEach(System.out::println);
		return "yes please check console wheather get records or not";
	}
	@GetMapping("/byName/{name}")
	@ResponseBody
	public String ByNameRecords(@PathVariable String name) {
		System.out.println("this i s paassing  values "+name);
		Optional<Product> product=service.findbyName(name);
		if(product.isPresent()) {
		System.out.println(product.toString());
		return "yes record is there";
		}
		return "record is not find";
	}
	@RequestMapping("/update")
	@ResponseBody	
	public void update(@RequestParam int id) {
Product product=service.update(id);
System.out.println("this is id values "+id);
				if(product!=null) {
					
			product.setName("ramanjaneyulu");
			product.setQuantity("25");
			product.setPrice(9999);
			Contact contact=new Contact();
			contact.setPhone("9392389248");
			contact.setEmail("gramanjineyulu777@gmail.com");
			product.setContact(contact);
			Address address=new Address();
			address.setAddress("vijayawada");
			address.setState("hyderabad");
			address.setCountry("London");
			address.setPincode(12345);
			contact.setAddress(address);
			product.setContact(contact); 
			Example example=new Example();
			example.setNumber(999);
			example.setEname("Teja");
			product.setExample(example);
		service.save(product);
		}
		else {
			System.out.println("null pointer");
		}
	}
	
}
