use master
GO
create database Ex_Sum
GO
use Ex_Sum
GO
create table Users(
	login nvarchar(20) not null,
	[sum] int not null
)
GO
