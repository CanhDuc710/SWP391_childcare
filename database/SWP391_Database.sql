USE master
GO

ALTER DATABASE SWP391_Database SET SINGLE_USER WITH ROLLBACK IMMEDIATE 

DROP DATABASE SWP391_Database
GO

-- Tạo database mới
CREATE DATABASE SWP391_Database;
GO

-- Sử dụng database mới
USE SWP391_Database;
GO




-- Tạo bảngStatus
CREATE TABLE Status (
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
    gender BIT NULL,
    avatar NVARCHAR(50) NULL,
    address NVARCHAR(100),
	role_id INT NULL,
	status_id INT NULL,
    FOREIGN KEY (status_id) REFERENCES Status(status_id),
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
    gender BIT NULL,
    avatar NVARCHAR(200) NULL,
	address NVARCHAR(100),
    role_id INT NULL,
    status_id INT NULL,
    FOREIGN KEY (role_id) REFERENCES Role(role_id),
    FOREIGN KEY (status_id) REFERENCES Status(status_id)
);

-- Tạo bảng Admin
CREATE TABLE Admin (
    admin_id INT PRIMARY KEY,
    username NVARCHAR(50) NULL,
    password NVARCHAR(50) NULL,
);


-- Tạo bảng Service Category
CREATE TABLE Service_category (
    category_id INT PRIMARY KEY,
    name VARCHAR(255) NULL,
	detail NVARCHAR(255) NULL
);

-- Tạo bảng Service
CREATE TABLE Service (
    service_id INT PRIMARY KEY,
	category_id INT NULL,
    image VARCHAR(255) NULL,
    name VARCHAR(255) NULL,
    detail TEXT NULL,
    price DECIMAL(10, 2) NULL,
    discount DECIMAL(5, 2) NULL,
	status_id INT NULL
    FOREIGN KEY (category_id) REFERENCES Service_category(category_id)
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
    short NVARCHAR(100) NULL,
    author_id INT NULL,
    updated_date DATETIME NULL,
    detail NVARCHAR(MAX) NULL,
    image NVARCHAR(200) NULL,
    post_category_id INT NULL,
    FOREIGN KEY (author_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (post_category_id) REFERENCES Post_category(post_category_id)
);



-- Tạo bảng Slot
CREATE TABLE Slot (
    slot_id INT PRIMARY KEY,
    start_time DATETIME NULL,
    end_time DATETIME NULL
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
CREATE TABLE EmailVerification (
    activation_id INT  IDENTITY(1,1) PRIMARY KEY,
	email NVARCHAR(30) Null,
    beginTime DATETIME Null,
    endTime DATETIME Null,
	type int NULL,
    status int Null
);

-- Thêm dữ liệu vào bảng Role
INSERT INTO [dbo].[Role] ([role_id], [role_name]) VALUES
(1, N'patient'),
(2, N'nurse'),
(3, N'doctor'),
(4, N'manager');
GO


-- Thêm dữ liệu vào bảng StaffStatus
INSERT INTO Status (status_id, status_name) VALUES 
(1, N'Inactive'),       -- Hoạt động
(2, N'Active'),     -- Không hoạt động
(3, N'Suspended');    -- Tạm ngưng hoạt động

-- Thêm dữ liệu vào bảng Staff (1 nurse, 1 doctor, 1 manager)
INSERT INTO Staff (staff_id, username, password, email, phone, name, gender, avatar, address, role_id, status_id) VALUES 
(1, N'nurse', N'123', N'nurse1@example.com', N'1111111111', N'Nurse 1', 0, N'default.jpg',N'address default', 2, 2), -- Nurse
(2, N'doctor', N'123', N'doctor1@example.com', N'2222222222', N'Doctor 1', 1, N'default.jpg',N'address default', 3, 2), -- Doctor
(3, N'manager', N'123', N'manager1@example.com', N'3333333333', N'Manager 1', 1, N'default.jpg',N'address default', 4, 2); -- Manager

-- Thêm dữ liệu vào bảng Patient với các trạng thái từ bảng PatientStatus
INSERT INTO Patient (patient_id, username, password, email, phone, name, gender, avatar, address,role_id, status_id) VALUES 
(1, N'p1', N'123', N'patient1@example.com', N'1111111111', N'Patient 1', 1,N'default.jpg',N'address default', 1, 1), -- inactive
(2, N'p2', N'123', N'patient2@example.com', N'2222222222', N'Patient 2', 0,N'default.jpg',N'address default', 1, 2), -- Active
(3, N'p3', N'123', N'patient3@example.com', N'3333333333', N'Patient 3', 1,N'default.jpg',N'address default', 1, 3), -- Suspended
(4, N'duchinh0306', N'123', N'duchinh0306@gmail.com', N'4444444444', N'Nguyen D D Chinh', 1,N'default.jpg',N'address default', 1, 1)

-- Chèn dữ liệu vào bảng category
INSERT INTO Service_category(category_id, name, detail)
VALUES 
(1, 'Health Consultation', N'Health Consultation Detail'), 
(2, 'Medical Examination', N'Health Consultation Detail'), 
(3, 'Vaccination', N'Health Consultation Detail');


-- Chèn dữ liệu vào bảng service
INSERT INTO service (service_id, category_id, image, name, detail, price, discount, status_id )
VALUES
-- Dịch vụ cho Health Consultation (category_id = 1)
(1, 1, 'health_consultation.jpg', 'Health Checkup', 'Regular health checkup and consultation.', 100.00, 0.00,1),
(2, 1, 'diet_advice.jpg', 'Diet Advice', 'Nutritional consultation and personalized diet planning.', 80.00, 0.00,0),
(3, 1, 'fitness_program.jpg', 'Fitness Program', 'Customized fitness program and exercise routines.', 120.00, 0.00,1),

-- Dịch vụ cho Medical Examination (category_id = 2)
(4, 2, 'medical_exam.jpg', 'General Medical Examination', 'Comprehensive medical examination for overall health assessment.', 150.00, 0.00,1),
(5, 2, 'blood_test.jpg', 'Blood Tests', 'Various blood tests to assess specific health parameters.', 60.00, 0.00,1),
(6, 2, 'x_ray.jpg', 'X-ray Services', 'X-ray imaging for diagnostic purposes.', 90.00, 0.00, 0),

-- Dịch vụ cho Vaccination (category_id = 3)
(7, 3, 'vaccine1.jpg', 'Flu Vaccination', 'Annual flu vaccination to prevent influenza.', 40.00, 0.00, 0),
(8, 3, 'vaccine2.jpg', 'Childhood Vaccination', 'Routine vaccinations for children as per vaccination schedule.', 55.00, 0.00, 1),
(9, 3, 'vaccine3.jpg', 'Travel Vaccination', 'Vaccinations required for travel to specific regions.', 70.00, 0.00, 1);

GO
ALTER DATABASE SWP391_Database SET MULTI_USER
GO