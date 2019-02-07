package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruit")
public class FruitController {

	
	@Autowired
	FruitRepository fruitRepository;
	
	
	@GetMapping()
	public List<Fruit> getFruits(){
		return fruitRepository.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit){
		if(fruit.validModel()) {
			fruitRepository.save(fruit);
			return ResponseEntity.ok(fruit);	
		}
		return ResponseEntity.badRequest().build();		
	}
	
	
}
