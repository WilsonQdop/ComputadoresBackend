package com.Github.WilsonQdop.Computadores.interfaces;

import com.Github.WilsonQdop.Computadores.dtos.UsersDTO;
import com.Github.WilsonQdop.Computadores.models.Users;

import java.util.List;

public interface UsersInterface {

    Users findById(Integer id);
    Users createUsers(UsersDTO users);
    void deleteUsers(Integer id);
    void updateUsers(UsersDTO users, Integer id);
}
