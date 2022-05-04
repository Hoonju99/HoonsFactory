--drop table tbl_counsel;
create table TBL_COUNSEL (
	NO	           number primary key,			
	EMPLOYEE_ID    varchar2(20),
	NAME           varchar2(20),
	COUNSEL_TYPE   varchar2(2),		
	DTTM           number
);
