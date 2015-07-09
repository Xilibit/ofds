insert into root.fundraiser(FUNDRAISER_EMAIL,
                            FUNDRAISER_FIRST_NAME,
                            FUNDRAISER_LAST_NAME,
                            FUNDRAISER_DATE_OF_BIRTH,
                            FUNDRAISER_IS_ADMIN,
                            FUNDRAISER_PASSWORD,
                            FUNDRAISER_COUNTRY,
                            FUNDRAISER_CITY,
                            FUNDRAISER_STREET,
                            FUNDRAISER_INDEX) values
                            ('admin1@admin1.com',
                             'Admin',
                             'Admin',
                             '1962-09-23 03:23:34.234',
                              1,
                             '25f43b1486ad95a1398e3eeb3d83bc4010015fcc9bedb35b432e00298d5021f7',
                             'USA',
                             'NY',
                             'BR',
                             '11133');

insert into root.fundraiser(FUNDRAISER_EMAIL,
                            FUNDRAISER_FIRST_NAME,
                            FUNDRAISER_LAST_NAME,
                            FUNDRAISER_DATE_OF_BIRTH,
                            FUNDRAISER_IS_ADMIN,
                            FUNDRAISER_PASSWORD,
                            FUNDRAISER_COUNTRY,
                            FUNDRAISER_CITY,
                            FUNDRAISER_STREET,
                            FUNDRAISER_INDEX,
                            FUNDRAISER_WALLET) values
                            ('user1@user1.com',
                             'User',
                             'User',
                             '1962-09-23 03:23:34.234',
                              0,
                             '0a041b9462caa4a31bac3567e0b6e6fd9100787db2ab433d96f6d178cabfce90',
                             'USA',
                             'NY',
                             'BR',
                             '11122',
                              10000);

insert into root.charity(CHARITY_EMAIL,
                            CHARITY_NAME,
                            CHARITY_REGISTRY_NAME,
                            CHARITY_DATE_OF_ESTABLISHMENT,
                            CHARITY_SHORT_DESCRIPTION,
                            CHARITY_PASSWORD,
                            CHARITY_COUNTRY,
                            CHARITY_CITY,
                            CHARITY_STREET,
                            CHARITY_INDEX) values
                            ('charity1@charity1.com',
                             'Charity',
                             'CRT',
                             '1962-09-23 03:23:34.234',
                             'Info about Charity.',
                             '5d4d1d0bffd622a78b0f05ff6c72213b641d75aa3f3c15e0d21f7272d7604f67',
                             'USA',
                             'NY',
                             'BR',
                             '11122');

INSERT INTO root.GROUPS (GROUP_USER_ID)
VALUES ('user');
INSERT INTO root.GROUPS (GROUP_USER_ID)
VALUES ('admin');
INSERT INTO root.GROUPS (GROUP_USER_ID)
VALUES ('charity');

INSERT INTO root.FUNDRAISER_HAS_GROUPS (GROUPS_GROUP_ID,FUNDRAISER_FUNDRAISER_EMAIL)
VALUES (1,'user1@user1.com');
INSERT INTO root.FUNDRAISER_HAS_GROUPS (GROUPS_GROUP_ID,FUNDRAISER_FUNDRAISER_EMAIL)
VALUES (2,'admin1@admin1.com');
INSERT INTO root.CHARITY_HAS_GROUPS (GROUPS_GROUP_ID,CHARITY_CHARITY_EMAIL)
VALUES (3,'charity1@charity1.com');

insert into root.activity(idACTIVITY,
                            ACTIVITY_NAME,
                            ACTIVITY_SHORT_DESCRIPTION,
                            ACTIVITY_INSERT_TS,
                            ACTIVITY_TERMINATION_DATE,
                            FUNDRAISER_FUNDRAISER_EMAIL
                            ) values
                            (10,
                             'Activity1',
                             'Info about Activity',
                             '1962-09-23 03:23:34.234',
                             '1962-09-23 03:23:34.234',
                             'user1@user1.com');

insert into root.activity(idACTIVITY,
                            ACTIVITY_NAME,
                            ACTIVITY_SHORT_DESCRIPTION,
                            ACTIVITY_INSERT_TS,
                            ACTIVITY_TERMINATION_DATE
                            ) values
                            (20,
                             'Activity2',
                             'Info about Activity',
                             '1962-09-23 03:23:34.234',
                             '1962-09-23 03:23:34.234');

insert into root.activity(idACTIVITY,
                            ACTIVITY_NAME,
                            ACTIVITY_SHORT_DESCRIPTION,
                            ACTIVITY_INSERT_TS,
                            ACTIVITY_TERMINATION_DATE
                            ) values
                            (30,
                             'Activity3',
                             'Info about Activity',
                             '1962-09-23 03:23:34.234',
                             '2017-09-23 03:23:34.234');

insert into root.donation(idDONATION,
                            DONATION_AMOUNT,
                            DONATION_DATE
                            ) values
                            (10,
                             120,
                             '1962-09-23 03:23:34.234');
insert into root.donation(idDONATION,
                            DONATION_AMOUNT,
                            DONATION_DATE
                            ) values
                            (20,
                             130,
                             '1962-09-23 03:23:34.234');
insert into root.donation(idDONATION,
                            DONATION_AMOUNT,
                            DONATION_DATE
                            ) values
                            (30,
                             140,
                             '1962-09-23 03:23:34.234');

insert into root.cause(idCAUSE,
                            CAUSE_NAME,
                            CAUSE_SHORT_DESCRIPTION,
                            CAUSE_INSERT_TS,
                            CAUSE_TERMINATION_DATE
                            ) values
                            (10,
                             'Cause1',
                             'Info about Cause',
                             '1962-09-23 03:23:34.234',
                             '1962-09-23 03:23:34.234');

insert into root.cause(idCAUSE,
                            CAUSE_NAME,
                            CAUSE_SHORT_DESCRIPTION,
                            CAUSE_INSERT_TS,
                            CAUSE_TERMINATION_DATE
                            ) values
                            (20,
                             'Cause2',
                             'Info about Cause',
                             '1962-09-23 03:23:34.234',
                             '1962-09-23 03:23:34.234');

insert into root.cause(idCAUSE,
                            CAUSE_NAME,
                            CAUSE_SHORT_DESCRIPTION,
                            CAUSE_INSERT_TS,
                            CAUSE_TERMINATION_DATE
                            ) values
                            (30,
                             'Cause3',
                             'Info about Cause',
                             '1962-09-23 03:23:34.234',
                             '1962-09-23 03:23:34.234');