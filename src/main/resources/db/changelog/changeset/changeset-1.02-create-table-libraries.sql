--liquibase formatted sql

--changeset ShabunyaPolina:create-libraries

CREATE TABLE libraries
(
    libraries_id BIGSERIAL PRIMARY KEY,
    users_id BIGINT REFERENCES users ON DELETE CASCADE,
    rating DOUBLE PRECISION
)

--rollback drop table libraries;