--ī�信�� scott_table�� �ٿ�޾� git�� ���� �� 
--cmdâ���� git������ �̵� �� (cd git)
--@scott_table ����
--�ڵ����� �ȿ� �ִ� sql��ɾ ����˴ϴ�
--select * from tab;���� Ȯ��
select * from tab;--������ ���̺� Ȯ��
select * from emp;--emp ���̺��� ������ ������ Ȯ��
commit;

--emp ���̺��� ���� Ȯ��
desc emp;

--��ü �÷����� emp���̺� ��ȸ(* �� ��ü�÷��� ����)
select * from emp;
--ename,job �÷��� ��ȸ
select ename,job from emp;
--ename,job �÷��� ��ȸ, ename�� ��������(asc) ��������(desc)���� ��ȸ
select ename,job from emp order by ename asc;--���������� ��� ��������
select ename,job from emp order by ename desc;

--job ��ȸ
select job from emp;

--job�� ��ȸ�ϴµ� ���� ������ �ѹ��� ������
select DISTINCT job from emp;

--��������
select DISTINCT job from emp order by job;
--��������
select DISTINCT job from emp order by job desc;

select DISTINCT job from emp order by 1;--�÷���ȣ�� 1������, 

--ename�� smith �� ��� ��ȸ
select * from emp where ename = 'SMITH';
select * from emp where ename = 'ward';--sql ��ɾ�� ��ҹ��� ��������� ������ ���� ����������Ѵ�.

select * from emp where ename='SMITH' or ename='WARD';


--ename, sal�� ��ȸ
select ename, sal from emp;

--�÷������� ����
select ename "�����",sal "�޿�" from emp;--���� ����� ������ ���Ե�������� �ݵ�� ""�� �����ش�. �ƴϸ� ���� ����
select ename �����,sal �޿� from emp;

--�����÷��� ���ؼ� �ϳ��� �÷����� ����� ���
select '���̸���'||ename||'�̰� ������'||job||'�Դϴ�' from emp;
select '���̸���'||ename||'�̰� ������'||job||'�Դϴ�'  "���"from emp;
select ename||'���� ������'||sal||'�����Դϴ�' "����" from emp;
--sal ������ 2000~3000 ���� ��ȸ(�÷��� ename�� sal)
select  ename,sal from emp where sal>=2000 and sal<=3000;
--between �̿��ؼ� ��ȸ
select ename,sal from emp where sal between 1000 and 2000;

--������ salesman�̰ų� manager,clerk �̸� ��ȸ
select ename,job from emp where job = 'SALESMAN' or job='MANAGER' or job = 'CLERK';

--IN(LIST)���� OR�� ������ �Ҽ��ִ�.(��ȸ�Ұ� ������)
select ename,job from emp where job IN ('SALESMAN','MANAGER','CLERK');

--MGR�� 7902,7839,7788 ��ȸ(�÷��� ename,job,mgr)
select ename,job,mgr from emp where mgr in ('7902','7839','7788');

--mgr�� null�� ���
select * from emp where mgr is null;

--comm�� null�� ���
select * from emp where comm is null;
select * from emp where comm is not null;

--���� ��ȸ�� % �Ǵ� _�� �̿��ؼ� ��ȸ
--ename�� a�� �����ϴ� ��� ��ȸ
select ename,sal from emp where ename like 'A%';
--n���� ������ ���
select ename,sal from emp where ename like '%N';

--�̸��� �ι�° ���ڰ� a�� ���
select ename,sal from emp where ename like '_A%';

--����°�� a(����� �Ѱ��� �� ���ڸ� ����)
select ename,sal from emp where ename like '__A%';

--�÷��� ename�� sal, �̸��� s�� m���� �����ϴ� ���
select ename,sal from emp where ename like 'S%' or ename like 'M%';
--�̸��� s�� �����ϴ� ��� �߿� ������ 2000�̻��� ���
select ename,sal from emp where ename like 'S%' and sal>=2000;
--mgr �� 7902,7788,7566�� �ƴѻ��
select ename,sal,mgr from emp where mgr not in ('7902','7788','7566');

--comm,comm+1000 �� ��� ���
select comm,comm+1000 from emp;

--����Ŭ �Լ� �� NVL(�÷���,null�� ��� �ʱⰪ),mysql�� ifnull 
select NVL(comm,0),NVL(comm,0)+1000 from emp;
--�÷����� ����
select NVL(comm,0) COMM,NVL(comm,0)+1000 "COMM2" from emp;

