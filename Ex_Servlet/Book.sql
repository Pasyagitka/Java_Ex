use master
GO
create database Ex_Book
GO
use Ex_Book
GO
create table Book(
	id int identity(1,1) primary key,
	author nvarchar(30) not null,
	book_name nvarchar(30) not null,
	publication_year int not null,
	pages int not null	
)
GO

insert into Book values ('��������', '������ � ���������', 2000, 600),
 ('��������', '��� ������', 1995, 1600),
('�����3', '�����3', 2015, 200),
('�����4', '�����3', 1939, 100),
 ('�����5', '�����3', 2020, 800)
GO