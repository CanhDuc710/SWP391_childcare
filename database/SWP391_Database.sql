USE [master]
GO
/****** Object:  Database [SWP391_Database]    Script Date: 20/9/2023 5:01:09 PM ******/
CREATE DATABASE [SWP391_Database]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SWP391_Database', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\SWP391_Database.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SWP391_Database_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\SWP391_Database_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [SWP391_Database] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SWP391_Database].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SWP391_Database] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SWP391_Database] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SWP391_Database] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SWP391_Database] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SWP391_Database] SET ARITHABORT OFF 
GO
ALTER DATABASE [SWP391_Database] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SWP391_Database] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SWP391_Database] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SWP391_Database] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SWP391_Database] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SWP391_Database] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SWP391_Database] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SWP391_Database] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SWP391_Database] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SWP391_Database] SET  ENABLE_BROKER 
GO
ALTER DATABASE [SWP391_Database] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SWP391_Database] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SWP391_Database] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SWP391_Database] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SWP391_Database] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SWP391_Database] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SWP391_Database] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SWP391_Database] SET RECOVERY FULL 
GO
ALTER DATABASE [SWP391_Database] SET  MULTI_USER 
GO
ALTER DATABASE [SWP391_Database] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SWP391_Database] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SWP391_Database] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SWP391_Database] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SWP391_Database] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SWP391_Database] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'SWP391_Database', N'ON'
GO
ALTER DATABASE [SWP391_Database] SET QUERY_STORE = OFF
GO
USE [SWP391_Database]
GO
/****** Object:  User [BlackZ]    Script Date: 20/9/2023 5:01:09 PM ******/
CREATE USER [BlackZ] FOR LOGIN [BlackZ] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[admin_id] [int] NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[admin_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[customer_id] [int] NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[name] [nvarchar](50) NULL,
	[email] [nvarchar](100) NULL,
	[phone] [nvarchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post](
	[post_id] [int] NOT NULL,
	[title] [nvarchar](200) NULL,
	[author] [nvarchar](100) NULL,
	[updated_date] [date] NULL,
	[post_category] [int] NULL,
	[detail] [nvarchar](max) NULL,
	[image] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[post_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post_category]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post_category](
	[post_category_id] [int] NOT NULL,
	[category] [nvarchar](50) NULL,
	[detail] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[post_category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reservation]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reservation](
	[reservation_id] [int] NOT NULL,
	[slot_id] [int] NULL,
	[customer_id] [int] NULL,
	[staff_id] [int] NULL,
	[status] [nvarchar](50) NULL,
	[date] [date] NULL,
	[total] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[reservation_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reservation_detail]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reservation_detail](
	[reservation_detail_id] [int] NOT NULL,
	[reservation_id] [int] NULL,
	[service_id] [int] NULL,
	[quantity] [int] NULL,
	[person_amount] [int] NULL,
	[total] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[reservation_detail_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[role_id] [int] NOT NULL,
	[staff_id] [int] NULL,
	[role_type] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role_type]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_type](
	[role_type] [int] NOT NULL,
	[role_type_name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_type] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Service]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service](
	[service_id] [int] NOT NULL,
	[image] [nvarchar](200) NULL,
	[service_category] [int] NULL,
	[name] [nvarchar](100) NULL,
	[detail] [nvarchar](max) NULL,
	[price] [decimal](10, 2) NULL,
	[discount] [decimal](5, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[service_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Service_category]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service_category](
	[service_category_id] [int] NOT NULL,
	[category] [nvarchar](50) NULL,
	[detail] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[service_category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Slot]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Slot](
	[slot_id] [int] NOT NULL,
	[start_time] [time](7) NULL,
	[end_time] [time](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[slot_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Staff]    Script Date: 20/9/2023 5:01:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Staff](
	[staff_id] [int] NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[name] [nvarchar](50) NULL,
	[email] [nvarchar](100) NULL,
	[phone] [nvarchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[staff_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Admin] ([admin_id], [username], [password]) VALUES (1, N'admin', N'admin')
GO
INSERT [dbo].[Customer] ([customer_id], [username], [password], [name], [email], [phone]) VALUES (1, N'customer1', N'customer1', N'customer 1', N'customer1@example.com', N'0000000000')
INSERT [dbo].[Customer] ([customer_id], [username], [password], [name], [email], [phone]) VALUES (2, N'customer2', N'customer2', N'customer 2', N'customer2@exaple.com', N'1111111111')
GO
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (1, 1, 3)
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (2, 2, 1)
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (3, 3, 1)
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (4, 4, 2)
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (5, 5, 2)
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (6, 6, 2)
GO
INSERT [dbo].[Role_type] ([role_type], [role_type_name]) VALUES (1, N'nurse')
INSERT [dbo].[Role_type] ([role_type], [role_type_name]) VALUES (2, N'doctor')
INSERT [dbo].[Role_type] ([role_type], [role_type_name]) VALUES (3, N'manager')
GO
INSERT [dbo].[Staff] ([staff_id], [username], [password], [name], [email], [phone]) VALUES (1, N'manager', N'manager', N'manager', N'manager@example.com', N'0000000000')
INSERT [dbo].[Staff] ([staff_id], [username], [password], [name], [email], [phone]) VALUES (2, N'nurse1', N'nurse1', N'nurse 1', N'nurse1@example.com', N'1111111111')
INSERT [dbo].[Staff] ([staff_id], [username], [password], [name], [email], [phone]) VALUES (3, N'nurse2', N'nurse2', N'nurse 2', N'nurse2@example.com', N'2222222222')
INSERT [dbo].[Staff] ([staff_id], [username], [password], [name], [email], [phone]) VALUES (4, N'doctor1', N'doctor1', N'doctor 1', N'doctor1@example.com', N'3333333333')
INSERT [dbo].[Staff] ([staff_id], [username], [password], [name], [email], [phone]) VALUES (5, N'doctor2', N'doctor2', N'doctor 2', N'doctor2@example.com', N'4444444444')
INSERT [dbo].[Staff] ([staff_id], [username], [password], [name], [email], [phone]) VALUES (6, N'doctor3', N'doctor3', N'doctor 3', N'doctor3@example.com', N'5555555555')
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD FOREIGN KEY([post_category])
REFERENCES [dbo].[Post_category] ([post_category_id])
GO
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD FOREIGN KEY([customer_id])
REFERENCES [dbo].[Customer] ([customer_id])
GO
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD FOREIGN KEY([slot_id])
REFERENCES [dbo].[Slot] ([slot_id])
GO
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD FOREIGN KEY([staff_id])
REFERENCES [dbo].[Staff] ([staff_id])
GO
ALTER TABLE [dbo].[Reservation_detail]  WITH CHECK ADD FOREIGN KEY([reservation_id])
REFERENCES [dbo].[Reservation] ([reservation_id])
GO
ALTER TABLE [dbo].[Reservation_detail]  WITH CHECK ADD FOREIGN KEY([service_id])
REFERENCES [dbo].[Service] ([service_id])
GO
ALTER TABLE [dbo].[Role]  WITH CHECK ADD FOREIGN KEY([role_type])
REFERENCES [dbo].[Role_type] ([role_type])
GO
ALTER TABLE [dbo].[Role]  WITH CHECK ADD FOREIGN KEY([staff_id])
REFERENCES [dbo].[Staff] ([staff_id])
GO
ALTER TABLE [dbo].[Service]  WITH CHECK ADD FOREIGN KEY([service_category])
REFERENCES [dbo].[Service_category] ([service_category_id])
GO
USE [master]
GO
ALTER DATABASE [SWP391_Database] SET  READ_WRITE 
GO
