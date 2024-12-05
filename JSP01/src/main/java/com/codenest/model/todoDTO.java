package com.codenest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class todoDTO {
    private int IDX;
    private String google_account;
    private String todo_startdate; // String으로 유지
    private String todo_deaddate; // String으로 유지
    private String todo_memo;
    private String todo_file_path;
    private int is_important;
    private String created_at; // java.util.Date 사용
}