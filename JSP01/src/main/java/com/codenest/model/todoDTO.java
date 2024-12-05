package com.codenest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class todoDTO {
    private int idx;                          // Corresponds to IDX in TODO_LIST
    private String google_account;             // Corresponds to GOOGLE_ACCOUNT in TODO_LIST
    private String todo_startdate;             // Corresponds to TODO_STARTDATE in TODO_LIST
    private String todo_deaddate;              // Corresponds to TODO_DEADDATE in TODO_LIST
    private String todo_memo;                  // Corresponds to TODO_MEMO in TODO_LIST
    private String todo_file_path;             // Corresponds to TODO_FILE_PATH in TODO_LIST
    private int is_important;                   // Corresponds to IS_IMPORTANT in TODO_LIST
    private Timestamp created_at;               // Corresponds to CREATED_AT in TODO_LIST
}