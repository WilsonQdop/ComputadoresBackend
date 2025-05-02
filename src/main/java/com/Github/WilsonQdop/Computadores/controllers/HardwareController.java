package com.Github.WilsonQdop.Computadores.controllers;

import com.Github.WilsonQdop.Computadores.dtos.CreateHardwareDTO;
import com.Github.WilsonQdop.Computadores.dtos.HardwareDTO;
import com.Github.WilsonQdop.Computadores.models.Hardware;
import com.Github.WilsonQdop.Computadores.services.HardwareService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hardware")
public class HardwareController {

    private HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @PostMapping("{id}")
    public ResponseEntity<HardwareDTO> createHardware (@RequestBody CreateHardwareDTO createHardwareDTO, @PathVariable
                                                       Integer id) {
        HardwareDTO hardware = this.hardwareService.createHardware(createHardwareDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(hardware);
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updateHardware (@PathVariable Integer id,
                                                @RequestBody CreateHardwareDTO createHardwareDTO) {
        this.hardwareService.updateHardware(createHardwareDTO, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteHardware (@PathVariable Integer id) {
        this.hardwareService.deleteHardware(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
