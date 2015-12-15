
CREATE TABLE "User"
  (
    id               INTEGER NOT NULL ,
    name             VARCHAR2 (100 CHAR) ,
    password         VARCHAR2 (100 CHAR) ,
    role             VARCHAR2 (20 CHAR) ,
    Result_id        INTEGER NOT NULL ,
    total_score      NUMBER (2) ,
    current_tasks_id INTEGER NOT NULL
  ) ;
ALTER TABLE "User" ADD CHECK ( role IN ('ADMIN', 'ANONYMOUS', 'USER')) ;
ALTER TABLE "User" ADD CONSTRAINT User_PK PRIMARY KEY ( id ) ;


CREATE TABLE associations
  (
    id         INTEGER NOT NULL ,
    img1       VARCHAR2 (100 CHAR) ,
    img2       VARCHAR2 (100 CHAR) ,
    img3       VARCHAR2 (100 CHAR) ,
    img4       VARCHAR2 (100 CHAR) ,
    hint_total INTEGER ,
    base_score NUMBER (2)
  ) ;
ALTER TABLE associations ADD CONSTRAINT associations_PK PRIMARY KEY ( id ) ;


CREATE TABLE associations_history
  (
    id              INTEGER NOT NULL ,
    hint_counter    INTEGER ,
    answered        INTEGER ,
    associations_id INTEGER NOT NULL ,
    User_id         INTEGER NOT NULL ,
    TIME            TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  ) ;
ALTER TABLE associations_history ADD CHECK ( answered IN (0, 1)) ;
ALTER TABLE associations_history ADD CONSTRAINT associations_history_PK PRIMARY KEY ( id ) ;


CREATE TABLE comments
  (
    id      INTEGER NOT NULL ,
    MESSAGE VARCHAR2 (500 CHAR) ,
    TIME    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    User_id INTEGER NOT NULL
  ) ;
ALTER TABLE comments ADD CONSTRAINT comments_PK PRIMARY KEY ( id ) ;


CREATE TABLE grammar_quiz
  (
    id         INTEGER NOT NULL ,
    answer     VARCHAR2 (10 CHAR) ,
    sentence   VARCHAR2 (200 CHAR) ,
    base_score NUMBER (2)
  ) ;
ALTER TABLE grammar_quiz ADD CONSTRAINT sentence_quiz_PK PRIMARY KEY ( id ) ;


CREATE TABLE grammar_quiz_history
  (
    id              INTEGER CONSTRAINT NNC_maze_historyv1_id NOT NULL ,
    answer          VARCHAR2 (100 CHAR) ,
    grammar_quiz_id INTEGER NOT NULL ,
    User_id         INTEGER NOT NULL ,
    TIME            TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  ) ;
ALTER TABLE grammar_quiz_history ADD CONSTRAINT maze_historyv1_PK PRIMARY KEY ( id ) ;


CREATE TABLE maze
  (
    id            INTEGER NOT NULL ,
    x_size        INTEGER ,
    y_size        INTEGER ,
    word          VARCHAR2 (100 CHAR) ,
    cell_size     INTEGER ,
    char_distance INTEGER ,
    base_score    NUMBER (2)
  ) ;
ALTER TABLE maze ADD CONSTRAINT maze_PK PRIMARY KEY ( id ) ;


CREATE TABLE maze_history
  (
    id      INTEGER NOT NULL ,
    maze_id INTEGER NOT NULL ,
    User_id INTEGER NOT NULL ,
    TIME    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  ) ;
ALTER TABLE maze_history ADD CONSTRAINT maze_history_PK PRIMARY KEY ( id ) ;


CREATE TABLE tasks
  ( id INTEGER NOT NULL , type VARCHAR2 (100)
  ) ;
ALTER TABLE tasks ADD CONSTRAINT tasks_PK PRIMARY KEY ( id ) ;


CREATE TABLE word_search
  (
    id         INTEGER NOT NULL ,
    answer     VARCHAR2 (100 CHAR) ,
    base_score NUMBER (2)
  ) ;
ALTER TABLE word_search ADD CONSTRAINT word_search_PK PRIMARY KEY ( id ) ;


CREATE TABLE word_search_history
  (
    id             INTEGER NOT NULL ,
    User_id        INTEGER NOT NULL ,
    word_search_id INTEGER NOT NULL ,
    TIME           TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  ) ;
ALTER TABLE word_search_history ADD CONSTRAINT word_search_history_PK PRIMARY KEY ( id ) ;


CREATE TABLE wrong_picture_history
  (
    id                    INTEGER NOT NULL ,
    wrong_picture_quiz_id INTEGER NOT NULL ,
    User_id               INTEGER NOT NULL ,
    TIME                  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  ) ;
