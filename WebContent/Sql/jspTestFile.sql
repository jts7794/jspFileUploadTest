create database jspTestFile;

use jspTestFile;

create table File(
fileName varchar(200),
fileRealName varchar(200)
);

//파일 다운로드 횟수 적용 -> 테이블에 새로운 속성 추가
alter table file add (downloadCount int);

//확인 쿼리
desc file;