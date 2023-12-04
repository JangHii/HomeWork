-- 2023-11-23 --

CREATE TABLE `board` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `writer` varchar(200) NOT NULL,
  `content` text,
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `moddate` datetime DEFAULT CURRENT_TIMESTAMP,
  `readcount` int DEFAULT '0',
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



-- 2023-11-27 --

CREATE TABLE member(
id VARCHAR(100) NOT NULL,
pwd VARCHAR(200) NOT NULL,
email VARCHAR(200) NOT NULL,
age Int DEFAULT 0,
regdate DATETIME DEFAULT NOW(),
lastlogin DATETIME DEFAULT NOW(),
PRIMARY KEY(id));


--2023-12-04 --

CREATE TABLE comment(
cno INT AUTO_INCREMENT,
bno INT NOT NULL,
wtiter VARCHAR(100) DEFAULT "unKnoen",
content VARCHAR(1000) NOT NULL,
regdate DATETIME DEFAULT NOW(),
PRIMARY KEY(cno));