-- userId, userPw, name, ssn, regdate
CREATE TABLE Member (
	userId VARCHAR2(10),
	userPw VARCHAR2(10),
	name VARCHAR2(20),
	ssn VARCHAR2(15),
	regdate DATE,
	PRIMARY KEY(userId)
);
SELECT * FROM Member;
DROP TABLE Member;
