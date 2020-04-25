insert into USERS values ('user1');
insert into USERS values ('user2');
insert into USERS values ('user3');
insert into USERS values ('user4');
insert into USERS values ('user5');
insert into USERS values ('user6');

insert into LABELS values (hibernate_sequence.nextval, 'Label X');
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


insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user1', 'postingUUID1', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user1', 'postingUUID2', 'DOWN');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user1', 'postingUUID3', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user2', 'postingUUID1', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user2', 'postingUUID2', 'DOWN');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user2', 'postingUUID3', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user3', 'postingUUID1', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user3', 'postingUUID2', 'DOWN');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user3', 'postingUUID3', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user4', 'postingUUID1', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user4', 'postingUUID2', 'DOWN');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user4', 'postingUUID3', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user5', 'postingUUID1', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user5', 'postingUUID2', 'DOWN');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user5', 'postingUUID3', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user6', 'postingUUID1', 'UP');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user6', 'postingUUID2', 'DOWN');
insert into VOTINGS (USER_ID, POST_ID, VOTED) values ( 'user6', 'postingUUID3', 'UP');