package com.Github.WilsonQdop.Computadores.services;

import com.Github.WilsonQdop.Computadores.dtos.UsersDTO;
import com.Github.WilsonQdop.Computadores.interfaces.UsersInterface;
import com.Github.WilsonQdop.Computadores.models.Users;
import com.Github.WilsonQdop.Computadores.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService implements UsersInterface {

     UsersRepository usersRepository;


    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public Users findById(Integer id) {
             return usersRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuário com id: " + id + " não encontrado"));

    }

    @Override
    public Users createUsers(UsersDTO usersDTO) {
        Users newUsers = new Users();

        newUsers.setName(usersDTO.name());
        newUsers.setEmail(usersDTO.email());
        newUsers.setPassword(usersDTO.password());

        return this.usersRepository.save(newUsers);

    }

    @Override
    public void deleteUsers(Integer id) {
        Users userExists = this.findById(id);

        this.usersRepository.delete(userExists);


    }

    @Override
    public void updateUsers(UsersDTO users, Integer id) {
        Users updateUser = this.findById(id);

        updateUser.setName(users.name());
        updateUser.setEmail(users.email());
        updateUser.setPassword(users.password());

        this.usersRepository.save(updateUser);
    }

}
