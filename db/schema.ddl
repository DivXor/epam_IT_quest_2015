-- Drop all tables ans sequences
BEGIN

  FOR c IN (SELECT table_name FROM user_tables) LOOP
    EXECUTE IMMEDIATE ('DROP TABLE ' || c.table_name || ' CASCADE CONSTRAINTS');
  END LOOP;

  FOR s IN (SELECT sequence_name FROM user_sequences) LOOP
    EXECUTE IMMEDIATE ('DROP SEQUENCE ' || s.sequence_name);
  END LOOP;

END;


CREATE TABLE ASSOCIATIONS
(
  ID         INTEGER PRIMARY KEY,
  IMG1       VARCHAR2(100 CHAR),
  IMG2       VARCHAR2(100 CHAR),
  IMG3       VARCHAR2(100 CHAR),
  IMG4       VARCHAR2(100 CHAR),
  HINT_TOTAL INTEGER,
  BASE_SCORE NUMBER(2)
);

CREATE TABLE ASSOCIATIONS_HISTORY
(
  ID              INTEGER PRIMARY KEY,
  HINT_COUNTER    INTEGER,
  ANSWERED        INTEGER,
  TIME            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  ASSOCIATIONS_ID INTEGER NOT NULL,
  USER_ID         INTEGER NOT NULL
);
ALTER TABLE ASSOCIATIONS_HISTORY ADD CHECK ( ANSWERED IN (0, 1));

CREATE TABLE COMMENTS
(
  ID      INTEGER PRIMARY KEY,
  MESSAGE VARCHAR2(500 CHAR),
  TIME    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  USER_ID INTEGER NOT NULL
);

CREATE TABLE GRAMMAR_HISTORY
(
  ID              INTEGER PRIMARY KEY,
  ANSWER          VARCHAR2(100 CHAR),
  TIME            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  GRAMMAR_QUIZ_ID INTEGER NOT NULL,
  USER_ID         INTEGER NOT NULL
);

CREATE TABLE GRAMMAR_QUIZ
(
  ID         INTEGER PRIMARY KEY,
  ANSWER     VARCHAR2(10 CHAR),
  SENTENCE   VARCHAR2(200 CHAR),
  BASE_SCORE NUMBER(2)
);

CREATE TABLE MAZE
(
  ID         INTEGER PRIMARY KEY,
  WX         INTEGER NOT NULL,
  WY         INTEGER,
  WORD       VARCHAR2(100 CHAR),
  BASE_SCORE NUMBER(2)
);

CREATE TABLE MAZE_HISTORY
(
  ID      INTEGER PRIMARY KEY,
  TIME    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  MAZE_ID INTEGER NOT NULL,
  USER_ID INTEGER NOT NULL
);

CREATE TABLE TASKS
(
  ID   INTEGER PRIMARY KEY,
  TYPE VARCHAR2(100)
);

CREATE TABLE USERS
(
  ID          INTEGER PRIMARY KEY,
  NAME        VARCHAR2(100 CHAR),
  PASSWORD    VARCHAR2(100 CHAR),
  ROLE        VARCHAR2(20 CHAR),
  TOTAL_SCORE NUMBER(2),
  TASKS_ID    INTEGER NOT NULL
);
ALTER TABLE USERS ADD CHECK ( ROLE IN ('ADMIN', 'ANONYMOUS', 'USER'));

CREATE TABLE WORD_SEARCH
(
  ID         INTEGER PRIMARY KEY,
  ANSWER     VARCHAR2(100 CHAR),
  BASE_SCORE NUMBER(2)
);

CREATE TABLE WORD_SEARCH_HISTORY
(
  ID             INTEGER PRIMARY KEY,
  TIME           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  WORD_SEARCH_ID INTEGER NOT NULL,
  USER_ID        INTEGER NOT NULL
);

CREATE TABLE WRONG_PICTURE
(
  ID                    INTEGER PRIMARY KEY,
  TIME                  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  WRONG_PICTURE_QUIZ_ID INTEGER NOT NULL,
  USER_ID               INTEGER NOT NULL
);

CREATE TABLE WRONG_PICTURE_QUIZ
(
  ID                    INTEGER PRIMARY KEY,
  ANSWER_PICTURE_NUMBER INTEGER,
  IMG1                  VARCHAR2(100 CHAR),
  IMG2                  VARCHAR2(100 CHAR),
  IMG3                  VARCHAR2(100 CHAR),
  IMG4                  VARCHAR2(100 CHAR),
  BASE_SCORE            NUMBER(2)
);

ALTER TABLE ASSOCIATIONS_HISTORY ADD CONSTRAINT ASSOCIATIONS_FK FOREIGN KEY (ASSOCIATIONS_ID) REFERENCES ASSOCIATIONS (ID);

