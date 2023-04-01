--liquibase formatted sql

--changeset ShabunyaPolina:create-users

CREATE TABLE users
(
    user_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    email VARCHAR(64) NOT NULL,
    password VARCHAR(64) NOT NULL,
    role VARCHAR(64) NOT NULL
)

--rollback drop table users;