USE [SWP391_Database]
GO
/****** Object:  Table [dbo].[Account_Role]    Script Date: 18/9/2023 4:34:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account_Role](
	[username] [nvarchar](50) NOT NULL,
	[roleid] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC,
	[roleid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Blog]    Script Date: 18/9/2023 4:34:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Blog](
	[id] [int] NOT NULL,
	[title] [nvarchar](200) NULL,
	[author] [nvarchar](100) NULL,
	[updatedDate] [date] NULL,
	[category_id] [int] NULL,
	[detail] [nvarchar](max) NULL,
	[image] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feature]    Script Date: 18/9/2023 4:34:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feature](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[url] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Patient]    Script Date: 18/9/2023 4:34:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Patient](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[fullname] [nvarchar](100) NULL,
	[gender] [nvarchar](10) NULL,
	[email] [nvarchar](100) NULL,
	[mobile] [nvarchar](15) NULL,
	[address] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reservation]    Script Date: 18/9/2023 4:34:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reservation](
	[id] [int] NOT NULL,
	[patient] [nvarchar](50) NULL,
	[doctor] [nvarchar](50) NULL,
	[slot] [int] NULL,
	[date] [date] NULL,
	[note] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReservationSlot]    Script Date: 18/9/2023 4:34:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReservationSlot](
	[id] [int] NOT NULL,
	[startTime] [time](7) NULL,
	[endTime] [time](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 18/9/2023 4:34:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role_Feature]    Script Date: 18/9/2023 4:34:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_Feature](
	[role_id] [int] NOT NULL,
	[feature_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC,
	[feature_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Staff]    Script Date: 18/9/2023 4:34:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Staff](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[fullname] [nvarchar](100) NULL,
	[gender] [nvarchar](10) NULL,
	[email] [nvarchar](100) NULL,
	[mobile] [nvarchar](15) NULL,
	[address] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Staff] ([username], [password], [fullname], [gender], [email], [mobile], [address]) VALUES (N'staff1', N'password1', N'John Smith', N'Male', N'john.smith@example.com', N'1234567890', N'123 Main St')
INSERT [dbo].[Staff] ([username], [password], [fullname], [gender], [email], [mobile], [address]) VALUES (N'staff2', N'password2', N'Jane Doe', N'Female', N'jane.doe@example.com', N'9876543210', N'456 Elm St')
INSERT [dbo].[Staff] ([username], [password], [fullname], [gender], [email], [mobile], [address]) VALUES (N'staff3', N'password3', N'Mike Johnson', N'Male', N'mike.johnson@example.com', N'5555555555', N'789 Oak St')
INSERT [dbo].[Staff] ([username], [password], [fullname], [gender], [email], [mobile], [address]) VALUES (N'staff4', N'password4', N'Sara Wilson', N'Female', N'sara.wilson@example.com', N'1111111111', N'101 Maple St')
INSERT [dbo].[Staff] ([username], [password], [fullname], [gender], [email], [mobile], [address]) VALUES (N'staff5', N'password5', N'Tom Brown', N'Male', N'tom.brown@example.com', N'9999999999', N'202 Pine St')
GO
ALTER TABLE [dbo].[Account_Role]  WITH CHECK ADD FOREIGN KEY([roleid])
REFERENCES [dbo].[Role] ([id])
GO
ALTER TABLE [dbo].[Account_Role]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Staff] ([username])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Blog]  WITH CHECK ADD FOREIGN KEY([category_id])
REFERENCES [dbo].[Feature] ([id])
GO
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD FOREIGN KEY([doctor])
REFERENCES [dbo].[Staff] ([username])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD FOREIGN KEY([patient])
REFERENCES [dbo].[Patient] ([username])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD FOREIGN KEY([slot])
REFERENCES [dbo].[ReservationSlot] ([id])
GO
ALTER TABLE [dbo].[Role_Feature]  WITH CHECK ADD FOREIGN KEY([feature_id])
REFERENCES [dbo].[Feature] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Role_Feature]  WITH CHECK ADD FOREIGN KEY([role_id])
REFERENCES [dbo].[Role] ([id])
ON DELETE CASCADE
GO
