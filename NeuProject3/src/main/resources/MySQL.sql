-- create database
DROP DATABASE IF EXISTS quametmoi;
CREATE DATABASE quametmoi;
USE quametmoi;

-- create table: User
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` ( 	
	userID 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`username`	 	CHAR(50) NOT NULL UNIQUE ,
	`email` 		CHAR(50) NOT NULL UNIQUE ,
	`password` 		VARCHAR(800)  NOT NULL,
	`firstName` 	NVARCHAR(50)  NOT NULL,
	`lastName` 		NVARCHAR(50)  NOT NULL,
    avatar			NVARCHAR(500) NOT NULL,
    diachi			NVARCHAR(200) NOT NULL,
    sdt				NVARCHAR(20)  NOT NULL,
	`role` 			ENUM('Admin','Member','Manager')  DEFAULT 'Member',
    `status`		TINYINT DEFAULT 0 -- 0: Not Active, 1: Active
    
);

DROP TABLE IF EXISTS 	`Registration_User_Token`;
CREATE TABLE IF NOT EXISTS `Registration_User_Token` ( 	
	id 				INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`token`	 		VARCHAR(300) NOT NULL UNIQUE ,
	`user_id` 		INT UNSIGNED  NOT NULL UNIQUE,
	`expiryDate` 	DATETIME NOT NULL,
     UNIQUE(`user_id`),
    FOREIGN KEY (`user_id`) REFERENCES `User`(userID) ON DELETE CASCADE ON UPDATE CASCADE
);


-- Create table Reset_Password_Token
DROP TABLE IF EXISTS 	`Reset_Password_Token`;
CREATE TABLE IF NOT EXISTS `Reset_Password_Token` ( 	
	id 				INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`token`	 		VARCHAR(300) NOT NULL UNIQUE,
	`user_id` 		INT  UNSIGNED  UNIQUE NOT NULL,
	`expiryDate` 	DATETIME NOT NULL,
     FOREIGN KEY  (`user_id`)  REFERENCES `User`(userID) ON DELETE CASCADE 
);

DROP TABLE IF EXISTS categories;
CREATE TABLE IF NOT EXISTS categories (
	CategoryID		 	 INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName 		 VARCHAR(255) NOT NULL UNIQUE KEY,
	`Description` 		 VARCHAR(255)
);

DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products (
	ProductID 		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryID		INT UNSIGNED NOT NULL,
    ProductName		VARCHAR(255) NOT NULL UNIQUE KEY,
    `Description` 	VARCHAR(255),
    Image 			VARCHAR(255),
    SellPrice 		INT NOT NULL,
	CreateDate		DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY (CategoryID) REFERENCES  categories(CategoryID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS phuongthuctt;
CREATE TABLE IF NOT EXISTS phuongthuctt(
	idTT INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tentt VARCHAR(200) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS  carts;
CREATE TABLE IF NOT EXISTS carts (
	CartID 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProductID 		INT UNSIGNED NOT NULL,
	user_id 		INT UNSIGNED NOT NULL,
    idTT			INT UNSIGNED NOT NULL,
	quantity		SMALLINT NOT NULL,
    tongtien		INT UNSIGNED NOT NULL,
	FOREIGN KEY (ProductID) 	REFERENCES  products(ProductID) ON DELETE CASCADE,
	FOREIGN KEY (user_id) 	REFERENCES  `User`(userID) ON DELETE CASCADE,
    FOREIGN KEY (idTT) 	REFERENCES phuongthuctt(idTT) ON DELETE CASCADE
);

DROP TABLE IF EXISTS datlich;
CREATE TABLE IF NOT EXISTS datlich(
	DatlichID 		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    hoten			CHAR(50) NOT NULL ,
    phone 	  		CHAR(50) NOT NULL UNIQUE,
    `description`	VARCHAR(200) ,
    `require`		VARCHAR(200) ,
    settime			VARCHAR(200),
    datefix			VARCHAR(50) NOT NULL,
    chinhanh		VARCHAR(100) NOT NULL
);


INSERT INTO `User` (`username`,			`email`,										`password`,										`firstName`,	`lastName`,									avatar,											diachi,		sdt, 	        `role`  )
VALUE			 ('hanh.havan@vti',		'hanhhanoi1999@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Hà',			'Văn Hanh',  'https://i.pinimg.com/originals/31/be/32/31be32129c2ade799dab5c09c4f59575.jpg','CamPha', '0352438971'	,'Manager'  ), 
				 ('thanhhung12@vti',	'hung122112@gmail.com',			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Nguyễn ',	    'Thanh Hưng','https://i.pinimg.com/originals/31/be/32/31be32129c2ade799dab5c09c4f59575.jpg','CamPha','0352438971'	,'Manager'  ), 
				 ('can.tuananh@vti',	'cananh.tuan12@vti.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Cấn',		    'Tuấn Anh',	 'https://i.pinimg.com/originals/31/be/32/31be32129c2ade799dab5c09c4f59575.jpg','CamPha','0352438971'	,'Manager'  ), 
				 ('toananh123@vti',		'toananh123@vti.com',			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Nguyễn',		'Anh Toàn',  'https://i.pinimg.com/originals/31/be/32/31be32129c2ade799dab5c09c4f59575.jpg','CamPha','0352438971'	,'Manager'  ), 
				 ('duynn123@vti',		'duynguyen123@vti.com',			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Nguyễn',		'Duy',		 'https://i.pinimg.com/originals/31/be/32/31be32129c2ade799dab5c09c4f59575.jpg','CamPha','0352438971'	,'Member'	), 
				 ('manhhung123@vti',	'manhhung123@vti.com',			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Nguyễn',		'Mạnh Hùng', 'https://i.pinimg.com/originals/31/be/32/31be32129c2ade799dab5c09c4f59575.jpg','CamPha','0352438971'   , 'Admin'   ),
 				 ('maianhvti123',		'maianhng@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Nguyễn',		'Mai Anh',	 'https://i.pinimg.com/originals/31/be/32/31be32129c2ade799dab5c09c4f59575.jpg','CamPha','0352438971'	,'Member'	);


INSERT INTO categories(CategoryID,CategoryName,				`Description`)
VALUES 					(1,			'RAM',	  'Day la san pham thuoc RAM'),
						(2,			'SSD',	        'Day la san pham SSD'),
                        (3,			'PIN',    'Day la san pham thuoc PIN');
                        


INSERT INTO products     (CategoryID,ProductName,`Description`,Image,SellPrice)
VALUES					 (1,'Ram 8GB DDR4-2666 1Rx8 ECC UDIMM','Good','https://www.thegioimaychu.vn/image/cache/catalog/RamSS2-600x451.png','800000'),
						 (2,'A400 Solid-State Drive','Good','https://media.kingston.com/kingston/product/ktc-product-ssd-a400-sa400s37-120gb-1-zm-lg.jpg','900000'),
						 (3,'Pin laptop Lenovo ThinkPad T460','Good','http://pinlaptopvn.com/wp-content/uploads/2019/03/Pin-laptop-Lenovo-ThinkPad-T460-T460s-T460p-2.jpg','800000'),
						 (1,'Ram 8GB DDR4-2667 1Rx8 ','Good','https://www.thegioimaychu.vn/image/cache/catalog/RamSS2-600x451.png','800000'),
						 (2,'SSD UV500 2,5”/m.2/mSATA','Good','https://media.kingston.com/kingston/hero/ktc-hero-ssd-uv500-family-lg.jpg','2000000'),
						 (1,'Ram PC 8gb 3200 Kingston','Medium','https://mega.com.vn/media/product/75_ram_kingston_8gb_ddr4_3200_hx432c16pb3a8_tan_led_rgb_1.jpg','700000');

INSERT INTO datlich(DatlichID,hoten,phone,`description`,`require`,settime,datefix,				   chinhanh)
VALUES			   (1,"Ngo Trung Nhat","03524389716","Lag lag","Den Cua Hang","8h-9h","08/07/2021","Ha Noi");



INSERT INTO phuongthuctt(idTT,tentt)
VALUES 					(1,"Bang tien mat"),
						(2,"Bang AirPay"),
						(3,"Bang MoMo");

INSERT INTO carts(ProductID,user_id,idTT,quantity,tongtien) 
VALUES			 (1,1,1,2,1600000) ,
				 (3,2,2,2,2600000) ,
				 (2,1,1,3,2600000) ;
                     





