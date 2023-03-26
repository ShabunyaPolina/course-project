--liquibase formatted sql

--changeset ShabunyaPolina:create-modules_tags

CREATE TABLE modules_tags
(
    module_id BIGINT REFERENCES modules ON DELETE CASCADE,
    tag_id BIGINT REFERENCES tags ON DELETE CASCADE,
    constraint modules_tags_primary_key primary key (module_id, tag_id)
)

--rollback drop table modules_tags;