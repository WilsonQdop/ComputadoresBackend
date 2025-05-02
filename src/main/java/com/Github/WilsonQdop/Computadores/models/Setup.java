package com.Github.WilsonQdop.Computadores.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Setup {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer setupId;
    private String name;

    @ManyToOne
    private Users user;

    @OneToMany(mappedBy = "setup", cascade = CascadeType.ALL) @JsonManagedReference
    List<Hardware> hardwares = new ArrayList<>();

    public Integer getSetupId() {
        return setupId;
    }

    public void setSetupId(Integer setupId) {
        this.setupId = setupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Hardware> getHardwares() {
        return hardwares;
    }

    public void setHardwares(List<Hardware> hardwares) {
        this.hardwares = hardwares;
    }
}
