package com.Github.WilsonQdop.Computadores.services;

import com.Github.WilsonQdop.Computadores.dtos.CreateHardwareDTO;
import com.Github.WilsonQdop.Computadores.dtos.HardwareDTO;
import com.Github.WilsonQdop.Computadores.interfaces.HardwareInterface;
import com.Github.WilsonQdop.Computadores.models.Hardware;
import com.Github.WilsonQdop.Computadores.models.Setup;
import com.Github.WilsonQdop.Computadores.repositories.HardwareRepository;
import org.springframework.stereotype.Service;

@Service
public class HardwareService implements HardwareInterface {

    HardwareRepository hardwareRepository;
    SetupService setupService;

    public HardwareService(HardwareRepository hardwareRepository, SetupService setupService) {
        this.hardwareRepository = hardwareRepository;
        this.setupService = setupService;
    }

    @Override
    public HardwareDTO createHardware(CreateHardwareDTO hardwareDTO, Integer setupId) {
        Setup setup = this.setupService.findSetup(setupId);

        Hardware hardware = new Hardware();
        hardware.setName(hardwareDTO.name());
        hardware.setDescription(hardwareDTO.description());
        hardware.setPrice(hardwareDTO.price());
        hardware.setUrl(hardwareDTO.url());
        hardware.setSetup(setup);

        this.hardwareRepository.save(hardware);

        return new HardwareDTO(hardwareDTO.name(), hardwareDTO.description(), hardwareDTO.price(), hardwareDTO.url());

    }
    
    @Override
    public void updateHardware(CreateHardwareDTO hardwareDTO, Integer hardwareId) {
        Hardware hardwareFound = this.findHardware(hardwareId);

        hardwareFound.setName(hardwareDTO.name());
        hardwareFound.setDescription(hardwareDTO.description());
        hardwareFound.setPrice(hardwareDTO.price());
        hardwareFound.setUrl(hardwareDTO.url());

        this.hardwareRepository.save(hardwareFound);
    }

    @Override
    public void deleteHardware(Integer hardwareId) {
        Hardware hardwareFound = this.findHardware(hardwareId);

        this.hardwareRepository.delete(hardwareFound);
    }

    @Override
    public Hardware findHardware(Integer hardwareId) {
        return this.hardwareRepository.findById(hardwareId).orElseThrow(() ->
                new RuntimeException("Hardware com o id: " + hardwareId + " não encontrado!"));
    }
}
