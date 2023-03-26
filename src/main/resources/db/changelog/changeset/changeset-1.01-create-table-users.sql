--liquibase formatted sql

--changeset ShabunyaPolina:create-users

CREATE TABLE users
(
    user_id BIGSERIAL PRIMARY KEY
)

--rollback drop table users;