CREATE DATABASE watchShop
USE watchShop

-- bảng phân quyền
Create table Role(
	id INT PRIMARY KEY,
	name varchar(20)
)
Insert into role values
(1,'User'),
(2,'Admin')

-- Bảng người dùng
CREATE TABLE [User] (
	username NVARCHAR(50) PRIMARY KEY,
	password varchar(20),
	role_id INT FOREIGN KEY REFERENCES Role(id),
	remember_token VARCHAR(300)
)
-- Tạo bảng UserInfo
CREATE TABLE UserInfo(
	username NVARCHAR(50) PRIMARY KEY,
	avatar Varchar(100),
	email VARCHAR(30),
	phone VARCHAR(11),
	regis_admin VARCHAR(8) CONSTRAINT regis_ad CHECK(regis_admin IN ('true','false'))
)
-- Bảng admin
CREATE TABLE [Admin] (
	username NVARCHAR(50) PRIMARY KEY,
	password varchar(20),
	role_id INT FOREIGN KEY REFERENCES Role(id),
	remember_token VARCHAR(300)
)

-- Bảng dây đồng hồ
CREATE TABLE StrapMaterials (
    strap_id INT PRIMARY KEY IDENTITY(1,1),
    strap_name NVARCHAR(50) NOT NULL -- Ví dụ: 'Leather', 'Stainless Steel', 'Rubber'
);
INSERT INTO StrapMaterials (strap_name) VALUES 
(N'Leather-dây da'),         -- Dây da
(N'Stainless steel-thép không gỉ'), -- Thép không gỉ
(N'Rubber-cao su-silicon'),          -- Cao su/Silicon (thường cho G-Shock, Smartwatch)
(N'Titanium-titan'),        -- Titan (siêu nhẹ)
(N'Nato/Fabric-dây vải'),     -- Dây vải
(N'Ceramic-dây gốm');         -- Dây gốm
-- Bảng thương hiệu 
CREATE TABLE Brands (
    brand_id INT PRIMARY KEY IDENTITY(1,1),
    brand_name NVARCHAR(50) NOT NULL,
	images VARCHAR(20)
);
-- Chèn dữ liệu vào bảng Brands
INSERT INTO Brands (brand_name, images) 
VALUES 
    (N'Rolex', 'rolex.jpg'),
    (N'Royal London', 'royal.jpg'),
    (N'Seiko', 'seiko.jpg'),
    (N'Titan', 'titan.jpg'),
    (N'Rado', 'rado.jpg'),
    (N'Apple', 'apple.jpg'),
    (N'Omega', 'omega.jpg'),
    (N'Breitling', 'brei.jpg'),
	(N'Samsung', 'samsung.jpg');
