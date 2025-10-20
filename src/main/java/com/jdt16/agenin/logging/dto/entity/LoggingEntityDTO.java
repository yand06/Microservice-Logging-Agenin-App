package com.jdt16.agenin.logging.dto.entity;


import com.jdt16.agenin.logging.utility.ColumnNameEntityUtility;
import com.jdt16.agenin.logging.utility.TableNameEntityUtility;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = TableNameEntityUtility.T_AUDIT_LOGS)
public class LoggingEntityDTO {
    @Id
    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_ID, nullable = false, updatable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID logEntityDTOId;

    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_TABLE_NAME, nullable = false)
    private String logEntityDTOTableName;

    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_RECORD_ID, nullable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID logEntityDTORecordId;

    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_ACTION, nullable = false)
    private String logEntityDTOAction;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_OLD_DATA, nullable = false, columnDefinition = "jsonb")
    private Map<String, Object> logEntityDTOOldData;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_NEW_DATA, nullable = false, columnDefinition = "jsonb")
    private Map<String, Object> logEntityDTONewData;

    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_USER_AGENT, nullable = false)
    private String logEntityDTOUserAgent;

    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_IP_ADDRESS, nullable = false)
    private String logEntityDTOIpAddress;

    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_CHANGED_AT, nullable = false)
    private LocalDateTime logEntityDTOChangedAt;

    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_ROLE_ID, nullable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID logEntityDTORoleId;

    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_ROLE_NAME, nullable = false)
    private String logEntityDTORoleName;

    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_USER_ID, nullable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID logEntityDTOUserId;

    @Column(name = ColumnNameEntityUtility.COLUMN_LOGGING_USER_FULLNAME, nullable = false)
    private String logEntityDTOUserFullname;
}