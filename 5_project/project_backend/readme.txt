Oracle DB :
alter session set "_ORACLE_SCRIPT"=true;

CREATE USER scott IDENTIFIED BY tiger;
GRANT CONNECT TO scott;
GRANT CONNECT, RESOURCE TO scott;
GRANT CREATE SESSION  TO scott;

GRANT UNLIMITED TABLESPACE TO scott;

SELECT * FROM all_users where username='scott';

select * from user_tables;

http://localhost:8080/auth/addNewUser
{
"name":"vinsys",
"password":"123",
"email":"test@vinsys.com",
"roles":"ROLE_USER"
}

http://localhost:8080/auth/generateToken
{
"username":"vinsys",
"password":"123",
}

http://localhost:8080/airports/bytype/small_airport (pass the token generated )