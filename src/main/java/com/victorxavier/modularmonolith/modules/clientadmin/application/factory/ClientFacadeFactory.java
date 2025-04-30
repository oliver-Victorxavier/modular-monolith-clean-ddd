package com.victorxavier.modularmonolith.modules.clientadmin.application.factory;

import com.victorxavier.modularmonolith.modules.clientadmin.application.facade.ClientFacade;
import com.victorxavier.modularmonolith.modules.clientadmin.application.facade.ClientFacadeImpl;
import com.victorxavier.modularmonolith.modules.clientadmin.application.usecase.AddClientUseCase;
import com.victorxavier.modularmonolith.modules.clientadmin.application.usecase.FindClientUseCase;
import com.victorxavier.modularmonolith.modules.clientadmin.domain.repository.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientFacadeFactory {
    private final ClientRepository clientRepository;

    public ClientFacadeFactory(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Bean
    public ClientFacade createClientFacade() {
        var addClientUseCase = new AddClientUseCase(clientRepository);
        var findClientUseCase = new FindClientUseCase(clientRepository);

        return new ClientFacadeImpl(addClientUseCase, findClientUseCase);
    }
}