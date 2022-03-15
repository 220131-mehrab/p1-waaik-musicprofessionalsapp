CREATE TABLE "pros"(
    "proid" INT PRIMARY KEY NOT NULL,
    "name" VARCHAR,
    "profession" VARCHAR,
    "phonenumber" VARCHAR,
    "email" VARCHAR,
    "fee" INT
);

CREATE TABLE "user"(
    "userid" INT NOT NULL,
    "username" VARCHAR NOT NULL,
    "useremail" VARCHAR NOT NULL,
    "userpassword" VARCHAR NOT NULL,
    "usercreditcard" INT NOT NULL,
    "userpick" VARCHAR NOT NULL,

    CONSTRAINT "PK_user" PRIMARY KEY ("userid"),
    CONSTRAINT "FK_userpickid" FOREIGN KEY ("userpick") REFERENCES "pros" ("proid") ON DELETE NO ACTION ON UPDATE NO ACTION
);




INSERT INTO "pros" VALUES (1, 'Scoota Sage', 'Engineer', '555-555-5555', 'SCOOTA_SAGE@GMAIL.COM', 300 );
INSERT INTO "pros" VALUES (2, 'Jason Allen', 'Musician', '555-555-5555', 'jallen@gmail.com', 500);

