--liquibase formatted sql

--changeset ShabunyaPolina:create-refreshment_stages

CREATE TABLE refreshment_stages
(
    refreshment_stage_id BIGSERIAL PRIMARY KEY,
    value VARCHAR(32) NOT NULL
)

--rollback drop table refreshment_stages;