package com.techprimers.repository;

import com.techprimers.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJpaRespository extends JpaRepository<Users, Integer>{

    Users findByName(String name);
    
    Users findById(Integer id);
}
