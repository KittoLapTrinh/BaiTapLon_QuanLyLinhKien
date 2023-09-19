CREATE DATABASE	QLLK
ON PRIMARY 
(
	NAME = 'QLCHLK_DATA',
	FILENAME='D:\Nhom01_QuanLyCuaHangMuaBanLinhKien\QLLK\QLCHLK_DATA2.MDF',
	SIZE = 10,
	MAXSIZE = 100,
	FILEGROWTH = 1
)
LOG ON
(
	NAME = 'QLCLK_LOG',
	FILENAME='D:\Nhom01_QuanLyCuaHangMuaBanLinhKien\QLLK\QLCHLK_LOG2.LDF',
	SIZE = 10,
	MAXSIZE = 100,
	FILEGROWTH = 1
)
USE QLLK
GO
SELECT SERVERPROPERTY('IsFullTextInstalled')
GO
/*Tạo Mã Khách Hàng Tự Động*/
CREATE FUNCTION AUTO_IDKH()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(MAKH) FROM KHACHHANG) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MAKH, 3)) FROM KHACHHANG
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'KH00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'KH0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/*Bảng Khách Hàng*/
CREATE TABLE KhachHang
(
	MAKH CHAR(5) PRIMARY KEY CONSTRAINT IDKH DEFAULT DBO.AUTO_IDKH(),
	HOTENKH NVARCHAR(30) NOT NULL,
	SODIENTHOAIKH CHAR(12),
	DIACHIKH NVARCHAR(100),
)
GO
CREATE PROC select_KH
as
	SELECT * FROM [dbo].[KhachHang]
GO
/*Tạo Mã Nhân Viên Tự Động*/
CREATE FUNCTION AUTO_IDNV()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(MANV) FROM NHANVIEN) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MANV, 3)) FROM NHANVIEN
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'NV00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'NV0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/*Bảng Nhân Viên*/
CREATE TABLE NhanVien
(
	MANV CHAR(5) PRIMARY KEY CONSTRAINT IDNV DEFAULT DBO.AUTO_IDNV(),
	HOTENNV NVARCHAR(30) NOT NULL,
	GIOITINHNV NVARCHAR(5) NOT NULL,
	NGAYSINHNV DATE,
	EMAIL CHAR(30),
	DIACHINV NVARCHAR(100),
	SODIENTHOAINV CHAR(12),
	MATKHAU CHAR(10),
	QUYENTRUYCAP CHAR(10)

)
GO
/*Tạo Mã Linh Kiện Tự Động*/
CREATE FUNCTION AUTO_IDLK()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(MALK) FROM LINHKIEN) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MALK, 3)) FROM LINHKIEN
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'LK00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'LK0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/*Bảng Linh Kiện*/
CREATE TABLE LinhKien
(
	MALK CHAR(5) PRIMARY KEY CONSTRAINT IDLK DEFAULT DBO.AUTO_IDLK(),
	TENLK NVARCHAR(100) NOT NULL,
	MOTALK NVARCHAR(300),
	DONGIA FLOAT,
	LOAILK NVARCHAR(20),
	THUONGHIEU NVARCHAR(20),
	SOLUONGTON INT,
	NGAYNHAP DATE,
	BAOHANH NVARCHAR(10) NOT NULL,
)
GO
/*Tao ma Hoa Don tu Dong*/
CREATE FUNCTION AUTO_IDHD()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID VARCHAR(7)
	IF (SELECT COUNT(MAHD) FROM HOADON) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MAHD, 3)) FROM HOADON
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'HD00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'HD0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/*Bang Hoa Don*/
CREATE TABLE HoaDon
(
	MaHD CHAR(7) PRIMARY KEY CONSTRAINT IDHD DEFAULT DBO.AUTO_IDHD(),
	MANV CHAR(5) NOT NULL,
	MAKH CHAR(5) NOT NULL,
	NGAYLAPHD DATE,
	CONSTRAINT fk_MaKH
	FOREIGN KEY(MAKH)
	REFERENCES KHACHHANG(MAKH)
	ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT fk_MaNV
	FOREIGN KEY(MANV)
	REFERENCES NHANVIEN(MANV)
	ON DELETE CASCADE ON UPDATE CASCADE,
)
GO
/*CT_Hoa Don*/
CREATE TABLE CT_HoaDon
(
	MAHD CHAR(7) NOT NULL,
	MALK CHAR(5) NOT NULL,
	SOLUONG INT,
	CONSTRAINT pk_HD
	PRIMARY KEY(MAHD,MALK),
	CONSTRAINT fk_MaHD
	FOREIGN KEY(MAHD)
	REFERENCES HOADON(MAHD)
	ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT fk_MALK
	FOREIGN KEY(MALK)
	REFERENCES LINHKIEN(MALK)
	ON DELETE CASCADE ON UPDATE CASCADE,
)