ALTER TABLE ASSOCIATIONS_HISTORY ADD CONSTRAINT ASSOCIATIONS_HISTORY_USER_FK FOREIGN KEY (USER_ID) REFERENCES USERS (ID);

ALTER TABLE COMMENTS ADD CONSTRAINT COMMENTS_USER_FK FOREIGN KEY (USER_ID) REFERENCES USERS (ID);

ALTER TABLE GRAMMAR_HISTORY ADD CONSTRAINT GRAMMAR_HISTORY_USER_FK FOREIGN KEY (USER_ID) REFERENCES USERS (ID);

ALTER TABLE GRAMMAR_HISTORY ADD CONSTRAINT GRAMMAR_QUIZ_FK FOREIGN KEY (GRAMMAR_QUIZ_ID) REFERENCES GRAMMAR_QUIZ (ID);

ALTER TABLE MAZE_HISTORY ADD CONSTRAINT MAZE_FK FOREIGN KEY (MAZE_ID) REFERENCES MAZE (ID);

ALTER TABLE MAZE_HISTORY ADD CONSTRAINT MAZE_HISTORY_USER_FK FOREIGN KEY (USER_ID) REFERENCES USERS (ID);

ALTER TABLE WRONG_PICTURE ADD CONSTRAINT PICTURE_QUIZ_FK FOREIGN KEY (WRONG_PICTURE_QUIZ_ID) REFERENCES WRONG_PICTURE_QUIZ (ID);

ALTER TABLE USERS ADD CONSTRAINT USER_TASKS_FK FOREIGN KEY (TASKS_ID) REFERENCES TASKS (ID);

ALTER TABLE WORD_SEARCH_HISTORY ADD CONSTRAINT WORD_SEARCH_FK FOREIGN KEY (WORD_SEARCH_ID) REFERENCES WORD_SEARCH (ID);

ALTER TABLE WORD_SEARCH_HISTORY ADD CONSTRAINT WORD_SEARCH_HISTORY_USER_FK FOREIGN KEY (USER_ID) REFERENCES USERS (ID);

ALTER TABLE WRONG_PICTURE ADD CONSTRAINT WRONG_PICTURE_USER_FK FOREIGN KEY (USER_ID) REFERENCES USERS (ID);

CREATE SEQUENCE ASSOCIATIONS_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER ASSOCIATIONS_ID_TRG BEFORE
INSERT ON ASSOCIATIONS FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := ASSOCIATIONS_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE ASSOCIATIONS_HISTORY_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER ASSOCIATIONS_HISTORY_ID_TRG BEFORE
INSERT ON ASSOCIATIONS_HISTORY FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := ASSOCIATIONS_HISTORY_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE COMMENTS_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER COMMENTS_ID_TRG BEFORE
INSERT ON COMMENTS FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := COMMENTS_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE GRAMMAR_HISTORY_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER GRAMMAR_HISTORY_ID_TRG BEFORE
INSERT ON GRAMMAR_HISTORY FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := GRAMMAR_HISTORY_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE GRAMMAR_QUIZ_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER GRAMMAR_QUIZ_ID_TRG BEFORE
INSERT ON GRAMMAR_QUIZ FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := GRAMMAR_QUIZ_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE MAZE_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER MAZE_ID_TRG BEFORE
INSERT ON MAZE FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := MAZE_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE MAZE_HISTORY_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER MAZE_HISTORY_ID_TRG BEFORE
INSERT ON MAZE_HISTORY FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := MAZE_HISTORY_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE TASKS_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER TASKS_ID_TRG BEFORE
INSERT ON TASKS FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := TASKS_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE USER_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER USER_ID_TRG BEFORE
INSERT ON USERS FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := USER_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE WORD_SEARCH_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER WORD_SEARCH_ID_TRG BEFORE
INSERT ON WORD_SEARCH FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := WORD_SEARCH_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE WORD_SEARCH_HISTORY_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER WORD_SEARCH_HISTORY_ID_TRG BEFORE
INSERT ON WORD_SEARCH_HISTORY FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := WORD_SEARCH_HISTORY_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE WRONG_PICTURE_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER WRONG_PICTURE_ID_TRG BEFORE
INSERT ON WRONG_PICTURE FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := WRONG_PICTURE_ID_SEQ.NEXTVAL;
END;


CREATE SEQUENCE WRONG_PICTURE_QUIZ_ID_SEQ START WITH 1 NOCACHE ORDER;
CREATE OR REPLACE TRIGGER WRONG_PICTURE_QUIZ_ID_TRG BEFORE
INSERT ON WRONG_PICTURE_QUIZ FOR EACH ROW WHEN (NEW.ID IS NULL) BEGIN :NEW.ID := WRONG_PICTURE_QUIZ_ID_SEQ.NEXTVAL;
END;

COMMIT;

