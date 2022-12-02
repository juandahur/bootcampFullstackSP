package com.sophos.backendSophos.repository;

import com.sophos.backendSophos.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
