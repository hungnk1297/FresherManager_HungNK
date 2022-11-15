-- To generate database

-- FRESHER
DROP TABLE IF EXISTS fresher;
CREATE TABLE fresher
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    deleted       BIT(1)       NOT NULL DEFAULT 0,
    created_on    datetime NULL,
    last_modified datetime NULL,
    name          VARCHAR(255) NOT NULL,
    dob           date         NOT NULL,
    address       VARCHAR(255) NULL,
    phone         VARCHAR(255) NULL,
    email         VARCHAR(255) NULL,
    CONSTRAINT pk_fresher PRIMARY KEY (id)
);

-- CENTER
DROP TABLE IF EXISTS center;
CREATE TABLE center
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    deleted       BIT(1)       NOT NULL DEFAULT 0,
    created_on    datetime NULL,
    last_modified datetime NULL,
    name          VARCHAR(255) NOT NULL,
    code          VARCHAR(255) NULL,
    dob           date         NOT NULL,
    address       VARCHAR(255) NOT NULL,
    CONSTRAINT pk_center PRIMARY KEY (id)
);

-- CENTER FRESHER
DROP TABLE IF EXISTS center_fresher;
CREATE TABLE center_fresher
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    deleted       BIT(1) NOT NULL DEFAULT 0,
    created_on    datetime NULL,
    last_modified datetime NULL,
    center_id     BIGINT NULL,
    fresher_id    BIGINT NULL,
    start_date    date NULL,
    end_date      date NULL,
    CONSTRAINT pk_center_fresher PRIMARY KEY (id)
);

ALTER TABLE center_fresher
    ADD CONSTRAINT FK_CENTER_FRESHER_ON_CENTER FOREIGN KEY (center_id) REFERENCES center (id);

ALTER TABLE center_fresher
    ADD CONSTRAINT FK_CENTER_FRESHER_ON_FRESHER FOREIGN KEY (fresher_id) REFERENCES fresher (id);

-- programming_language
DROP TABLE IF EXISTS programming_language;
CREATE TABLE programming_language
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    deleted       BIT(1)                NOT NULL DEFAULT 0,
    created_on    datetime              NULL,
    last_modified datetime              NULL,
    name          VARCHAR(255)          NOT NULL,
    `description` VARCHAR(255)          NULL,
    CONSTRAINT pk_programming_language PRIMARY KEY (id)
);

-- fresher_language
DROP TABLE IF EXISTS fresher_language;
CREATE TABLE fresher_language
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    deleted       BIT(1)                NOT NULL DEFAULT 0,
    created_on    datetime              NULL,
    last_modified datetime              NULL,
    language_id   BIGINT                NOT NULL,
    fresher_id    BIGINT                NOT NULL,
    CONSTRAINT pk_fresher_language PRIMARY KEY (id)
);

ALTER TABLE fresher_language
    ADD CONSTRAINT FK_FRESHER_LANGUAGE_ON_FRESHER FOREIGN KEY (fresher_id) REFERENCES fresher (id);

ALTER TABLE fresher_language
    ADD CONSTRAINT FK_FRESHER_LANGUAGE_ON_LANGUAGE FOREIGN KEY (language_id) REFERENCES programming_language (id);

-- assignment
DROP TABLE IF EXISTS assignment;
CREATE TABLE assignment
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    deleted       BIT(1)                NOT NULL DEFAULT 0,
    created_on    datetime              NULL,
    last_modified datetime              NULL,
    percentage    INT                   NOT NULL,
    `description` VARCHAR(255)          NULL,
    CONSTRAINT pk_assignment PRIMARY KEY (id)
);

-- assignment_score
DROP TABLE IF EXISTS assignment_score;
CREATE TABLE assignment_score
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    deleted       BIT(1)                NOT NULL DEFAULT 0,
    created_on    datetime              NULL,
    last_modified datetime              NULL,
    fresher_id    BIGINT                NOT NULL,
    assignment_id BIGINT                NOT NULL,
    score         INT                   NOT NULL,
    CONSTRAINT pk_assignment_score PRIMARY KEY (id)
);

ALTER TABLE assignment_score
    ADD CONSTRAINT FK_ASSIGNMENT_SCORE_ON_ASSIGNMENT FOREIGN KEY (assignment_id) REFERENCES assignment (id);

ALTER TABLE assignment_score
    ADD CONSTRAINT FK_ASSIGNMENT_SCORE_ON_FRESHER FOREIGN KEY (fresher_id) REFERENCES fresher (id);

