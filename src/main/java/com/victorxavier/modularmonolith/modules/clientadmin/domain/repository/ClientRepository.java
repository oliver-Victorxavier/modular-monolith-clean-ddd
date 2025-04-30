package com.victorxavier.modularmonolith.modules.clientadmin.domain.repository;

import com.victorxavier.modularmonolith.modules.clientadmin.domain.entity.Client;

public interface ClientRepository {
    void addClient(Client client);
    Client findById(String id);
}
