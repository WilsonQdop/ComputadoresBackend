package com.Github.WilsonQdop.Computadores.interfaces;

import com.Github.WilsonQdop.Computadores.dtos.CreateHardwareDTO;
import com.Github.WilsonQdop.Computadores.dtos.HardwareDTO;
import com.Github.WilsonQdop.Computadores.models.Hardware;

public interface HardwareInterface {

    HardwareDTO createHardware (CreateHardwareDTO hardwareDTO, Integer setupId);
    void updateHardware (CreateHardwareDTO hardwareDTO, Integer hardwareId);
    void deleteHardware (Integer hardwareId);
    Hardware findHardware (Integer hardwareId);
}
