USE [SWP391_Database]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 21/9/2023 1:45:10 PM ******/
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
/****** Object:  Table [dbo].[Customer]    Script Date: 21/9/2023 1:45:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[customer_id] [int] NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[email] [nvarchar](100) NULL,
	[phone] [nvarchar](15) NULL,
	[name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post]    Script Date: 21/9/2023 1:45:10 PM ******/
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
/****** Object:  Table [dbo].[Post_category]    Script Date: 21/9/2023 1:45:10 PM ******/
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
/****** Object:  Table [dbo].[Reservation]    Script Date: 21/9/2023 1:45:10 PM ******/
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
/****** Object:  Table [dbo].[Reservation_detail]    Script Date: 21/9/2023 1:45:10 PM ******/
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
/****** Object:  Table [dbo].[Role]    Script Date: 21/9/2023 1:45:10 PM ******/
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
/****** Object:  Table [dbo].[Role_type]    Script Date: 21/9/2023 1:45:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_type](
	[role_type] [int] NOT NULL,
	[role_type_name] [nvarchar](50) NULL,
	[role_feature] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_type] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Service]    Script Date: 21/9/2023 1:45:10 PM ******/
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
/****** Object:  Table [dbo].[Service_category]    Script Date: 21/9/2023 1:45:10 PM ******/
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
/****** Object:  Table [dbo].[Slot]    Script Date: 21/9/2023 1:45:10 PM ******/
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
/****** Object:  Table [dbo].[Staff]    Script Date: 21/9/2023 1:45:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Staff](
	[staff_id] [int] NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[email] [nvarchar](100) NULL,
	[phone] [nvarchar](15) NULL,
	[name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[staff_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Admin] ([admin_id], [username], [password]) VALUES (1, N'admin', N'admin')
GO
INSERT [dbo].[Customer] ([customer_id], [username], [password], [email], [phone], [name]) VALUES (1, N'customer1', N'customer1', N'customer1@example.com', N'0000000000', N'customer 1')
INSERT [dbo].[Customer] ([customer_id], [username], [password], [email], [phone], [name]) VALUES (2, N'customer2', N'customer2', N'customer2@example.com', N'1111111111', N'customer 2')
GO
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (1, 1, 3)
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (2, 2, 1)
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (3, 3, 1)
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (4, 4, 2)
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (5, 5, 2)
INSERT [dbo].[Role] ([role_id], [staff_id], [role_type]) VALUES (6, 6, 2)
GO
INSERT [dbo].[Role_type] ([role_type], [role_type_name], [role_feature]) VALUES (1, N'nurse', NULL)
INSERT [dbo].[Role_type] ([role_type], [role_type_name], [role_feature]) VALUES (2, N'doctor', NULL)
INSERT [dbo].[Role_type] ([role_type], [role_type_name], [role_feature]) VALUES (3, N'manager', NULL)
GO
INSERT [dbo].[Staff] ([staff_id], [username], [password], [email], [phone], [name]) VALUES (1, N'manager', N'manager', N'manager@example.com', N'0000000000', N'manager')
INSERT [dbo].[Staff] ([staff_id], [username], [password], [email], [phone], [name]) VALUES (2, N'nurse1', N'nurse1', N'nurse1@example.com', N'1111111111', N'nurse 1')
INSERT [dbo].[Staff] ([staff_id], [username], [password], [email], [phone], [name]) VALUES (3, N'nurse2', N'nurse2', N'nurse2@example.com', N'2222222222', N'nurse 2')
INSERT [dbo].[Staff] ([staff_id], [username], [password], [email], [phone], [name]) VALUES (4, N'doctor1', N'doctor1', N'doctor1@example.com', N'3333333333', N'doctor 1')
INSERT [dbo].[Staff] ([staff_id], [username], [password], [email], [phone], [name]) VALUES (5, N'doctor2', N'doctor2', N'doctor2@example.com', N'4444444444', N'doctor 2')
INSERT [dbo].[Staff] ([staff_id], [username], [password], [email], [phone], [name]) VALUES (6, N'doctor3', N'doctor3', N'doctor3@example.com', N'5555555555', N'doctor 3')
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
