--liquibase formatted sql

--changeset ShabunyaPolina:create-cards

CREATE TABLE cards
(
    card_id BIGSERIAL PRIMARY KEY,
    module_id BIGINT REFERENCES modules ON DELETE CASCADE NOT NULL,
    term VARCHAR(256) NOT NULL,
    definition VARCHAR(256) NOT NULL,
    is_memorised BOOLEAN
  )

--rollback drop table cards;