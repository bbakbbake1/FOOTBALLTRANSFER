DROP TABLE PLAYER;
DROP TABLE MEMBERS;
DROP TABLE TEAM;
DROP TABLE OWNER;

DROP SEQUENCE MEMBERS_SEQ;
DROP SEQUENCE PLAYER_SEQ;
DROP SEQUENCE TEAM_SEQ;

CREATE SEQUENCE MEMBERS_SEQ;
CREATE SEQUENCE PLAYER_SEQ;
CREATE SEQUENCE TEAM_SEQ;

CREATE TABLE TEAM(
    T_NO NUMBER(5) CONSTRAINT T_PK PRIMARY KEY,
    T_NAME VARCHAR2(20) CONSTRAINT T_UK UNIQUE NOT NULL
);

CREATE TABLE MEMBERS(
    M_NO NUMBER(5) CONSTRAINT M_PK PRIMARY KEY,
    T_NO NUMBER(5) CONSTRAINT M_T_FK REFERENCES TEAM (T_NO) ON DELETE SET NULL,
    M_ID VARCHAR2(20) CONSTRAINT M_UK UNIQUE NOT NULL,
    M_PW VARCHAR2(20) NOT NULL,
    M_BALANCE NUMBER(8) DEFAULT 10000000 CHECK(M_BALANCE > 0),
    M_ISADMIN NUMBER(1) DEFAULT 0 CHECK(M_ISADMIN IN(0,1)) NOT NULL
);

CREATE TABLE PLAYER(
    P_NO NUMBER(5)CONSTRAINT P_PK PRIMARY KEY,
    T_NO NUMBER(5) CONSTRAINT P_T_FK REFERENCES TEAM (T_NO) ON DELETE SET NULL,
    P_NAME VARCHAR2(30) NOT NULL,
    P_BACKNUM NUMBER(2) NOT NULL,
    P_POSITION VARCHAR2(2) NOT NULL,
    P_SHOT NUMBER(2) NOT NULL,
    P_PASS NUMBER(2) NOT NULL,
    P_DAFENSE NUMBER(2) NOT NULL,
    P_PRICE NUMBER(8) CHECK (P_PRICE > 0) NOT NULL
);

CREATE TABLE OWNER(
    M_NO NUMBER(5) CONSTRAINT OWNER_M_NO_fk REFERENCES MEMBERS(M_NO) ON DELETE CASCADE NOT NULL,
    P_NO NUMBER(5) CONSTRAINT OWNER_P_NO_fk REFERENCES PLAYER(P_NO) ON DELETE CASCADE NOT NULL
);

INSERT INTO TEAM VALUES (TEAM_SEQ.NEXTVAL, 'Tottenham Spurs');
INSERT INTO TEAM VALUES (TEAM_SEQ.NEXTVAL, 'Manchester City');
INSERT INTO TEAM VALUES (TEAM_SEQ.NEXTVAL, 'Barcelona');

INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'Heung Min Son', 7,'fw', 82, 60, 40, 98000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'Richarlison', 9,'fw', 81, 60, 40, 46000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'Brennan Johnson', 22,'fw', 78, 60, 40, 36000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'James Maddison', 10,'mf', 60, 70, 50, 88000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'Rodrigo Bentancur', 30,'mf', 60, 70, 50, 39000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'Pierre-Emile Højbjerg', 5,'mf', 60, 70, 50, 52000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'Pedro Porro', 23,'df', 40, 80, 80, 44000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'Cristian Romero', 17,'df', 40, 80, 80, 85000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'Micky van de Ven', 37,'df', 40, 80, 80, 26000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'Destiny Udogie', 4,'df', 40, 80, 80, 39000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 1, 'Guglielmo Vicario', 13, 'gk', 20, 90, 80, 39000);

INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Erling Haaland', 9, 'fw', 82, 60, 40,  195000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Phil Foden', 47, 'fw', 83, 60, 40,  117000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Jack Grealishn', 10, 'fw', 75, 60, 40,  156000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Kevin De Bruyne', 17, 'mf', 80, 60, 40,  208000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Rodri', 16, 'mf', 81, 70, 50,  114000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Bernardo Silva', 20, 'mf', 79, 70, 50,  156000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Kyle Walker', 2, 'df', 40, 80, 80,  91000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Nathan Aké', 6, 'df', 40, 80, 80,  83000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Joško Gvardiol', 24, 'df', 40, 80, 80,  104000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Sergio Gómez', 21, 'df', 40, 80, 80,  39000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 2, 'Stefan Ortega', 18, 'gk', 20, 90, 80,  28000);

INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Lewandowski', 9, 'fw', 86, 60, 40,  120000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Lamin Yamal', 27, 'fw', 83, 60, 40,  125000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Joao Felix', 14, 'fw', 79, 60, 40,  50000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Frenkie De Jong', 21, 'mf', 60, 70, 50,  130000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Ilkay Gundogan', 22, 'mf', 60, 70, 50,  85000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Pedri', 8, 'mf', 60, 70, 50,  130000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Balde', 3, 'df', 40,  80, 80,  115000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Jules Kounde', 23, 'df', 40, 80, 80,  95000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Ronald Araujo', 4, 'df', 40, 80, 80,  115000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Joao Cancelo', 2, 'df', 40, 80, 80,  80000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'Marc-Andre Ter Stergen', 1, 'gk', 20, 90, 80,  115000);
INSERT INTO PLAYER VALUES (PLAYER_SEQ.NEXTVAL, 3, 'ASD', 1, 'FW', 1, 1, 1, 1);

INSERT INTO MEMBERS VALUES (MEMBERS_SEQ.NEXTVAL, 1, 'admin', 'admin', 10000000, 1);

INSERT INTO TEAM VALUES (TEAM_SEQ.NEXTVAL, 'BBAKBBAKE'); 

DELETE FROM PLAYER WHERE T_NO = ? AND P_NAME = ? AND P_BACKNUM = ?;
COMMIT;

SELECT * FROM TEAM ORDER BY T_NO DESC;
SELECT * FROM MEMBERS;
SELECT * FROM PLAYER;
SELECT * FROM OWNER;