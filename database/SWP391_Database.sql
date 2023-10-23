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
    status_id INT IDENTITY(1,1) PRIMARY KEY,
    status_name NVARCHAR(50) NULL
);

-- Tạo bảng ReservationStatus
CREATE TABLE ReservationStatus (
    status_id INT IDENTITY(1,1) PRIMARY KEY,
    status_name NVARCHAR(50) NULL
);

-- Tạo bảng Role
CREATE TABLE Role (
    role_id INT IDENTITY(1,1) PRIMARY KEY,
    role_name NVARCHAR(50) NULL
);


-- Tạo bảng Feature
CREATE TABLE Feature (
	feature_id INT IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(100) NULL,
	url NVARCHAR(100) NULL,
	note NVARCHAR(100) NULL
);

-- Tạo bảng RoleFeature
CREATE TABLE RoleFeature (
	feature_id INT,
	role_id INT,
	FOREIGN KEY (feature_id) REFERENCES Feature(feature_id),
	FOREIGN KEY (role_id) REFERENCES Role(role_id)
)

-- Tạo bảng Patient
CREATE TABLE Patient (
    patient_id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(25) NULL,
    password NVARCHAR(25) NULL,
    email NVARCHAR(100) NULL,
    phone NVARCHAR(15) NULL,
    name NVARCHAR(50) NULL,
    gender BIT NULL,
    avatar NVARCHAR(100) NULL,
    address NVARCHAR(100),
	role_id INT NULL,
	status_id INT NULL,
    FOREIGN KEY (status_id) REFERENCES Status(status_id),
	FOREIGN KEY (role_id) REFERENCES Role(role_id)
);

-- Tạo bảng Staff
CREATE TABLE Staff (
    staff_id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(25) NULL,
    password NVARCHAR(25) NULL,
    email NVARCHAR(100) NULL,
    phone NVARCHAR(15) NULL,
    name NVARCHAR(50) NULL,
    gender BIT NULL,
    avatar NVARCHAR(100) NULL,
	address NVARCHAR(100),
    role_id INT NULL,
    status_id INT NULL,
    FOREIGN KEY (role_id) REFERENCES Role(role_id),
    FOREIGN KEY (status_id) REFERENCES Status(status_id)
);

-- Tạo bảng Admin
CREATE TABLE Admin (
    admin_id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(50) NULL,
    password NVARCHAR(50) NULL,
);


-- Tạo bảng Service Category
CREATE TABLE Service_category (
    category_id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) NULL,
	detail NVARCHAR(255) NULL
);

-- Tạo bảng Service
CREATE TABLE Service (
    service_id INT IDENTITY(1,1) PRIMARY KEY,
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
    post_id INT IDENTITY(1,1) PRIMARY KEY,
    title NVARCHAR(200) NULL,
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
    slot_id INT IDENTITY(1,1) PRIMARY KEY,
    start_time NVARCHAR(25) NULL,
    end_time NVARCHAR(25) NULL
);

