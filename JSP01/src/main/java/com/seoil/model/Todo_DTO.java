package com.seoil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Todo_DTO {
	private int IDX; // 고유 식별자
	private String todo_startdate; // 시작 날짜
	private String todo_deaddate; // 마감 날짜
	private String todo_memo; // 메모 내용
	private String todo_file_path; // 파일 경로
	private int is_important; // 중요도 표시 (1: 중요, 0: 일반)
	private String created_at; // 생성 날짜 및 시간
}