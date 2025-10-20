package com.jdt16.agenin.logging.service.consumer;

import com.jdt16.agenin.logging.dto.entity.LoggingEntityDTO;
import com.jdt16.agenin.logging.dto.request.LogRequestDTO;
import com.jdt16.agenin.logging.service.repository.TLoggingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoggerConsumerService {

    private final TLoggingRepository tLoggingRepository;

    @KafkaListener(
            topics = "${request-topic.create-log-topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void loggerListener(LogRequestDTO logRequest) {
        log.info("Received audit log message: auditLogsId={}, tableName={}",
                logRequest.getLogEntityDTOAuditLogsId(),
                logRequest.getLogEntityDTOTableName());

        // Call transactional method
        saveAuditLog(logRequest);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)  // Force new transaction
    public void saveAuditLog(LogRequestDTO logRequest) {
        if (logRequest.getLogEntityDTOAuditLogsId() == null) {
            log.warn("Skipping message with null auditLogsId");
            return;
        }

        if (tLoggingRepository.existsById(logRequest.getLogEntityDTOAuditLogsId())) {
            log.warn("Duplicate audit log detected, skipping: ID={}",
                    logRequest.getLogEntityDTOAuditLogsId());
            return;
        }

        LoggingEntityDTO entity = LoggingEntityDTO.builder()
                .logEntityDTOId(logRequest.getLogEntityDTOAuditLogsId())
                .logEntityDTOTableName(logRequest.getLogEntityDTOTableName())
                .logEntityDTORecordId(logRequest.getLogEntityDTORecordId())
                .logEntityDTOAction(logRequest.getLogEntityDTOAction())
                .logEntityDTOOldData(logRequest.getLogEntityDTOOldData())
                .logEntityDTONewData(logRequest.getLogEntityDTONewData())
                .logEntityDTOUserAgent(logRequest.getLogEntityDTOUserAgent())
                .logEntityDTOIpAddress(logRequest.getLogEntityDTOIpAddress())
                .logEntityDTOChangedAt(logRequest.getLogEntityDTOChangedAt())
                .logEntityDTORoleId(logRequest.getLogEntityDTORoleId())
                .logEntityDTORoleName(logRequest.getLogEntityDTORoleName())
                .logEntityDTOUserId(logRequest.getLogEntityDTOUserId())
                .logEntityDTOUserFullname(logRequest.getLogEntityDTOUserFullname())
                .build();

        tLoggingRepository.saveAndFlush(entity);

        log.info("Audit log saved and committed successfully: ID={}", entity.getLogEntityDTOId());
    }
}
