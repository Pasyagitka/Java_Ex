use master
GO
create database Ex_Like
GO
use Ex_Like
GO
create table LikeOrDislike(
	text varchar(50),
	[like] int default 0,
	[dislike] int default 0
)
GO