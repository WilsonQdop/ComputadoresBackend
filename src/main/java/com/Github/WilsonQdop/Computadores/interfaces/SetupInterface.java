package com.Github.WilsonQdop.Computadores.interfaces;

import com.Github.WilsonQdop.Computadores.dtos.CreateSetupDTO;
import com.Github.WilsonQdop.Computadores.dtos.SetupDTO;
import com.Github.WilsonQdop.Computadores.models.Setup;

public interface SetupInterface {

    SetupDTO createSetup (CreateSetupDTO CreateSetup, Integer userId);
    Setup findSetup(Integer setupId);
    void deleteSetup(Integer setupId);

}
