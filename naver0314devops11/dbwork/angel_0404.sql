-- �ڹٿ��� ������ ������, ���̺� ����
create sequence seq_test nocache;

create table person (
    pnum number(3) CONSTRAINT pk_pnum primary key,
    pname varchar2(20),
    pblood varchar2(5) default 'B',
    page number(3),
    ipsaday date        
);

-- 5�� ���� ������ �߰�
insert into person values (seq_test.nextval,'�̻��','A',34,'2010-12-20');
insert into person values (seq_test.nextval,'��ȿ��','B',41,'2002-11-24');
insert into person values (seq_test.nextval,'���ҿ�','A',37,'2011-06-11');
insert into person values (seq_test.nextval,'�����','o',28,sysdate);
insert into person values (seq_test.nextval,'��ö��','AB',55,'1992-10-21');
commit;

select * from person;

delete from person where pnum>=6 and pnum<=9;

select pnum,pname,upper(pblood),page,to_char(ipsaday,'yyyy-mm-dd') ipsaday from person;
commit;

