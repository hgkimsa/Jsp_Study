create table member (
	id varchar(10) not null, // 회원 아이디
	password varchar(10) not null, // 비밀번호
	name varchar(10) not null, // 이름
	gender varchar(4), // 성별
	birth varchar(10), // 생일
	mail varchar(30), // 메일
	phone varchar(30), // 전화번호
	address varchar(90), // 주소
	regist_day varchar(50), // 가입 일자
	primary key(id)  // 회원 아이디를 고유 키로 설정
) default CHARSET=utf8;