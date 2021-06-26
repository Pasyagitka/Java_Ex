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

insert into Book values ('Булгаков', 'Мастер и Маргарита', 2000, 600),
 ('Гудкайнд', 'Меч истины', 1995, 1600),
('книга3', 'автор3', 2015, 200),
('книга4', 'автор3', 1939, 100),
 ('книга5', 'автор3', 2020, 800)
GO