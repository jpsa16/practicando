package com.techprimers.controller;

import com.techprimers.model.Users;
import com.techprimers.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserJpaRespository userJpaRespository;

    @GetMapping(value = "/all")
    public List<Users> findAll() {
        return userJpaRespository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Users findByName(@PathVariable final String name){
        return userJpaRespository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users) {
        userJpaRespository.save(users);
        return userJpaRespository.findByName(users.getName());
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public List<Users> load(@PathVariable final Integer id) {
        userJpaRespository.delete(id);
        return userJpaRespository.findAll();
    }
    
    @PostMapping(value = "/update")
    public Users update(@RequestBody final Users user) {
    	Users userFind = new Users(); 
    	userFind = userJpaRespository.findByName(user.getName());
    	userFind.setSalary(user.getSalary());
//    	userJpaRespository.delete(user.getId());
    	userJpaRespository.save(userFind);
        return userJpaRespository.findByName(user.getName()); 
    }
}
