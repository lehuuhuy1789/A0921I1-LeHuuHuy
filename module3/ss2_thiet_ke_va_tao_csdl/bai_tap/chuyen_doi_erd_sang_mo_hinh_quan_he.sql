create database DonDatHang;
use DonDatHang;
create table SDT(
MaSDT int primary key auto_increment not null,
TenNCC varchar (50)
);

create table NhaCC(
MaNCC int primary key auto_increment not null,
TenNCC varchar (50),
DiaChi varchar(50),
MaSDT int,
foreign key (MaSDT) references SDT(MaSDT)
);