ALTER TABLE wrong_picture_history ADD CONSTRAINT wrong_picture_history_PK PRIMARY KEY ( id ) ;


CREATE TABLE wrong_picture_quiz
  (
    id                    INTEGER NOT NULL ,
    answer_picture_number INTEGER ,
    img_1                 VARCHAR2 (100 CHAR) ,
    img_2                 VARCHAR2 (100 CHAR) ,
    img_3                 VARCHAR2 (100 CHAR) ,
    img_4                 VARCHAR2 (100 CHAR) ,
    base_score            NUMBER (2)
  ) ;
ALTER TABLE wrong_picture_quiz ADD CONSTRAINT wrong_picture_quiz_PK PRIMARY KEY ( id ) ;


ALTER TABLE "User" ADD CONSTRAINT User_tasks_FK FOREIGN KEY ( current_tasks_id ) REFERENCES tasks ( id ) ;

ALTER TABLE associations_history ADD CONSTRAINT associations_FK FOREIGN KEY ( associations_id ) REFERENCES associations ( id ) ;

ALTER TABLE comments ADD CONSTRAINT comments_User_FK FOREIGN KEY ( User_id ) REFERENCES "User" ( id ) ;

ALTER TABLE grammar_quiz_history ADD CONSTRAINT grammar_quiz_FK FOREIGN KEY ( grammar_quiz_id ) REFERENCES grammar_quiz ( id ) ;

ALTER TABLE maze_history ADD CONSTRAINT maze_history_User_FK FOREIGN KEY ( User_id ) REFERENCES "User" ( id ) ;

ALTER TABLE maze_history ADD CONSTRAINT maze_history_maze_FK FOREIGN KEY ( maze_id ) REFERENCES maze ( id ) ;

ALTER TABLE associations_history ADD CONSTRAINT user_FK FOREIGN KEY ( User_id ) REFERENCES "User" ( id ) ;

ALTER TABLE wrong_picture_history ADD CONSTRAINT user_FKv1 FOREIGN KEY ( User_id ) REFERENCES "User" ( id ) ;

ALTER TABLE grammar_quiz_history ADD CONSTRAINT user_FKv2 FOREIGN KEY ( User_id ) REFERENCES "User" ( id ) ;

ALTER TABLE word_search_history ADD CONSTRAINT user_FKv3 FOREIGN KEY ( User_id ) REFERENCES "User" ( id ) ;

ALTER TABLE word_search_history ADD CONSTRAINT word_search_FK FOREIGN KEY ( word_search_id ) REFERENCES word_search ( id ) ;

ALTER TABLE wrong_picture_history ADD CONSTRAINT wrong_picture_quiz_FK FOREIGN KEY ( wrong_picture_quiz_id ) REFERENCES wrong_picture_quiz ( id ) ;

CREATE SEQUENCE User_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER User_id_TRG BEFORE
  INSERT ON "User" FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := User_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE associations_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER associations_id_TRG BEFORE
  INSERT ON associations FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := associations_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE associations_history_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER associations_history_id_TRG BEFORE
  INSERT ON associations_history FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := associations_history_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE comments_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER comments_id_TRG BEFORE
  INSERT ON comments FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := comments_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE grammar_quiz_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER grammar_quiz_id_TRG BEFORE
  INSERT ON grammar_quiz FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := grammar_quiz_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE grammar_quiz_history_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER grammar_quiz_history_id_TRG BEFORE
  INSERT ON grammar_quiz_history FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := grammar_quiz_history_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE maze_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER maze_id_TRG BEFORE
  INSERT ON maze FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := maze_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE maze_history_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER maze_history_id_TRG BEFORE
  INSERT ON maze_history FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := maze_history_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE tasks_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER tasks_id_TRG BEFORE
  INSERT ON tasks FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := tasks_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE word_search_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER word_search_id_TRG BEFORE
  INSERT ON word_search FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := word_search_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE word_search_history_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER word_search_history_id_TRG BEFORE
  INSERT ON word_search_history FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := word_search_history_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE wrong_picture_history_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER wrong_picture_history_id_TRG BEFORE
  INSERT ON wrong_picture_history FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := wrong_picture_history_id_SEQ.NEXTVAL;
END;


CREATE SEQUENCE wrong_picture_quiz_id_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER wrong_picture_quiz_id_TRG BEFORE
  INSERT ON wrong_picture_quiz FOR EACH ROW WHEN (NEW.id IS NULL) BEGIN :NEW.id := wrong_picture_quiz_id_SEQ.NEXTVAL;
END;