CREATE TABLE "Pros"(
    "Profession" TEXT PRIMARY KEY NOT NULL,
    "Name" VARCHAR,
    "PhoneNumber" INT,
    "Email" VARCHAR,
    "Fee" INT
);

CREATE TABLE "User"(
    "UserId" INT NOT NULL,
    "UserName" VARCHAR NOT NULL,
    "UserEmail" VARCHAR NOT NULL,
    "UserPassword" VARCHAR NOT NULL,
    "UserCreditCard" INT NOT NULL,
    "UserPick" VARCHAR FOREIGN KEY NOT NULL

);

CREATE INDEX "IFK_ProPick" ON "User" ("Name");