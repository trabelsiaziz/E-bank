package org.aziz.ebank.repositories;

import org.aziz.ebank.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
