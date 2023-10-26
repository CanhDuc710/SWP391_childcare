USE master
GO

-- drop database
DROP DATABASE SWP391_Database;
GO

-- Tạo database mới
CREATE DATABASE SWP391_Database;
GO

-- Sử dụng database mới
USE SWP391_Database;


-- Tạo bảng Customer
CREATE TABLE Customer (
    customer_id INT PRIMARY KEY,
    username NVARCHAR(50) NULL,
    password NVARCHAR(50) NULL,
    email NVARCHAR(100) NULL,
    phone NVARCHAR(15) NULL,
    name NVARCHAR(50) NULL
);

-- Tạo bảng Staff
CREATE TABLE Staff (
    staff_id INT PRIMARY KEY,
    username NVARCHAR(50) NULL,
    password NVARCHAR(50) NULL,
    email NVARCHAR(100) NULL,
    phone NVARCHAR(15) NULL,
    name NVARCHAR(50) NULL
);

-- Tạo bảng Admin
CREATE TABLE Admin (
    admin_id INT PRIMARY KEY,
    username NVARCHAR(50) NULL,
    password NVARCHAR(50) NULL
);
-- Tạo bảng Role_type
CREATE TABLE Role_type (
    role_type INT PRIMARY KEY,
    role_type_name NVARCHAR(50) NULL
);

-- Tạo bảng Role
CREATE TABLE Role (
    role_id INT PRIMARY KEY,
    staff_id INT NULL,
    role_type INT NULL,
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (role_type) REFERENCES Role_type(role_type)
);

-- Tạo bảng Service_category
CREATE TABLE Service_category (
    service_category_id INT PRIMARY KEY,
    category NVARCHAR(50) NULL,
    detail NVARCHAR(MAX) NULL,
);

-- Tạo bảng Service
CREATE TABLE Service (
    service_id INT PRIMARY KEY,
    image NVARCHAR(200) NULL,
    service_category INT NULL,
    name NVARCHAR(100) NULL,
    detail NVARCHAR(MAX) NULL,
    price DECIMAL(10, 2) NULL,
    discount DECIMAL(5, 2) NULL,
    FOREIGN KEY (service_category) REFERENCES Service_category(service_category_id)
);



-- Tạo bảng Post_category
CREATE TABLE Post_category (
    post_category_id INT PRIMARY KEY,
    category NVARCHAR(50) NULL,
    detail NVARCHAR(MAX) NULL,
);
-- Tạo bảng Post
CREATE TABLE Post (
    post_id INT PRIMARY KEY,
    title NVARCHAR(200) NULL,
    author NVARCHAR(100) NULL,
    updated_date DATE NULL,
    post_category INT NULL,
    detail NVARCHAR(MAX) NULL,
    image NVARCHAR(200) NULL,
    FOREIGN KEY (post_category) REFERENCES Post_category(post_category_id)
);
-- Tạo bảng Slot
CREATE TABLE Slot (
    slot_id INT PRIMARY KEY,
    start_time TIME NULL,
    end_time TIME NULL
);

-- Tạo bảng Reservation
CREATE TABLE Reservation (
    reservation_id INT PRIMARY KEY,
    slot_id INT NULL,
    customer_id INT NULL,
    staff_id INT NULL,
    status NVARCHAR(50) NULL,
    date DATE NULL,
    total DECIMAL(10, 2) NULL,
    FOREIGN KEY (slot_id) REFERENCES Slot(slot_id),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id)
);

-- Tạo bảng Reservation_detail
CREATE TABLE Reservation_detail (
    reservation_detail_id INT PRIMARY KEY,
    reservation_id INT NULL,
    service_id INT NULL,
    quantity INT NULL,
    person_amount INT NULL,
    total DECIMAL(10, 2) NULL,
    FOREIGN KEY (reservation_id) REFERENCES Reservation(reservation_id),
    FOREIGN KEY (service_id) REFERENCES Service(service_id)
);

GO
-- Thêm dữ liệu vào bảng Admin
INSERT INTO [dbo].[Admin] ([admin_id], [username], [password]) VALUES (1, N'admin', N'admin');

-- Thêm dữ liệu vào bảng Customer
INSERT INTO [dbo].[Customer] ([customer_id], [username], [password], [name], [email], [phone]) VALUES 
(1, N'customer1', N'customer1', N'customer 1', N'customer1@example.com', N'0000000000'),
(2, N'customer2', N'customer2', N'customer 2', N'customer2@example.com', N'1111111111');
-- Thêm dữ liệu vào bảng Staff
INSERT INTO [dbo].[Staff] ([staff_id], [username], [password], [name], [email], [phone]) VALUES
(1, N'manager', N'manager', N'manager', N'manager@example.com', N'0000000000'),
(2, N'nurse1', N'nurse1', N'nurse 1', N'nurse1@example.com', N'1111111111'),
(3, N'nurse2', N'nurse2', N'nurse 2', N'nurse2@example.com', N'2222222222'),
(4, N'doctor1', N'doctor1', N'doctor 1', N'doctor1@example.com', N'3333333333'),
(5, N'doctor2', N'doctor2', N'doctor 2', N'doctor2@example.com', N'4444444444'),
(6, N'doctor3', N'doctor3', N'doctor 3', N'doctor3@example.com', N'5555555555');
-- Thêm dữ liệu vào bảng Role_type
INSERT INTO [dbo].[Role_type] ([role_type], [role_type_name]) VALUES
(1, N'nurse'),
(2, N'doctor'),
(3, N'manager');
-- Thêm dữ liệu vào bảng Role
INSERT INTO [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES
(1, 1, 3),
(2, 2, 1),
(3, 3, 1),
(4, 4, 2),
(5, 5, 2),
(6, 6, 2);




