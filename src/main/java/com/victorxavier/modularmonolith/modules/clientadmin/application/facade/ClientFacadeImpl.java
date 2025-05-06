package com.victorxavier.modularmonolith.modules.clientadmin.application.facade;

import com.victorxavier.modularmonolith.modules.clientadmin.application.dto.AddClientInputDto;
import com.victorxavier.modularmonolith.modules.clientadmin.application.dto.FindClientInputDto;
import com.victorxavier.modularmonolith.modules.clientadmin.application.dto.FindClientOutputDto;
import com.victorxavier.modularmonolith.shared.usecase.UseCase;

public class ClientFacadeImpl implements ClientFacade{
    private final UseCase<AddClientInputDto, Void> addClientUseCase;
    private final UseCase<FindClientInputDto, FindClientOutputDto> findClientUseCase;

    public ClientFacadeImpl(UseCase<AddClientInputDto, Void> addClientUseCase,
                            UseCase<FindClientInputDto, FindClientOutputDto> findClientUseCase) {
        this.addClientUseCase = addClientUseCase;
        this.findClientUseCase = findClientUseCase;
    }

    @Override
    public void addClient(AddClientInputDto input) {
        addClientUseCase.execute(input);
    }
    @Override
    public FindClientOutputDto findClient(FindClientInputDto input) {
        return findClientUseCase.execute(input);
    }
}