-- userId, userPw, name, ssn, regdate
SELECT * FROM Member;
SELECT COUNT(*) AS count FROM Member;
INSERT INTO Member(userId, userPw, name, ssn, regdate)
VALUES('lee3', '1', '이상윤', '830912-1236308', SYSDATE);