--INSERT dữ liệu Linh kiện
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'Mainboard Asus TUF Gaming B660M-Plus D4', N'Bo mạch chủ Intel® B660 (LGA 1700) kích cỡ mATX, 10+1 tụ cấp nguồn DrMOS, hỗ trợ PCIe 5.0, DDR4 5333 (ép xung), hai khe PCIe 4.0 M.2 đi kèm bộ tản nhiệt rời, Ethernet Realtek 2.5Gb, USB 3.2 Gen 2x2 Type-C® phía sau, USB 3.2 Gen 1 Type-C® trên bo, Aura Sync, Khử ồn thông minh AI hai chiều', 3999000, 'Intel', 'Asus', 11, '2023-01-01', 24)
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'Mainboard Asus TUF GAMING X570-PLUS', N'Bo mạch chủ chuyên game AMD AM4 X570 ATX với PCIe 4.0, M.2 kép, Wi-Fi, 14 pha điện Dr. MOS, HDMI, DP, SATA 6Gb/s, USB 3.2 Gen 2 và đèn Aura Sync RGB', 4390000, 'Intel', 'Asus', 5, '2023-01-01', 24)
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'Mainboard MSI MAG B560M MORTAR WIFI', N'Bo mạch chủ MSI MAG B560M Mortar WiFi sở hữu nhiều công nghệ hàng đầu, cho phép người dùng dễ dàng build PC hiệu năng mạnh mẽ với CPU Intel thế hệ thứ 10 hoặc 11', 3110000, 'AMD', 'MSI', 19, '2023-01-01', 12)
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'CPU Intel Core i3-10100F', N'CPU Intel Core i3-10100F / 6MB / 4.3GHZ / 4 nhân 8 luồng, chiếc CPU 10th Gen mới nhất từ đội xanh Intel. ', 1990000, 'CPU', 'SamSum', 50, '2023-02-01', 12)
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'CPU Intel Core i5-11400', N'Bộ vi xử lý/ CPU Intel Core i5-11400 (6 Cores 12 Threads up to 4.4Ghz 11th Gen LGA 1200) là thế hệ CPU tiếp theo có những cải tiến về hiệu năng, giúp nâng cấp cấu hình hệ thống để bạn có những trải nghiệm tuyệt vời hơn khi sử dụng các phần mềm, trò chơi đòi hỏi cấu hình cao.', 4099000, 'CPU', 'SamSum', 25, '2023-02-01', 24)
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'CPU Intel Core i5 12400 ', N'Tốc độ vượt trội với 6 nhân, 12 luồng, là chip thuộc dòng Alder Lake, CPU Intel Core i5-12400 được trang bị Golden Cove (P-cores) cực kỳ mạnh mẽ.', 5399000, 'CPU', 'SamSum', 13, '2023-02-01', 24)
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'RAM ADATA XPG Spectrix D41 RGB 8 GB-DDR4-3200 MHz', N'Điểm nổi bật dễ thấy nhất ở Adata XPG Spectrix D41 chính là sự xuất hiện của hệ thống đèn LED RGB tuyệt đẹp trên phần mặt trên của kẹp tản nhiệt.', 799000, 'RAM', 'IPhone', 37, '2022-10-10', 12)
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'RAM Kingston Fury 16 GB-DDR4-2666 MHz', N'Điểm nổi bật dễ thấy nhất ở Adata XPG Spectrix D41 chính là sự xuất hiện của hệ thống đèn LED RGB tuyệt đẹp trên phần mặt trên của kẹp tản nhiệt.', 799000, 'RAM', 'IPhone', 37, '2022-10-10', 12)
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'Màn hình Dell UltraSharp U2422H /23.8 inch/ FHD', N'Màn hình Dell UltraSharp U2422H thể hiện sự chuyên nghiệp ngay từ thiết kế bên ngoài khi được Dell đầu tư rất nhiều vào cấu trúc thân vỏ.', 6290000, 'Màn hình', 'Dell', 7, '2023-01-15', 36)
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'Màn hình ViewSonic VA2209-H/22 inch/FHD', N'ViewSonic VA2209-H là lựa chọn hàng đầu cho những ai đang cần một mẫu màn hình có thiết kế tối giản, lịch thiệp để phục vụ trải nghiệm giải trí, làm việc và học tập của mình.', 2390000, 'Màn hình', 'ViewSonic ', 10, '2023-01-15', 24)
INSERT INTO LinhKien
VALUES(dbo.AUTO_IDLK(), N'Chuột Gaming Logitech G402 Hyperion Fury Ultra', N'Logitech G402 Hyperion Fury Ultra thực sự là một trợ thủ đắc lực dành cho các game thủ khi khoác lên mình thiết kế cắt xẻ tràn đầy cảm hứng', 1290000, 'Chuột', 'Logitech ', 28, '2023-01-26', 12)
--
select * from LinhKien
-------------
insert into NhanVien
values (dbo.AUTO_IDNV(), N'Trần Tuấn Kiệt', N'Nam', '2003-09-30', 'trantuankiet5980@gmail.com', N'IUH', '0384976471', 'kiet', 'Admin')
insert into NhanVien
values (dbo.AUTO_IDNV(), N'Ngô Văn Toàn', N'Nam', '2003-01-01', 'ngovantoaniuh@gmail.com', N'IUH', '0123456789', 'toan', 'User')
select * from NhanVien

--tìm kiếm mã nhân viên(tên đăng nhập)
select * from NhanVien where MANV = 'NV001' and MATKHAU = 'kiet'

--
insert into KhachHang
values (dbo.AUTO_IDKH(), N'Nguyễn Văn A', '0123987465', N'12 Nguyễn Văn Bảo, P4, Gò Vấp')
insert into KhachHang
values (dbo.AUTO_IDKH(), N'Trần Ngọc An', '0333999126', N'113 Nguyễn Văn Nghi, P4, Gò Vấp')

