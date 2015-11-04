CREATE TABLE organisation (
  id_organisation INT PRIMARY KEY NOT NULL,
  name            TEXT            NOT NULL
);

CREATE TABLE role (
  id_role      INT PRIMARY KEY                               NOT NULL,
  organisation INT REFERENCES organisation (id_organisation) NOT NULL,
  name         TEXT                                          NOT NULL,
  description  TEXT
);

CREATE TABLE "user" (
  id_user  INT PRIMARY KEY               NOT NULL,
  role_id  INT REFERENCES role (id_role) NOT NULL,
  password TEXT                          NOT NULL,
  surname  TEXT                          NOT NULL,
  lastname TEXT                          NOT NULL,
  mail     TEXT                          NOT NULL
);

CREATE TABLE resource (
  id_resource     INT PRIMARY KEY                               NOT NULL,
  organisation_id INT REFERENCES organisation (id_organisation) NOT NULL,
  name            TEXT                                          NOT NULL
);

CREATE TABLE reservation (
  id_reservation INT PRIMARY KEY                         NOT NULL,
  resource_id    INT REFERENCES resource (id_resource)   NOT NULL,
  user_id        INT REFERENCES "user" (id_user)         NOT NULL,
  "from"         TIMESTAMP                               NOT NULL,
  "to"           TIMESTAMP                               NOT NULL,
  full_day       BOOLEAN                                 NOT NULL
);


CREATE TABLE timeframe (
  id_timeframe INT PRIMARY KEY NOT NULL,
  name         TEXT            NOT NULL,
  "start"      TIMESTAMP       NOT NULL,
  "end"        TIMESTAMP       NOT NULL
);

CREATE TABLE recursion (
  id_recursion   INT PRIMARY KEY NOT NULL,
  reservation_id INT REFERENCES reservation (id_reservation),
  day            INT,
  week           INT,
  month          INT
);

CREATE TABLE exclusion (
  id_exclusion INT PRIMARY KEY NOT NULL,
  recursion_id INT REFERENCES recursion (id_recursion),
  "date"       TIMESTAMP       NOT NULL
);


CREATE TABLE resourcetimeframe (
  resource_id  INT REFERENCES resource (id_resource)   NOT NULL,
  timeframe_id INT REFERENCES timeframe (id_timeframe) NOT NULL,
  PRIMARY KEY (resource_id, timeframe_id)
);


