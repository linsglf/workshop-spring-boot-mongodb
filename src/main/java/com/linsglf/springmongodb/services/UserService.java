package com.linsglf.springmongodb.services;

import com.linsglf.springmongodb.domain.User;
import com.linsglf.springmongodb.dto.UserDTO;
import com.linsglf.springmongodb.repository.UserRepository;
import com.linsglf.springmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.id(), objDto.name(), objDto.email());
    }
}
