-- ��������(system������ ����
create user angel identified by a1234;
-- �ֽŹ��������� �տ� ���빮�� c##�� �ٿ��� ���������� �ؾ߸��Ѵ�
create user c##angel identified by a1234;
--system �������� ������ ���� Ȯ��
select username from dba_users;
--c##angel ���� �����ϱ�
drop user c##angel;
--c##���빮�ڸ� �Ⱥ��̰� ���������� �Ϸ��� ���Ǻ����� �ؾ��Ѵ�
alter SESSION set "_ORACLE_SCRIPT"=true;
--angel ���� �ٽ� ���� (����� ���� �����̾����)
create user angel identified by a1234;
--