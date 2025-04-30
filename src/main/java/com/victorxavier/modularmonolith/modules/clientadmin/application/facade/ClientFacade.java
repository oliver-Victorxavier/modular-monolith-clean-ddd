package com.victorxavier.modularmonolith.modules.clientadmin.application.facade;

import com.victorxavier.modularmonolith.modules.clientadmin.application.dto.AddClientInputDto;
import com.victorxavier.modularmonolith.modules.clientadmin.application.dto.FindClientInputDto;
import com.victorxavier.modularmonolith.modules.clientadmin.application.dto.FindClientOutputDto;

public interface ClientFacade {
    void addClient(AddClientInputDto input);
    FindClientOutputDto findClient(FindClientInputDto input);
}
