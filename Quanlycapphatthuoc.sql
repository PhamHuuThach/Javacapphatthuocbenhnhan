

CREATE TABLE BENHNHAN(
MABENHNHAN VARCHAR(50) PRIMARY KEY,
TENBENHNHAN NVARCHAR(50),
DIACHI NVARCHAR(50),
TUOI INT,
GIOITINH NVARCHAR(50),
NGHENGHIEP NVARCHAR(50),
NOILAMVIEC NVARCHAR(50),
NGUOIGIAMHO NVARCHAR(50),
DANTOC NVARCHAR(50),
SODIENTHOAI VARCHAR(10),
)
CREATE TABLE DONTHUOC(
MADONTHUOC VARCHAR(50),
BACSIKEDON NVARCHAR(50),
KHOA NVARCHAR(50),
TENBENHNHAN NVARCHAR(50),
TUOIBENHNHAN INT,
GIOITINH NVARCHAR(50),
CANNANG INT,
CMND NVARCHAR(50),
BHYT NVARCHAR(50),
DIACHI NVARCHAR(50),
NGUOIGIAMHO NVARCHAR(50),
CHUANDOANBENH NVARCHAR(50),
NGAYLAPDON DATE,
DONGDAU NVARCHAR(50),
)
CREATE TABLE THUOC(
MATHUOC VARCHAR(50),
TENTHUOC NVARCHAR(50),
TENBENHNHAN NVARCHAR(50),
SOLUONG INT,
DONGIA INT,
TONGTIEN INT,
DVT NVARCHAR(50),
LIEUDUNG NVARCHAR(50),
LOIKHUYEN NVARCHAR(50),
)
CREATE TABLE BACSI(
MABACSI VARCHAR(50),
TENBACSI NVARCHAR(50),
GIOITINH NVARCHAR(50),
CHUYENKHOA NVARCHAR(50),
TRINHDO NVARCHAR(50),
NOICONGTAC NVARCHAR(50),
DIACHI NVARCHAR(50),
SODIENTHOAI VARCHAR(10),
EMAIL NVARCHAR(50),
)
INSERT INTO BENHNHAN VALUES ( N'BN01',N'Phạm Hữu Thạch',N'Quảng Trị',19,N'Nam',N'Lập trình viên',N'Đà Nẵng',N'Ngô Hùng Sở',N'Kinh',0975662638)
,('BN02', N'Phạm Hữu Dụng', N'Phú Yên', 19, N'Nam', N'Lập trình viên', N'Đà Nẵng', N'Phạm Hữu Nghị', N'Kinh', 0975664637),
('BN03', N'Nguyễn Hoàng Việt', N'Phú Yên', 19, N'Nam', N'Lập trình viên', N'Đà Nẵng', N'Nguyễn Thị Hoàng Kim', N'Kinh', 0975664637),
('BN04', N'Nguyễn Hoàng Quang', N'Quảng Bình', 29, N'Nam', N'Phục vụ', N'Huế', N'Nguyễn Hoàng Vinh', N'Kinh', 0976575797),
('BN05',N'Lê Việt Anh',N'Ninh Bình', 23, N'Nam', N'Cắt tóc', N'Huế', N'Lê Việt Nam', N'Kinh', 0343573863),
('BN06', N'Ngô Hùng Mạnh', N'Phú Yên', 19, N'Nam', N'Lập trình viên', N'Đà Nẵng', N'Ngô Hùng Dũng', N'Kinh', 0778362842);
INSERT INTO DONTHUOC
VALUES ('DT01',N'Nguyễn Tráng Sĩ',N'Dinh dưỡng',N'Phạm Hữu Thạch',19,N'Nam',72,'395879286949','DN4018795839482',N'Quảng Trị',N'Ngô Hùng Sở',N'Béo phì','2022-01-21',N'Đã kí'),
('DT02',N'Lê Bình Minh',N'Tai mũi họng',N'Phạm Hữu Dụng',19,N'Nam',64,'964368024684','DN3684738485269',N'Phú Yên',N'Phạm Hữu Nghị',N'Ho gà','2022-01-23',N'Đã kí'),
('DT03',N'Nguyễn Tráng Sĩ',N'Dinh dưỡng',N'Nguyễn Hoàng Việt',19,N'Nam',45,'683784795257','DN4017694780435',N'Phú Yên',N'Nguyễn Thị Hoàng Kim',N'Thiếu Canxi','2022-01-26',N'Đã kí'),
('DT04',N'Lê Thống Lĩnh',N'Quản lý nhiễm khuẩn',N'Nguyễn Hoàng Quang',29,N'Nam',65,'478953689635','DN3685796425785',N'Quảng Bình',N'Nguyễn Hoàng Vinh',N'Nhiễm Trùng','2022-02-02',N'Đã kí'),
('DT05',N'Đào Hảo Hán',N'Khoa Ngoại',N'Lê Việt Anh',23,N'Nam',69,'578978563674','DN6584789468325',N'Ninh Bình',N'Lê Việt Nam',N'Cảm','2022-02-04',N'Chưa kí'),
('DT06',N'Vũ Phong',N'Khoa Truyền nhiễm',N'Ngô Hùng Mạnh',19,N'Nam',58,'657897974678','DN6786746356786',N'Phú Yên',N'Ngô Hùng Dũng',N'Cúm','2022-02-10',N'Đã kí')
INSERT INTO THUOC
VALUES ('T01',N'Giảm cân',N'Phạm Hữu Thạch',10,15000,150000,N'Viên',N'1 viên/1 ngày',N'Nên uống trước khi ăn'),
('T02',N'Adora',N'Phạm Hữu Dụng',15,4000,60000,N'Gói',N'1 gói/1 bữa',N'Nên uống sau khi ăn'),
('T03',N'Tăng cân',N'Nguyễn Hoàng Việt',10,10000,100000,N'Viên',N'1 viên/1 ngày',N'Nên uống trước khi ăn'),
('T04',N'Birio',N'Nguyễn Hoàng Quang',10,50000,500000,N'Viên',N'4 viên/1 ngày',N'Nên uống vào mỗi bữa ăn'),
('T05',N'Aboxilin',N'Lê Việt Anh',20,5000,100000,N'Viên',N'3 viên/1 ngày',N'Nên uống trước khi ăn vào bữa sáng,trưa,tối'),
('T06',N'Riboly',N'Ngô Hùng Mạnh',15,30000,450000,N'Viên',N'3 viên/1 ngày',N'Nên uống sau khi ăn')
INSERT INTO BACSI
VALUES ('BS01',N'Nguyễn Tráng Sĩ',N'Nam',N'Dinh Dưỡng',N'Thạc sĩ',N'Đà Nẵng',N'Huế',0786474723,'trangsi@gmail.com'),
('BS02',N'Lê Bình Minh',N'Nam',N'Tai mũi họng',N'Thạc sĩ',N'Đà Nẵng',N'Quảng Trị',0734578075,'binhminh@gmail.com'),
('BS03',N'Lê Thống Lĩnh',N'Nam',N'Quản lý nhiễm khuẩn',N'Thạc sĩ',N'Đà Nẵng',N'Quảng Ngãi',0986357853,'thonglinh@gmail.com'),
('BS04',N'Đào Hảo Hán',N'Nam',N'Khoa Ngoại',N'Thạc sĩ',N'Đà Nẵng',N'Quảng Bình',0367890975,'haohan@gmail.com'),
('BS05',N'Vũ Phong',N'Nam',N'Truyền nhiễm',N'Thạc sĩ',N'Đà Nẵng',N'Quảng Ngãi',0945674678,'vuphong@gmail.com')

SELECT COUNT (MADONTHUOC)FROM DONTHUOC 
WHERE NGAYLAPDON = '2022-1-21' 
CREATE PROC SLDT1NGAY ( @NGAY DATE)


