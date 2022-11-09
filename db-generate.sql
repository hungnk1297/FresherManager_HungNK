-- To generate database
DROP TABLE IF EXISTS fresher;
CREATE TABLE fresher
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    deleted       BIT(1)       NOT NULL DEFAULT 0,
    created_on    datetime     NULL,
    last_modified datetime     NULL,
    name          VARCHAR(255) NOT NULL,
    dob           date         NOT NULL,
    address       VARCHAR(255) NOT NULL,
    phone         VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    CONSTRAINT pk_fresher PRIMARY KEY (id)
);
