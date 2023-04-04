package gcu.backend.gcurest_gradle.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gcu.backend.gcurest_gradle.domain.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    User user;

    @PostMapping(path="/post")
    public ResponseEntity<User> postUser(@RequestBody User user){
    
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping (path="/path/{id}/{brand}/{company}/{price}")
    public ResponseEntity<User> postUserwithPath(@PathVariable(value="id") Integer id, @PathVariable(value="brand") String brand, @PathVariable(value = "company") String company, @PathVariable(value = "price") Integer price){
        User user = User.builder().company(company).brand(brand).id(id).price(price).build();
        return ResponseEntity.ok(user);

    }

    @GetMapping(path="/get")
    public ResponseEntity<User> user(){
        User user = User.builder().company("Hyundai").id(1).price(6000).brand("Granduer").build();
        System.out.println(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}

