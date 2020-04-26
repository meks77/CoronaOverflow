insert into USERS values ('Kealan');
insert into USERS values ('Tiana');
insert into USERS values ('Camron');
insert into USERS values ('Alex');
insert into USERS values ('Mattie');
insert into USERS values ('Darin');
insert into USERS values ('WHO');

insert into LABELS values (hibernate_sequence.nextval, 'Masks');
insert into LABELS values (hibernate_sequence.nextval, 'Home Office');
insert into LABELS values (hibernate_sequence.nextval, 'Distance Learning');
insert into LABELS values (hibernate_sequence.nextval, 'WHO on Corona');

insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID1', 'Kealan', 'How to sew your own mask', 1, CURRENT_TIMESTAMP(), 'You need a cloth mask? Here is what to do: 1. take a piece of cloth and mark it according to the picture. 2. Cut the cloth and sew it together.');
insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID2', 'Tiana', 'Cleaning of masks possible?', 1, CURRENT_TIMESTAMP(), 'I wondered if masks can be cleaned? Here is what I found: cloth masks may be washed at high temperature in the washing machine. Disposable masks can be used again as long as they have not been wet.');
insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID3', 'Camron', 'The different types of masks', 1, CURRENT_TIMESTAMP(), 'There are many different types of masks around, this is a short overview. Masks have different amount of protection for the user but always protect others from droplets spread by the user.');

insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID4', 'Alex', 'How to set up a home workspace', 2, CURRENT_TIMESTAMP(), 'First of all, check your living space for suitable locations. Consider all the requirements you have. Do you need electricity or internet access?');
insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID5', 'Mattie', 'Accident in home office?', 2, CURRENT_TIMESTAMP(), 'Accidents that happen during working hours in home office are treated in various ways in different countries. These countries consider it a work accident with coverage by insurance: Austria, Belgium, Ghana.');

insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID6', 'Darin', 'The best tools for distance learning', 3, parsedatetime('17-09-2012 18:47:52', 'dd-MM-yyyy hh:mm:ss'), 'As a teacher I have come across many tools for home schooling and distance learning. This is a selection of free tools that I consider the most helpful.');

insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID7', 'WHO', 'About Coronavirus', 4, parsedatetime('17-09-2019 18:47:52', 'dd-MM-yyyy hh:mm:ss'), 'This is what you need to know about the virus and how to contain the spreading.');

insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID8', 'WHO', 'Protection from Coronavirus', 4, parsedatetime('17-09-2018 12:47:52', 'dd-MM-yyyy hh:mm:ss'), 'Measures you can take to protect yourself and others from an infection.');

insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID9', 'WHO', 'Corona Statistics', 4, parsedatetime('17-04-2020 13:47:52', 'dd-MM-yyyy hh:mm:ss'), 'Corona by country statistics of today.');

insert into POSTS (UUID, USER_ID, TITLE, LABEL_ID, CREATED, TEXT)
 values ( 'postingUUID10', 'WHO', 'Details for Medical Staff', 4, parsedatetime('11-03-2020 10:27:52', 'dd-MM-yyyy hh:mm:ss'), 'Medical staff information with focus on staying safe when working in hospitals or elderly care.');



insert into VOTINGS values (hibernate_sequence.nextval, 'Kealan', 'postingUUID1', 'UP');
insert into VOTINGS values (hibernate_sequence.nextval, 'Kealan', 'postingUUID2', 'DOWN');
insert into VOTINGS values (hibernate_sequence.nextval, 'Kealan', 'postingUUID3', 'DOWN');
insert into VOTINGS values (hibernate_sequence.nextval, 'Tiana', 'postingUUID1', 'UP');
insert into VOTINGS values (hibernate_sequence.nextval, 'Tiana', 'postingUUID2', 'UP');
insert into VOTINGS values (hibernate_sequence.nextval, 'Tiana', 'postingUUID3', 'DOWN');
insert into VOTINGS values (hibernate_sequence.nextval, 'Camron', 'postingUUID1', 'UP');
insert into VOTINGS values (hibernate_sequence.nextval, 'Camron', 'postingUUID2', 'DOWN');
insert into VOTINGS values (hibernate_sequence.nextval, 'Camron', 'postingUUID3', 'DOWN');
insert into VOTINGS values (hibernate_sequence.nextval, 'Alex', 'postingUUID1', 'UP');
insert into VOTINGS values (hibernate_sequence.nextval, 'Alex', 'postingUUID2', 'UP');
insert into VOTINGS values (hibernate_sequence.nextval, 'Alex', 'postingUUID3', 'UP');
insert into VOTINGS values (hibernate_sequence.nextval, 'Mattie', 'postingUUID1', 'UP');
insert into VOTINGS values (hibernate_sequence.nextval, 'Mattie', 'postingUUID2', 'DOWN');
insert into VOTINGS values (hibernate_sequence.nextval, 'Mattie', 'postingUUID3', 'DOWN');
insert into VOTINGS values (hibernate_sequence.nextval, 'Darin', 'postingUUID1', 'UP');
insert into VOTINGS values (hibernate_sequence.nextval, 'Darin', 'postingUUID2', 'DOWN');
insert into VOTINGS values (hibernate_sequence.nextval, 'Darin', 'postingUUID3', 'DOWN');