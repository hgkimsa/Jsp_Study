package com.seoil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Todo_DTO {
	private int IDX;
	private String todo_startdate;
	private String todo_deaddate;
	private String todo_memo;
	private String todo_file_path;
	private int is_important;
	private String created_at;
}