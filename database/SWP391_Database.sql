USE master
GO

DROP DATABASE SWP391_Database
GO

-- Tạo database mới
CREATE DATABASE SWP391_Database;
GO

-- Sử dụng database mới
USE SWP391_Database;
GO


-- Tạo bảng PatientStatus
CREATE TABLE PatientStatus (
    status_id INT PRIMARY KEY,
    status_name NVARCHAR(50) NULL
);

-- Tạo bảng StaffStatus
CREATE TABLE StaffStatus (
    status_id INT PRIMARY KEY,
    status_name NVARCHAR(50) NULL
);

-- Tạo bảng ReservationStatus
CREATE TABLE ReservationStatus (
    status_id INT PRIMARY KEY,
    status_name NVARCHAR(50) NULL
);

-- Tạo bảng Role
CREATE TABLE Role (
    role_id INT PRIMARY KEY,
    role_name NVARCHAR(50) NULL
);

-- Tạo bảng Patient
CREATE TABLE Patient (
    patient_id INT PRIMARY KEY,
    username NVARCHAR(50) NULL,
    password NVARCHAR(50) NULL,
    email NVARCHAR(100) NULL,
    phone NVARCHAR(15) NULL,
    name NVARCHAR(50) NULL,
    gender NVARCHAR(10) NULL,
    avatar NVARCHAR(200) NULL,
	role_id INT NULL,
	status_id INT NULL,
    FOREIGN KEY (status_id) REFERENCES PatientStatus(status_id),
	FOREIGN KEY (role_id) REFERENCES Role(role_id)
);

-- Tạo bảng Staff
CREATE TABLE Staff (
    staff_id INT PRIMARY KEY,
    username NVARCHAR(50) NULL,
    password NVARCHAR(50) NULL,
    email NVARCHAR(100) NULL,
    phone NVARCHAR(15) NULL,
    name NVARCHAR(50) NULL,
    gender NVARCHAR(10) NULL,
    avatar NVARCHAR(200) NULL,
    role_id INT NULL,
    status_id INT NULL,
    FOREIGN KEY (role_id) REFERENCES Role(role_id),
    FOREIGN KEY (status_id) REFERENCES StaffStatus(status_id)
);

-- Tạo bảng Admin
CREATE TABLE Admin (
    admin_id INT PRIMARY KEY,
    username NVARCHAR(50) NULL,
    password NVARCHAR(50) NULL,
);





-- Tạo bảng Service
CREATE TABLE Service (
    service_id INT PRIMARY KEY,
    image NVARCHAR(200) NULL,
    name NVARCHAR(100) NULL,
    detail NVARCHAR(MAX) NULL,
    price DECIMAL(10, 2) NULL,
    discount DECIMAL(5, 2) NULL
);

-- Tạo bảng Post_category
CREATE TABLE Post_category (
    post_category_id INT PRIMARY KEY,
    category NVARCHAR(50) NULL,
    detail NVARCHAR(MAX) NULL
);

-- Tạo bảng Post
CREATE TABLE Post (
    post_id INT PRIMARY KEY,
    title NVARCHAR(200) NULL,
    author NVARCHAR(100) NULL,
    updated_date DATE NULL,
    detail NVARCHAR(MAX) NULL,
    image NVARCHAR(200) NULL,
    post_category_id INT NULL,
    FOREIGN KEY (post_category_id) REFERENCES Post_category(post_category_id)
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
    patient_id INT NULL,
    staff_id INT NULL,
    status_id INT NULL,
    date DATE NULL,
    total DECIMAL(10, 2) NULL,
    FOREIGN KEY (slot_id) REFERENCES Slot(slot_id),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (status_id) REFERENCES ReservationStatus(status_id)
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

-- Tạo bảng activation
CREATE TABLE Activation (
    activation_id INT PRIMARY KEY,
    [begin] DATE Null,
    [end] DATE Null,
    status int Null
);

-- Thêm dữ liệu vào bảng Role
INSERT INTO [dbo].[Role] ([role_id], [role_name]) VALUES
(1, N'patient'),
(2, N'nurse'),
(3, N'doctor'),
(4, N'manager');
GO

-- Thêm dữ liệu vào bảng PatientStatus
INSERT INTO PatientStatus (status_id, status_name) VALUES 
(1, N'Not Confirmed'),   -- Chưa Confirm
(2, N'Confirmed'),        -- Đã Confirm
(3, N'Suspended');        -- Tạm Ngừng
GO

-- Thêm dữ liệu vào bảng StaffStatus
INSERT INTO StaffStatus (status_id, status_name) VALUES 
(1, N'Active'),       -- Hoạt động
(2, N'Inactive'),     -- Không hoạt động
(3, N'Suspended');    -- Tạm ngưng hoạt động

-- Thêm dữ liệu vào bảng Staff (1 nurse, 1 doctor, 1 manager)
INSERT INTO Staff (staff_id, username, password, email, phone, name, gender, avatar, role_id, status_id) VALUES 
(1, N'nurse', N'123', N'nurse1@example.com', N'1111111111', N'Nurse 1', N'Female', N'default.jpg', 2, 1), -- Nurse
(2, N'doctor', N'123', N'doctor1@example.com', N'2222222222', N'Doctor 1', N'Male', N'default.jpg', 3, 1), -- Doctor
(3, N'manager', N'123', N'manager1@example.com', N'3333333333', N'Manager 1', N'Male', N'default.jpg', 4, 1); -- Manager

-- Thêm dữ liệu vào bảng Patient với các trạng thái từ bảng PatientStatus
INSERT INTO Patient (patient_id, username, password, email, phone, name, gender, avatar,role_id, status_id) VALUES 
(1, N'p1', N'123', N'patient1@example.com', N'1111111111', N'Patient 1', N'Male',N'default.jpg',1, 1), -- Active
(2, N'p2', N'123', N'patient2@example.com', N'2222222222', N'Patient 2', N'Female',N'default.jpg',1, 2), -- Inactive
(3, N'p3', N'123', N'patient3@example.com', N'3333333333', N'Patient 3', N'Male',N'default.jpg',1, 3); -- Suspended


