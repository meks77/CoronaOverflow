create sequence hibernate_sequence;

create table LABELS
(
    ID   IDENTITY,
    NAME VARCHAR(50) UNIQUE
);

create table POSTS
(
    UUID       VARCHAR(50) PRIMARY KEY,
    USER_ID    VARCHAR(50),
    TITLE      VARCHAR(200),
    LABEL_ID   NUMERIC,
    CREATED    DATETIME,
    TEXT       CLOB,
    IMAGE_NAME VARCHAR(200),
    CONSTRAINT LABEL_FK FOREIGN KEY (LABEL_ID) REFERENCES LABELS (ID)
);

create index POSTS_LABEL_IXF on POSTS (LABEL_ID);

create table USERS (
  ID VARCHAR(50) PRIMARY KEY
);

create table VOTINGS (
    ID IDENTITY,
    USER_ID VARCHAR(50),
    POST_ID VARCHAR(50),
    VOTED VARCHAR(50),
    FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
    FOREIGN KEY (POST_ID) REFERENCES POSTS(UUID),
    UNIQUE (USER_ID, POST_ID)
);

create index VOTINGS_UK on VOTINGS (USER_ID, POST_ID);
create index VOTINGS_POSTS_IXF on VOTINGS (POST_ID);