-- Tạo bảng Reservation
CREATE TABLE Reservation (
    reservation_id INT IDENTITY(1,1) PRIMARY KEY,
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

-- Tạo bảng Feedback
CREATE TABLE Feedback (
    feedback_id INT IDENTITY(1,1) PRIMARY KEY,
	service_id INT NULL,
	patient_id INT NULL,
    rate INT NULL,
	title NVARCHAR(255) NULL,
	detail NVARCHAR(MAX) NULL,
	update_date DATETIME NULL,
	FOREIGN KEY (service_id) REFERENCES Service(service_id),
	FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);


-- Thêm dữ liệu vào bảng Role
INSERT INTO [dbo].[Role] ([role_name]) VALUES
( N'patient'),
( N'nurse'),
( N'doctor'),
( N'manager');
GO


-- Thêm dữ liệu vào bảng StaffStatus
INSERT INTO Status (status_name) VALUES 
(N'Inactive'),       -- Hoạt động
(N'Active'),     -- Không hoạt động
(N'Suspended');    -- Tạm ngưng hoạt động

-- Thêm dữ liệu vào bảng Staff (1 nurse, 2 doctor, 1 manager)
INSERT INTO Staff ( username, password, email, phone, name, gender, avatar, address, role_id, status_id) VALUES 
(N'nurse', N'123', N'nurse1@example.com', N'1111111111', N'Nurse 1', 0, N'default.jpg',N'address default', 2, 2), -- Nurse
(N'doctor', N'123', N'doctor1@example.com', N'2222222222', N'Doctor 1', 1, N'default.jpg',N'address default', 3, 2), -- Doctor
(N'manager', N'123', N'manager1@example.com', N'3333333333', N'Manager 1', 1, N'default.jpg',N'address default', 4, 2), -- Manager
(N'doctor2', N'123', N'doctor2@example.com', N'4444444444', N'Doctor 2', 1, N'default.jpg',N'address default', 3, 2); -- Doctor

-- Thêm dữ liệu vào bảng Patient với các trạng thái từ bảng PatientStatus
INSERT INTO Patient (username, password, email, phone, name, gender, avatar, address,role_id, status_id) VALUES 
( N'p1', N'123', N'patient1@example.com', N'1111111111', N'Patient 1', 1,N'default.jpg',N'address default', 1, 1), -- inactive
( N'p2', N'123', N'patient2@example.com', N'2222222222', N'Patient 2', 0,N'default.jpg',N'address default', 1, 2), -- Active
( N'p3', N'123', N'patient3@example.com', N'3333333333', N'Patient 3', 1,N'default.jpg',N'address default', 1, 3) -- Suspended

-- Thêm dữ liệu vào bảng feature
INSERT INTO Feature (name, url, note) VALUES
(N'CreateReservation', N'/Reservation/Create', N'A website to create Reservations'),
(N'BookReservation', N'/Reservation/Book', N'A website to book Reservations')

-- Thêm dữ liệu cho phép manager truy cập vào CreateReservation, patient vào BookReservation
INSERT INTO RoleFeature (role_id, feature_id) VALUES
(4, 1), (1,2)

--Thêm dữ liệu 4 slot vào
INSERT INTO Slot (start_time, end_time) VALUES
(N'07:30 AM', N'9:30 AM'), (N'09:30 AM', N'11:30 AM'), (N'02:30 PM', N'4:30 PM'), (N'04:30 PM', N'6:30 PM')

-- Chèn dữ liệu vào bảng category
INSERT INTO Service_category( name, detail)
VALUES
( 'Health Consultation', N'Health Consultation Detail'), 
( 'Medical Examination', N'Health Consultation Detail'), 
( 'Vaccination', N'Health Consultation Detail');


-- Chèn dữ liệu vào bảng service
INSERT INTO service ( category_id, image, name, detail, price, discount, status_id )
VALUES
-- Dịch vụ cho Health Consultation (category_id = 1)
( 1, 'health_consultation.jpg', 'Health Checkup', 'Regular health checkup and consultation.', 100.00, 0.00,1),
( 1, 'diet_advice.jpg', 'Diet Advice', 'Nutritional consultation and personalized diet planning.', 80.00, 0.00,0),
( 1, 'fitness_program.jpg', 'Fitness Program', 'Customized fitness program and exercise routines.', 120.00, 0.00,1),

-- Dịch vụ cho Medical Examination (category_id = 2)
(2, 'medical_exam.jpg', 'General Medical Examination', 'Comprehensive medical examination for overall health assessment.', 150.00, 0.00,1),
(2, 'blood_test.jpg', 'Blood Tests', 'Various blood tests to assess specific health parameters.', 60.00, 0.00,1),
(2, 'x_ray.jpg', 'X-ray Services', 'X-ray imaging for diagnostic purposes.', 90.00, 0.00, 0),

-- Dịch vụ cho Vaccination (category_id = 3)
(3, 'vaccine1.jpg', 'Flu Vaccination', 'Annual flu vaccination to prevent influenza.', 40.00, 0.00, 0),
(3, 'vaccine2.jpg', 'Childhood Vaccination', 'Routine vaccinations for children as per vaccination schedule.', 55.00, 0.00, 1),
(3, 'vaccine3.jpg', 'Travel Vaccination', 'Vaccinations required for travel to specific regions.', 70.00, 0.00, 1);


-- Thêm feedback 
INSERT INTO Feedback (service_id, patient_id, rate, title, detail, update_date)
VALUES
-- Dịch vụ từ ID 1 đến 3 (Health Consultation)
(1, 1, 5, 'Excellent Service', 'The health checkup was thorough and professional.','10-10-23'),
(2, 1, 4, 'Good Diet Advice', 'The diet advice was helpful and personalized.','10-10-23'),
(3, 1, 3, 'Average Fitness Program', 'The fitness program was okay, could be more tailored to my needs.','10-10-23'),

-- Dịch vụ từ ID 4 đến 6 (Medical Examination)
(4, 1, 5, 'Comprehensive Medical Examination', 'The medical examination covered all aspects of my health.','10-10-23'),
(5, 1, 4, 'Accurate Blood Tests', 'The blood tests were accurate and results were delivered promptly.','10-10-23'),
(6, 1, 3, 'X-ray Service', 'The X-ray service was satisfactory, no issues reported.','10-10-23'),

-- Dịch vụ từ ID 7 đến 9 (Vaccination)
(7, 1, 5, 'Flu Vaccination', 'The flu vaccination was administered efficiently.','10-10-23'),
(8, 1, 4, 'Childhood Vaccination', 'My child received the vaccinations as scheduled, no complaints.','10-10-23'),
(9, 1, 3, 'Travel Vaccination', 'The travel vaccinations were done adequately, but the waiting time was long.','10-10-23');
GO

-- Thêm các reservation có sẵn
insert into Reservation(staff_id, slot_id, patient_id,date) 
VALUES 
(2, 1, 1, '2023-10-22'), 
(4, 1, null, '2023-10-22'), 
(4, 1, null, '2023-10-23'), 
(4, 2, null, '2023-10-21')
GO

ALTER DATABASE SWP391_Database SET MULTI_USER
GO

--
select r.reservation_id, s.staff_id, s.name, s.gender from Reservation r, Staff s where r.staff_id = s.staff_id

--get all doctors
select f.staff_id, f.name from Staff f inner join Role r on f.role_id = r.role_id where r.role_name = 'doctor'

--Get available reservations
select r.reservation_id, r.slot_id, s.staff_id, s.name, r.patient_id, r.[date] from Reservation r inner join Staff s on r.staff_id = s.staff_id where r.patient_id is null and r.date >= CAST(GETDATE() AS Date)

--Check accessible link from account with username and password
(select f.feature_id, f.name, f.url from Staff s inner join RoleFeature rf on s.role_id = rf.role_id inner join Feature f on rf.feature_id = f.feature_id where username = 'p1' and [password] = '123')
Union (select f.feature_id, f.name, f.url from Patient p inner join RoleFeature rf on p.role_id = rf.role_id inner join Feature f on rf.feature_id = f.feature_id where username like 'p1' and [password] = '123') 

--
select * from Patient

--Recheck availability of the selected reservation
select * from Reservation where reservation_id = 1 and patient_id = null

select * from Reservation
go

select * from Patient