--SAL�� 2000~3000�� �ƴ� ��� ��ȸ
SELECT ENAME,SAL FROM EMP WHERE SAL<2000 OR SAL>3000;
SELECT ENAME,SAL FROM EMP WHERE SAL NOT BETWEEN 2000 AND 3000;

--GROUP �Լ� (COUNT,MAX,MIN,AVG,SUM)
SELECT COUNT(*) FROM EMP;
SELECT MAX(SAL) FROM EMP;
SELECT MIN(SAL) FROM EMP;
SELECT SUM(SAL) FROM EMP;
SELECT AVG(SAL) FROM EMP;
--AVG�� �Ҽ������ϰ� ���� ������ ��찡 ��Ƽ� ROUND, CEIL, FLOOR��� ���� ���� ���
SELECT ROUND(AVG(SAL),2) FROM EMP;--�ݿø�
SELECT FLOOR(AVG(SAL)) FROM EMP;--���� 2073
SELECT CEIL(AVG(SAL)) FROM EMP;--�ø� 2074

--PPT 57������ GROUP BY ��
--JOB �� �׷����� ������ �� �ο����� ���غ���
SELECT JOB ����,COUNT(*) �ο��� FROM EMP GROUP BY JOB;

--���� ����� ������ ��������
SELECT JOB ����,COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY 1;
SELECT JOB ����,COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY ����;

--�ο����� ��������
SELECT JOB ����,COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY �ο���;
SELECT JOB ����,COUNT(*) �ο��� FROM EMP GROUP BY JOB ORDER BY 2;

--������ �ο����� �ְ���, ��������,��տ��� (�ø�) 
SELECT JOB ���� ,COUNT(*) �ο��� ,MAX(SAL) �ְ���,MIN(SAL) �������� ,CEIL(AVG(SAL)) ��տ��� FROM EMP GROUP BY JOB ORDER BY 2;

--HAVING�� GROUP������ �׷��Լ��� �̿��� ������ ��Ÿ�� ���
--������ �ο����� �ְ���, ������ �ο����� 3�� �̻��� ��� ��ȸ
SELECT JOB,COUNT(*),MAX(SAL) FROM EMP GROUP BY JOB HAVING COUNT(JOB)>=3;

--����Ŭ������ ���糯¥�� ���Ҷ� SYSDATE, MYSQL�� NOW()
SELECT SYSDATE FROM DUAL;
--3�� �ڴ� �����ΰ�
SELECT SYSDATE + 3 FROM DUAL;
--30�� �� 
SELECT SYSDATE +30 FROM DUAL;

--��¥Ÿ���� ���ڿ��� ��ȯ TO_CHAR : ��ȣ Y,M,D,HH,HH24,MI,SS,AM/PM 
SELECT TO_CHAR (SYSDATE,'YYYY') FROM DUAL; --2024
SELECT TO_CHAR (SYSDATE,'YEAR') FROM DUAL;--���� ����,Ÿ ���α׷����� ���޾Ƽ� �߾Ⱦ�

SELECT TO_CHAR (SYSDATE,'MM') FROM DUAL;
SELECT TO_CHAR (SYSDATE,'MONTH') FROM DUAL;

--��ȣ�� ���� ���µ� �پ��� ��ȣ�� ��¥�� ����غ���
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD AM HH:MI') FROM DUAL;--AM�̳� PM ���� �ƹ��ų� ���� ���� ���� ǥ��
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI') FROM DUAL;

--EMP���� HIREDATE(��¥Ÿ��)�� �̿��ؼ� ���
SELECT ENAME,JOB,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP;

--���⵵ 1987���� ��� ���
SELECT ENAME,JOB,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')='1987';
SELECT ENAME,JOB,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')=1987;

--������ 5���� ��� ���
SELECT ENAME,JOB,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'MM')='05';
SELECT ENAME,JOB,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'MM')=5;

--SUBQUERY (SELECT�� �ȿ� �� SELECT ���� �ִ� ���)
--SCOTT�� ������ ���� ������ ���� ����� ���Ͻÿ�
SELECT * FROM EMP WHERE SAL=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');
--��� �������� ���� �޴� ����� ���� ���
SELECT * FROM EMP WHERE SAL>=(SELECT AVG(SAL) FROM EMP) ORDER BY SAL;








