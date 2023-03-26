--liquibase formatted sql

--changeset ShabunyaPolina:create-cards

CREATE TABLE cards
(
    card_id BIGSERIAL PRIMARY KEY,
    module_id BIGINT REFERENCES modules ON DELETE CASCADE,
    term VARCHAR(256) NOT NULL,
    definition VARCHAR(256) NOT NULL,
    isMemorised BOOLEAN,
    refresh_time TIMESTAMP,
    refreshment_stage_id BIGINT REFERENCES refreshment_stages ON DELETE CASCADE
)

--rollback drop table cards;