package com.Github.WilsonQdop.Computadores.controllers;

import com.Github.WilsonQdop.Computadores.dtos.UsersDTO;
import com.Github.WilsonQdop.Computadores.models.Users;
import com.Github.WilsonQdop.Computadores.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UsersService usersServices;

    public UserController(UsersService usersServices) {
        this.usersServices = usersServices;
    }

    @PostMapping
    public ResponseEntity<Users> createUser (@RequestBody UsersDTO usersDTO){
       Users newUser = this.usersServices.createUsers(usersDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> findUsers (@PathVariable Integer id) {
        Users usersFound = this.usersServices.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(usersFound);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUsers (@PathVariable Integer id) {
        this.usersServices.deleteUsers(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateUsers (@PathVariable Integer id, @RequestBody UsersDTO usersDTO) {
        this.usersServices.updateUsers(usersDTO, id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
