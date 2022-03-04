use HeThongQuanLyFurama;
-- Câu 3.	Hiển thị thông tin của tất cả khách hàng 
--          có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang 
where (dia_chi like "%Đà Nẵng%" or dia_chi like "%Quảng Trị%") and ( datediff(curdate(),ngay_sinh) > 18*365 and datediff(curdate(),ngay_sinh) < 50*365);