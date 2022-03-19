CREATE TABLE "pros"(
    "proId" INT PRIMARY KEY NOT NULL,
    "name" VARCHAR,
    "profession" VARCHAR,
    "phoneNumber" VARCHAR,
    "email" VARCHAR,
    "fee" INT
);

CREATE TABLE "customer"(
    "userId" INT NOT NULL,
    "userName" VARCHAR NOT NULL,
    "userEmail" VARCHAR NOT NULL,
    "userPassword" VARCHAR NOT NULL,
    "userCreditCard" INTEGER NOT NULL,


    CONSTRAINT "PK_user1" PRIMARY KEY ("userId"),
    CONSTRAINT "FK_userPickId" FOREIGN KEY ("userId") REFERENCES "pros" ("proId") ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE "hired"(
    "proId" INT NOT NULL,
    "userId" INT NOT NULL,

    CONSTRAINT "FK_userPick" FOREIGN KEY ("userId") REFERENCES "pros"("proId")

);





INSERT INTO "pros" VALUES (1, 'Scoota Sage', 'Engineer', '555-555-5555', 'SCOOTA_SAGE@GMAIL.COM', 300 );
INSERT INTO "pros" VALUES (2, 'Jason Allen', 'Musician', '555-555-5555', 'jallen@gmail.com', 500);

