package com.jdt16.agenin.logging.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogRequestDTO {
    @JsonProperty("auditLogsId")
    @NotBlank(message = "Audit logs ID is required")
    private UUID logEntityDTOAuditLogsId;

    @JsonProperty("tableName")
    @NotBlank(message = "Table name is required")
    private String logEntityDTOTableName;

    @JsonProperty("recordId")
    @NotNull(message = "Record ID is required")
    private UUID logEntityDTORecordId;

    @JsonProperty("action")
    @NotBlank(message = "Action is required")
    private String logEntityDTOAction;

    @JsonProperty("oldData")
    @NotNull(message = "Old data is required")
    private Map<String, Object> logEntityDTOOldData;

    @JsonProperty("newData")
    @NotNull(message = "New data is required")
    private Map<String, Object> logEntityDTONewData;

    @JsonProperty("userAgent")
    @NotBlank(message = "User agent is required")
    private String logEntityDTOUserAgent;

    @JsonProperty("ipAddress")
    @NotBlank(message = "IP address is required")
    private String logEntityDTOIpAddress;

    @JsonProperty("changedAt")
    @NotNull(message = "Changed at timestamp is required")
    private LocalDateTime logEntityDTOChangedAt;

    @JsonProperty("roleId")
    @NotNull(message = "Role ID is required")
    private UUID logEntityDTORoleId;

    @JsonProperty("roleName")
    @NotBlank(message = "Role name is required")
    private String logEntityDTORoleName;

    @JsonProperty("userId")
    @NotNull(message = "User ID is required")
    private UUID logEntityDTOUserId;

    @JsonProperty("userFullname")
    @NotBlank(message = "User fullname is required")
    private String logEntityDTOUserFullname;
}