-- Bảng máy đồng hồ
CREATE TABLE MovementTypes (
    movement_id INT PRIMARY KEY IDENTITY(1,1),
    movement_name NVARCHAR(50) NOT NULL
);
INSERT INTO MovementTypes (movement_name) VALUES 
(N'Quartz-máy pin'),         -- Máy Pin
(N'Automatic-cơ tự động'),      -- Máy Cơ tự động
(N'Hand-winding-cơ lên cót tay'),   -- Máy Cơ lên cót tay
(N'Solar-năng lượng ánh sáng'),          -- Năng lượng ánh sáng
(N'Smart Movement-smartwatch'); -- Dùng cho smartwatch
-- Bảng đồng hồ
CREATE TABLE Watches (
    watch_id INT PRIMARY KEY IDENTITY(1,1),
    product_name NVARCHAR(100) NOT NULL,
    price DECIMAL(18, 0),
    
    -- 3 CỘT KHÓA NGOẠI (Chỉ lưu ID, không lưu chữ)
    brand_id INT,       -- Liên kết tới bảng Brands
    movement_id INT,    -- Liên kết tới bảng MovementTypes
    strap_id INT,       -- Liên kết tới bảng StrapMaterials (Mới)

    image_url VARCHAR(255),
    description NVARCHAR(MAX),
	quantity INT,
	new_product DATE,
	gender VARCHAR(8) CONSTRAINT gen_der CHECK(gender IN ('male','female','couple')),

    -- THIẾT LẬP RÀNG BUỘC (Mối quan hệ)
    CONSTRAINT FK_Watch_Brand FOREIGN KEY (brand_id) 
        REFERENCES Brands(brand_id),

    CONSTRAINT FK_Watch_Movement FOREIGN KEY (movement_id) 
        REFERENCES MovementTypes(movement_id),

    CONSTRAINT FK_Watch_Strap FOREIGN KEY (strap_id) 
        REFERENCES StrapMaterials(strap_id)
);
INSERT INTO Watches (
    product_name, price, brand_id, movement_id, strap_id, 
    image_url, description, quantity, new_product, gender
) 
VALUES 
    -- --- APPLE WATCH (Brand 6, Move 3) ---
    (N'Apple Watch Series 9 Pink', 10500000, 6, 3, 3, 'apple_1.jpg', N'Viền nhôm hồng, dây cao su thể thao, màn hình Retina.', 50, '2024-01-15', 'female'),
    (N'Apple Watch Ultra 2 Orange', 21990000, 6, 3, 4, 'apple_2.jpg', N'Vỏ titan bền bỉ, dây Alpine Loop cam, GPS tần số kép.', 20, '2024-02-10', 'male'),
    (N'Apple Watch Series 9 Black', 11000000, 6, 3, 4, 'apple_3.jpg', N'Màu đen Midnight, dây vải Sport Loop siêu nhẹ.', 45, NULL, 'male'),
    (N'Apple Watch Series 9 Starlight', 10500000, 6, 3, 4, 'apple_4.jpg', N'Màu ánh sao sang trọng, dây vải dệt tinh tế.', 30, NULL, 'female'),
    (N'Apple Watch SE Pink Sport', 7500000, 6, 3, 3, 'apple_5.jpg', N'Phiên bản SE giá rẻ, dây cao su hồng trẻ trung.', 60, NULL, 'female'),
    (N'Apple Watch Ultra 2 White', 21990000, 6, 3, 4, 'apple_6.jpg', N'Phiên bản Ultra dây Ocean Band trắng, chuyên cho lặn biển.', 15, '2024-03-01', 'male'),

    -- --- ROLEX (Brand 1, Move 1) ---
    (N'Rolex Datejust 36 Two-Tone', 350000000, 1, 1, 1, 'rolex_1.jpg', N'Vàng 18k kết hợp thép Oystersteel, mặt số xanh thẫm.', 5, '2023-12-20', 'male'),
    (N'Rolex GMT-Master II Gold', 950000000, 1, 1, 1, 'rolex_2.jpg', N'Vàng nguyên khối, mặt số xanh lá cây biểu tượng.', 2, '2023-11-15', 'male'),
    (N'Rolex Yacht-Master II', 680000000, 1, 1, 1, 'rolex_3.jpg', N'Chức năng đếm ngược chuyên dụng cho đua thuyền.', 3, NULL, 'male'),
    (N'Rolex Lady-Datejust Gold', 280000000, 1, 1, 1, 'rolex_4.jpg', N'Kích thước nhỏ 28mm, toàn thân vàng 18k sang trọng.', 8, NULL, 'female'),
    (N'Rolex Datejust 31 Silver', 190000000, 1, 1, 1, 'rolex_5.jpg', N'Thép Oystersteel, mặt số bạc thanh lịch cho nữ.', 10, '2024-01-05', 'female'),
    (N'Rolex Daytona White Gold', 850000000, 1, 1, 1, 'rolex_6.jpg', N'Biểu tượng của tốc độ, vàng trắng 18k.', 2, NULL, 'male'),

    -- --- OMEGA (Brand 7, Move 1) ---
    (N'Omega Seamaster Aqua Terra', 150000000, 7, 1, 1, 'omega_1.jpg', N'Mặt số xám vân gỗ, đạt chuẩn Master Chronometer.', 12, NULL, 'male'),
    (N'Omega Speedmaster Moonwatch', 220000000, 7, 1, 2, 'omega_2.jpg', N'Phiên bản vàng Moonshine Gold, dây da xanh rêu.', 5, '2024-02-20', 'male'),
    (N'Omega Seamaster Diver 300M', 135000000, 7, 1, 1, 'omega_3.jpg', N'Đồng hồ lặn huyền thoại, mặt số gợn sóng xanh.', 15, NULL, 'male'),

    -- --- SAMSUNG (Brand 9, Move 3) ---
    (N'Samsung Galaxy Watch 6 Classic', 8500000, 9, 3, 3, 'samsung_1.jpg', N'Vòng bezel vật lý xoay, theo dõi sức khỏe toàn diện.', 100, '2024-01-10', 'male'),
    (N'Samsung Galaxy Watch 6 Blue', 6500000, 9, 3, 3, 'samsung_2.jpg', N'Thiết kế Sapphire, màu xanh năng động.', 80, NULL, 'male'),
    (N'Samsung Galaxy Watch 5 Pro', 9500000, 9, 3, 3, 'samsung_3.jpg', N'Pin trâu nhất dòng Galaxy, thiết kế thể thao.', 40, NULL, 'male'),
    (N'Samsung Galaxy Watch 6 Lavender', 6500000, 9, 3, 3, 'samsung_4.jpg', N'Màu tím Lavender nhẹ nhàng dành cho nữ.', 70, '2024-02-14', 'female'),

    -- --- ROYAL LONDON (Brand 2, Move 2 - Quartz) ---
    (N'Royal London Rose Gold Lady', 3500000, 2, 2, 1, 'royal_4.jpg', N'Mạ vàng hồng, đính đá viền bezel.', 25, NULL, 'female'),
    (N'Royal London Silver Classic', 3200000, 2, 2, 1, 'royal_5.jpg', N'Mặt số trắng đơn giản, lịch ngày góc 3 giờ.', 30, NULL, 'male');






	select * from Watches w 
	JOIN StrapMaterials s ON s.strap_id = w.strap_id
	JOIN MovementTypes m ON m.movement_id = w.movement_id
	WHERE 1=1 