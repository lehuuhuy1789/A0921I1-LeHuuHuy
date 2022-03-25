use HeThongQuanLyFurama;
-- 5.  Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, 
--     ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo 
--     công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng 
--     và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng 
--     đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hd, hop_dong.ngay_ket_thuc, 
 (dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia) as "tong_tien"
 from khach_hang 
 left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
 left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
 left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
 left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
 left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1
-- của năm 2021 (Quý 1 là tháng 1, 2, 3)

select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu from dich_vu 
 inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
 where not exists (select hop_dong.ma_hop_dong from hop_dong where (hop_dong.ngay_lam_hd between "2021-01-01" and "2021-03-31") and hop_dong.ma_dich_vu = dich_vu.ma_dich_vu);
 
 -- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
 -- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
 -- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
 
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu from dich_vu 
inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
where exists(select hop_dong.ma_hop_dong from hop_dong where year(hop_dong.ngay_lam_hd) ="2020" and hop_dong.ma_dich_vu = dich_vu.ma_dich_vu)     
and not exists(select hop_dong.ma_hop_dong from hop_dong where year(hop_dong.ngay_lam_hd) ="2021" and hop_dong.ma_dich_vu = dich_vu.ma_dich_vu);

-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, 
-- với yêu cầu ho_ten không trùng nhau.
-- Cách 1: dùng group by
select khach_hang.ho_ten from khach_hang group by(ho_ten); 
-- Cách 2: Từ khóa distinct trả về cột không trùng nhau
select distinct khach_hang.ho_ten from khach_hang;
-- Cách 3: Dùng union để trả về kết quả k trùng nhau
select khach_hang.ho_ten from khach_hang union select khach_hang.ho_ten from khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(hop_dong.ngay_lam_hd) as thang, count(month(hop_dong.ngay_lam_hd)) as so_khach_hang from hop_dong where year(hop_dong.ngay_lam_hd) ="2021"
group by thang order by thang ;

-- Câu 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hd, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, sum(hop_dong_chi_tiet.so_luong) as "so_luong_dich_vu_di_kem"
from hop_dong
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong group by hop_dong.ma_hop_dong;

-- Câu 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có 
		 -- ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
         
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem
from dich_vu_di_kem 
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
inner join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
inner join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach where loai_khach.ten_loai_khach = "Diamond"
and khach_hang.dia_chi like "%Vinh%" or khach_hang.dia_chi like "%Quảng Ngãi%";

-- Câu 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), 
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc 
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

select hop_dong.ma_hop_dong, nhan_vien.ho_ten as ho_ten_nhan_vien, khach_hang.ho_ten as ho_ten_khach_hang, khach_hang.so_dien_thoai, dich_vu.ten_dich_vu, sum(hop_dong_chi_tiet.so_luong) as "so_luong_dich_vu_di_kem", hop_dong.tien_dat_coc
from hop_dong
inner join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
inner join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong 
where not exists(select hop_dong.ma_hop_dong from hop_dong where (hop_dong.ngay_lam_hd between "2021-01-01" and "2021-06-31") and hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong)
and exists (select hop_dong.ma_hop_dong from hop_dong where (hop_dong.ngay_lam_hd between "2020-10-01" and "2020-12-31") and hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong)
group by hop_dong.ma_hop_dong;