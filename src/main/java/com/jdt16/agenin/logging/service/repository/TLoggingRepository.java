package com.jdt16.agenin.logging.service.repository;

import com.jdt16.agenin.logging.dto.entity.LoggingEntityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TLoggingRepository extends JpaRepository<LoggingEntityDTO, UUID> {
}
