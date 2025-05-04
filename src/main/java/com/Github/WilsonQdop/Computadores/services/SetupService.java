package com.Github.WilsonQdop.Computadores.services;

import com.Github.WilsonQdop.Computadores.dtos.CreateSetupDTO;
import com.Github.WilsonQdop.Computadores.dtos.HardwareDTO;
import com.Github.WilsonQdop.Computadores.dtos.SetupDTO;
import com.Github.WilsonQdop.Computadores.dtos.UpdateNameSetup;
import com.Github.WilsonQdop.Computadores.exceptions.SetupNotFoundException;
import com.Github.WilsonQdop.Computadores.interfaces.SetupInterface;
import com.Github.WilsonQdop.Computadores.models.Hardware;
import com.Github.WilsonQdop.Computadores.models.Setup;
import com.Github.WilsonQdop.Computadores.models.Users;
import com.Github.WilsonQdop.Computadores.repositories.SetupRepository;

import org.hibernate.validator.spi.nodenameprovider.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;


@Service
public class SetupService implements SetupInterface {

    private SetupRepository setupRepository;
    @Autowired
    private UsersService usersService;

    public SetupService(SetupRepository setupRepository) {
        this.setupRepository = setupRepository;
    }


    @Override
    public SetupDTO createSetup(CreateSetupDTO createSetup, Integer userId) {
        Users user = this.usersService.findById(userId);

        Setup setup = new Setup();
        setup.setName(createSetup.name());
        setup.setUser(user);

        Setup newSetup = this.setupRepository.save(setup);

        List<Hardware> hardwareList = new ArrayList<>();
        for (HardwareDTO hardwareDTO : createSetup.hardware()) {
            Hardware h = new Hardware();
            h.setName(hardwareDTO.name());
            h.setDescription(hardwareDTO.description());
            h.setPrice(hardwareDTO.price());
            h.setUrl(hardwareDTO.url());
            h.setSetup(newSetup);
            hardwareList.add(h);
        }
        newSetup.setHardwares(hardwareList);

        setup.setHardwares(hardwareList);
        this.setupRepository.save(newSetup);

        List<HardwareDTO> hardwareDTOs = newSetup.getHardwares().stream().map(h ->
                new HardwareDTO(h.getName(), h.getDescription(), h.getPrice(), h.getUrl())
        ).toList();

        return new SetupDTO(newSetup.getSetupId(), newSetup.getName(), hardwareDTOs);
    }

    @Override
    public Setup findSetup(Integer setupId) {
        return this.setupRepository.findById(setupId).orElseThrow(() ->
                new SetupNotFoundException("Setup com ID " + setupId + " não encontrado"));

    }

    @Override
    public void deleteSetup(Integer setupId) {
        Setup findSetup = this.findSetup(setupId);

        this.setupRepository.delete(findSetup);
    }

    public void updateSetup (Integer id, UpdateNameSetup newName) {
        Setup name = this.findSetup(id);

        name.setName(newName.name());

        this.setupRepository.save(name);
    }
}
