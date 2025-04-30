package com.victorxavier.modularmonolith.modules.clientadmin.application.usecase;

import com.victorxavier.modularmonolith.modules.clientadmin.application.dto.AddClientInputDto;
import com.victorxavier.modularmonolith.modules.clientadmin.domain.entity.Client;
import com.victorxavier.modularmonolith.modules.clientadmin.domain.repository.ClientRepository;
import com.victorxavier.modularmonolith.shared.domain.valueobject.Address;
import com.victorxavier.modularmonolith.shared.domain.valueobject.Id;
import com.victorxavier.modularmonolith.shared.usecase.UseCase;

public class AddClientUseCase implements UseCase<AddClientInputDto, Void> {

    private final ClientRepository clientRepository;

    public AddClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Void execute(AddClientInputDto input) {
        Client client = new Client(
                input.getId() != null ? new Id(input.getId()) : null,
                input.getName(),
                input.getEmail(),
                new Address(
                        input.getStreet(),
                        input.getNumber(),
                        input.getComplement(),
                        input.getCity(),
                        input.getState(),
                        input.getZipCode()
                )
        );

        clientRepository.addClient(client);
        return null;
    }
}
