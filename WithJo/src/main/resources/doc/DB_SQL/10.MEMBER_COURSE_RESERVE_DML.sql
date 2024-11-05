--MEMBER_COURSE_RESERVE DML

DROP TABLE MEMBER_COURSE_RESERVE;

CREATE TABLE MEMBER_COURSE_RESERVE(
	MEMBER_COURSE_RESERVE_NO NUMBER(10)
    ,COURSE_NO NUMBER(10)
    ,MEMBER_NO NUMBER(10)
    ,CATEGORY_NO NUMBER(10)
	,CONSTRAINT MEMBER_COURSE_RESERVE_NO_PK PRIMARY KEY (MEMBER_COURSE_RESERVE_NO)
    ,CONSTRAINT M_C_COURSE_NO_FK FOREIGN KEY (COURSE_NO) REFERENCES COURSE_LIST(COURSE_NO)
    ,CONSTRAINT M_C_MEMBER_NO_FK FOREIGN KEY (MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)
    ,CONSTRAINT M_C_CATEGORY_NO_FK FOREIGN KEY (CATEGORY_NO) REFERENCES CATEGORY(CATEGORY_NO)
); 

DROP SEQUENCE MEMBER_COURSE_RESERVE_NO_SEQ;

CREATE SEQUENCE MEMBER_COURSE_RESERVE_NO_SEQ
INCREMENT BY 1
START WITH 1;


SELECT * 
FROM MEMBER_COURSE_RESERVE;

SELECT C.COURSE_NO
      ,C.COURSE_MAIN_IMAGE
      ,C.COURSE_NAME
      ,C.COURSE_START_DATE
      ,C.COURSE_END_DATE
      ,C.COURSE_START_TIME
      ,C.COURSE_END_TIME
      ,C.COURSE_TEACHER
      ,M.MEMBER_NO
FROM COURSE_LIST C, MEMBER M, MEMBER_COURSE_RESERVE MCR
WHERE M.MEMBER_NO = 5
AND M.MEMBER_NO = MCR.MEMBER_NO
AND C.COURSE_NO = MCR.COURSE_NO;

      

COMMIT;

