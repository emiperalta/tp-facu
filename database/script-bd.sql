USE [master]
GO
/****** Object:  Database [TPTema3]    Script Date: 6/11/2020 17:57:57 ******/
CREATE DATABASE [TPTema3]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TPTema3', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\TPTema3.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'TPTema3_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\TPTema3_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [TPTema3] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TPTema3].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TPTema3] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TPTema3] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TPTema3] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TPTema3] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TPTema3] SET ARITHABORT OFF 
GO
ALTER DATABASE [TPTema3] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TPTema3] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TPTema3] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TPTema3] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TPTema3] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TPTema3] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TPTema3] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TPTema3] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TPTema3] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TPTema3] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TPTema3] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TPTema3] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TPTema3] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TPTema3] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TPTema3] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TPTema3] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TPTema3] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TPTema3] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TPTema3] SET  MULTI_USER 
GO
ALTER DATABASE [TPTema3] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TPTema3] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TPTema3] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TPTema3] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [TPTema3] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [TPTema3] SET QUERY_STORE = OFF
GO
USE [TPTema3]
GO
/****** Object:  Table [dbo].[Alumnos]    Script Date: 6/11/2020 17:57:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alumnos](
	[idAlumno] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](20) NOT NULL,
	[apellido] [varchar](20) NOT NULL,
	[edad] [int] NOT NULL,
	[dni] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Alumnos] PRIMARY KEY CLUSTERED 
(
	[idAlumno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cursos]    Script Date: 6/11/2020 17:57:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cursos](
	[idCurso] [int] IDENTITY(1,1) NOT NULL,
	[tema] [varchar](30) NOT NULL,
	[descripcion] [varchar](100) NOT NULL,
	[costo] [float] NOT NULL,
 CONSTRAINT [PK_Cursos] PRIMARY KEY CLUSTERED 
(
	[idCurso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Descuentos]    Script Date: 6/11/2020 17:57:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Descuentos](
	[idDescuento] [int] IDENTITY(1,1) NOT NULL,
	[porcentaje] [int] NOT NULL,
 CONSTRAINT [PK_Descuentos] PRIMARY KEY CLUSTERED 
(
	[idDescuento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Inscripciones]    Script Date: 6/11/2020 17:57:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inscripciones](
	[idInscripcion] [int] IDENTITY(1,1) NOT NULL,
	[idAlumno] [int] NOT NULL,
	[idCurso] [int] NOT NULL,
	[idDescuento] [int] NOT NULL,
	[fechaInicio] [varchar](15) NOT NULL,
	[fechaFin] [varchar](15) NOT NULL,
	[monto] [float] NOT NULL,
	[montoDescuento] [float] NOT NULL,
 CONSTRAINT [PK_Inscripciones] PRIMARY KEY CLUSTERED 
(
	[idInscripcion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProgramasFinales]    Script Date: 6/11/2020 17:57:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProgramasFinales](
	[idProgramaFinal] [int] IDENTITY(1,1) NOT NULL,
	[nombrePrograma] [varchar](50) NOT NULL,
	[descripcion] [varchar](200) NOT NULL,
	[descargas] [int] NOT NULL,
	[disponible] [bit] NOT NULL,
	[idCurso] [int] NOT NULL,
	[idAlumno] [int] NOT NULL,
 CONSTRAINT [PK_ProgramasFinales] PRIMARY KEY CLUSTERED 
(
	[idProgramaFinal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Inscripciones]  WITH CHECK ADD  CONSTRAINT [FK_Inscripciones_Alumnos] FOREIGN KEY([idAlumno])
REFERENCES [dbo].[Alumnos] ([idAlumno])
GO
ALTER TABLE [dbo].[Inscripciones] CHECK CONSTRAINT [FK_Inscripciones_Alumnos]
GO
ALTER TABLE [dbo].[Inscripciones]  WITH CHECK ADD  CONSTRAINT [FK_Inscripciones_Cursos] FOREIGN KEY([idCurso])
REFERENCES [dbo].[Cursos] ([idCurso])
GO
ALTER TABLE [dbo].[Inscripciones] CHECK CONSTRAINT [FK_Inscripciones_Cursos]
GO
ALTER TABLE [dbo].[Inscripciones]  WITH CHECK ADD  CONSTRAINT [FK_Inscripciones_Descuentos] FOREIGN KEY([idDescuento])
REFERENCES [dbo].[Descuentos] ([idDescuento])
GO
ALTER TABLE [dbo].[Inscripciones] CHECK CONSTRAINT [FK_Inscripciones_Descuentos]
GO
ALTER TABLE [dbo].[ProgramasFinales]  WITH CHECK ADD  CONSTRAINT [FK_ProgramasFinales_Cursos] FOREIGN KEY([idCurso])
REFERENCES [dbo].[Cursos] ([idCurso])
GO
ALTER TABLE [dbo].[ProgramasFinales] CHECK CONSTRAINT [FK_ProgramasFinales_Cursos]
GO
USE [master]
GO
ALTER DATABASE [TPTema3] SET  READ_WRITE 
GO
