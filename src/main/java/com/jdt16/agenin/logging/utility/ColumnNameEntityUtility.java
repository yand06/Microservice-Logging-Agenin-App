package com.jdt16.agenin.logging.utility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ColumnNameEntityUtility {
    /* M_USERS */
    public static final String COLUMN_USERS_ID = "user_id";
    public static final String COLUMN_USERS_NAME = "user_name";
    public static final String COLUMN_USERS_EMAIL = "user_email";
    public static final String COLUMN_USERS_PASSWORD = "user_password";
    public static final String COLUMN_USERS_CREATED_DATE = "user_created_date";

    /* T_AUDIT_LOGS */
    public static final String COLUMN_LOGGING_ID = "audit_logs_id";
    public static final String COLUMN_LOGGING_TABLE_NAME = "table_name";
    public static final String COLUMN_LOGGING_RECORD_ID = "record_id";
    public static final String COLUMN_LOGGING_ACTION = "action";
    public static final String COLUMN_LOGGING_OLD_DATA = "old_data";
    public static final String COLUMN_LOGGING_NEW_DATA = "new_data";
    public static final String COLUMN_LOGGING_USER_AGENT = "user_agent";
    public static final String COLUMN_LOGGING_IP_ADDRESS = "ip_address";
    public static final String COLUMN_LOGGING_CHANGED_AT = "changed_at";
    public static final String COLUMN_LOGGING_ROLE_ID = "role_id";
    public static final String COLUMN_LOGGING_ROLE_NAME = "role_name";
    public static final String COLUMN_LOGGING_USER_ID = "id_user";
    public static final String COLUMN_LOGGING_USER_FULLNAME = "user_fullname";
}
