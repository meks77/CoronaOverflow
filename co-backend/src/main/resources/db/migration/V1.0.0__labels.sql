create table LABELS (
  ID IDENTITY,
  NAME VARCHAR(50) UNIQUE
);

insert into LABELS (NAME) values ('LabelX');
insert into LABELS (NAME) values ('LabelY');
insert into LABELS (NAME) values ('LabelZ');