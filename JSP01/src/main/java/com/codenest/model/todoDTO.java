package com.codenest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class todoDTO {
    private int idx;                          // TODO_LIST의 IDX에 해당하는 필드
    private String google_account;             // TODO_LIST의 GOOGLE_ACCOUNT에 해당하는 필드
    private String todo_startdate;             // TODO_LIST의 TODO_STARTDATE에 해당하는 필드
    private String todo_deaddate;              // TODO_LIST의 TODO_DEADDATE에 해당하는 필드
    private String todo_memo;                  // TODO_LIST의 TODO_MEMO에 해당하는 필드
    private String todo_file_path;             // TODO_LIST의 TODO_FILE_PATH에 해당하는 필드
    private int is_important;                   // TODO_LIST의 IS_IMPORTANT에 해당하는 필드
    private Timestamp created_at;               // TODO_LIST의 CREATED_AT에 해당하는 필드
}