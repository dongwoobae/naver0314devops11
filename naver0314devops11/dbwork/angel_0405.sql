select pnum,pname,page||'��' page ,upper(pblood)||'��' pblood,
to_char(ipsaday,'yyyy-mm-dd hh:mi') ipsaday from person;
insert into person  values (null,name,blood,age,sysdate);
select * from person;