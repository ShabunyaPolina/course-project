--liquibase formatted sql

--changeset ShabunyaPolina:create-libraries

CREATE TABLE libraries
(
    library_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users ON DELETE CASCADE UNIQUE NOT NULL,
    rating DOUBLE PRECISION
)

--rollback drop table libraries;