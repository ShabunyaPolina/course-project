--liquibase formatted sql

--changeset ShabunyaPolina:create-modules

CREATE TABLE modules
(
    module_id BIGSERIAL PRIMARY KEY,
    library_id BIGINT REFERENCES libraries ON DELETE CASCADE,
    name VARCHAR(64) NOT NULL,
    description VARCHAR(128)
)

--rollback drop table modules;