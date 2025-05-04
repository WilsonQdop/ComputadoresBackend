package com.Github.WilsonQdop.Computadores.controllers;

import com.Github.WilsonQdop.Computadores.dtos.CreateSetupDTO;
import com.Github.WilsonQdop.Computadores.dtos.SetupDTO;
import com.Github.WilsonQdop.Computadores.dtos.UpdateNameSetup;
import com.Github.WilsonQdop.Computadores.models.Setup;
import com.Github.WilsonQdop.Computadores.services.SetupService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("setup")
public class SetupController {

    private SetupService setupService;

    public SetupController(SetupService setupService) {
        this.setupService = setupService;
    }
    @PostMapping("{id}")
    public ResponseEntity<SetupDTO> createSetup (@RequestBody @Valid CreateSetupDTO createSetup, @PathVariable Integer id) {
       SetupDTO newSetup = this.setupService.createSetup(createSetup, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSetup);
    }

    @GetMapping("{id}")
    public ResponseEntity<Setup> findSetup (@PathVariable Integer id) {
        Setup setup = this.setupService.findSetup(id);
        return ResponseEntity.status(HttpStatus.OK).body(setup);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSetup (@PathVariable Integer id) {
        this.setupService.deleteSetup(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<String> updateSetup (@PathVariable Integer id, @RequestBody @Valid UpdateNameSetup name) {
        this.setupService.updateSetup(id, name);
        return ResponseEntity.status(HttpStatus.OK).body("Alterado com sucesso");
    }
}
