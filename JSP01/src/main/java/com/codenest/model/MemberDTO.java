package com.codenest.model;

import lombok.AllArgsConstructor; // 모든 필드를 매개변수로 받는 생성자를 생성하는 어노테이션
import lombok.Data; // getter, setter, toString, equals, hashCode 메서드를 자동으로 생성하는 어노테이션
import lombok.NoArgsConstructor; // 기본 생성자를 생성하는 어노테이션

@Data // 이 클래스의 모든 필드에 대한 getter와 setter 메서드를 자동으로 생성
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
public class MemberDTO {
    private String google_account; // 구글 계정
    private String nickname;        // 사용자 닉네임
    private String password;        // 비밀번호
    private String address;         // 주소
    private String birthday;        // 생일
}