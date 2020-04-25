insert into USERS values ('user1');
insert into USERS values ('user2');

insert into LABELS values (hibernate_sequence.nextval, 'LabelX');
insert into LABELS values (hibernate_sequence.nextval, 'LabelY');
insert into LABELS values (hibernate_sequence.nextval, 'LabelZ');

insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID1', 'user1', 'Posting 1 title', 1, CURRENT_TIMESTAMP(), 'Posting text 1');
insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID2', 'user1', 'Posting 2 title', 1, CURRENT_TIMESTAMP(), 'Posting text 2');
insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID3', 'user1', 'Posting 3 title', 1, CURRENT_TIMESTAMP(), 'Posting text 3');

insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID4', 'user1', 'Posting 4 title', 2, CURRENT_TIMESTAMP(), 'Posting text 1');
insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID5', 'user1', 'Posting 5 title', 2, CURRENT_TIMESTAMP(), 'Posting text 2');

insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID6', 'user1', 'Posting 6 title', 3, parsedatetime('17-09-2012 18:47:52', 'dd-MM-yyyy hh:mm:ss'), 'Posting text 6');