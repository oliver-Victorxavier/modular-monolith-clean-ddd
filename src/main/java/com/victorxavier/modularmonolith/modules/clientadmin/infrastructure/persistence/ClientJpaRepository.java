package com.victorxavier.modularmonolith.modules.clientadmin.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<ClientJpaEntity, String> {

}
