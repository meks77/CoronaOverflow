create table LABELS (
  ID IDENTITY,
  NAME VARCHAR(50) UNIQUE
);

create table POSTS (
                       ID VARCHAR(50) PRIMARY KEY,
                       USER_ID VARCHAR(50),
                       TITLE VARCHAR(200),
                       LABEL_ID NUMERIC,
                       TEXT CLOB,
                       VOTES_UP INT,
                       VOTES_DOWN INT,
                       CONSTRAINT LABEL_FK FOREIGN KEY (LABEL_ID) REFERENCES LABELS(ID)
);

create index POSTS_LABEL_IXF on POSTS(LABEL_ID);