package com.victorxavier.modularmonolith.modules.clientadmin.application.usecase;

import com.victorxavier.modularmonolith.modules.clientadmin.application.dto.FindClientInputDto;
import com.victorxavier.modularmonolith.modules.clientadmin.application.dto.FindClientOutputDto;
import com.victorxavier.modularmonolith.modules.clientadmin.domain.entity.Client;
import com.victorxavier.modularmonolith.modules.clientadmin.domain.repository.ClientRepository;
import com.victorxavier.modularmonolith.shared.usecase.UseCase;

public class FindClientUseCase implements UseCase<FindClientInputDto, FindClientOutputDto> {
    private final ClientRepository clientRepository;

    public FindClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public FindClientOutputDto execute(FindClientInputDto input) {
        Client client = clientRepository.findById(input.getId());

        return new FindClientOutputDto(
                client.getId().toString(),
                client.getName(),
                client.getEmail(),
                client.getAddress(),
                client.getCreatedAt(),
                client.getUpdatedAt()
        );
    }
}
