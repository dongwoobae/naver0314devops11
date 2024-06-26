-- 계정생성(system에서만 가능
create user angel identified by a1234;
-- 최신버전에서는 앞에 공통문자 c##을 붙여서 계정생성을 해야만한다
create user c##angel identified by a1234;
--system 계정에서 생성된 계정 확인
select username from dba_users;
--c##angel 계정 삭제하기
drop user c##angel;
--c##공통문자를 안붙이고 계정생성을 하려면 세션변경을 해야한다
alter SESSION set "_ORACLE_SCRIPT"=true;
--angel 계정 다시 생성 (비번은 문자 시작이어야함)
create user angel identified by a1234;
--