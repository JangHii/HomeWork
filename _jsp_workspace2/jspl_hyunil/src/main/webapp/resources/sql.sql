2023-11-29 borad DB

CREATE TABLE board(
bno INT AUTO_INCREMENT,
title VARCHAR(200) NOT NULL,
writer VARCHAR(200) NOT NULL,
content TEXT,
regdate DATETIME DEFAULT NOW(),
moddate DATETIME DEFAULT NOW(),
readcount INT DEFAULT 0, 
PRIMARY KEY(bno));

-----------------------------------------------------

2023-11-29 member DB

CREATE TABLE member(
id VARCHAR(100) NOT NULL,
pwd VARCHAR(200) NOT NULL,
email VARCHAR(200) NOT NULL,
age Int DEFAULT 0,
regdate DATETIME DEFAULT NOW(),
lastlogin DATETIME DEFAULT NOW(),
PRIMARY KEY(id));