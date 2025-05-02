package com.Github.WilsonQdop.Computadores.repositories;

import com.Github.WilsonQdop.Computadores.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
