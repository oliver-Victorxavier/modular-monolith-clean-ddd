package com.victorxavier.modularmonolith.modules.clientadmin.infrastructure.persistence;

import com.victorxavier.modularmonolith.modules.clientadmin.domain.entity.Client;
import com.victorxavier.modularmonolith.modules.clientadmin.domain.repository.ClientRepository;
import com.victorxavier.modularmonolith.shared.domain.valueobject.Id;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientJpaRepository clientJpaRepository;

    public ClientRepositoryImpl(ClientJpaRepository clientJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
    }

    @Override
    public void addClient(Client client) {
        ClientJpaEntity entity = new ClientJpaEntity(
                client.getId().toString(),
                client.getName(),
                client.getEmail(),
                client.getAddress(),
                client.getCreatedAt(),
                client.getUpdatedAt()
        );
        clientJpaRepository.save(entity);
    }

    @Override
    public Client findById(String id) {
        ClientJpaEntity entity = clientJpaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client not found with id " + id));

        return new Client(
                new Id(entity.getId()),
                entity.getName(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
