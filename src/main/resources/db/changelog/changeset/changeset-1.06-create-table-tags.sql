--liquibase formatted sql

--changeset ShabunyaPolina:create-tags

CREATE TABLE tags
(
    tag_id BIGSERIAL PRIMARY KEY,
    value VARCHAR(32) NOT NULL
)

--rollback drop table tags;