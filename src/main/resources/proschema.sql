CREATE TABLE "pros"(
    "proId" INT PRIMARY KEY NOT NULL,
    "name" VARCHAR,
    "profession" VARCHAR,
    "phoneNumber" VARCHAR,
    "email" VARCHAR,
    "fee" INT
);

CREATE TABLE "user"(
    "userId" INT NOT NULL,
    "userName" VARCHAR NOT NULL,
    "userEmail" VARCHAR NOT NULL,
    "userPassword" VARCHAR NOT NULL,
    "userCreditCard" INT NOT NULL,
    "userPick" VARCHAR NOT NULL,

    CONSTRAINT "PK_user" PRIMARY KEY ("userId"),
    CONSTRAINT "FK_userPickId" FOREIGN KEY ("userPick") REFERENCES "pros" ("proId") ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE "userPickId"(
    "userPick" INT NOT NULL

);

INSERT INTO "userPickId" FROM "userPick"

INSERT INTO "pros" VALUES (1, 'Scoota Sage', 'Engineer', '555-555-5555', 'SCOOTA_SAGE@GMAIL.COM', 300 );
INSERT INTO "pros" VALUES (2, 'Jason Allen', 'Musician', '555-555-5555', 'jallen@gmail.com', 500);

