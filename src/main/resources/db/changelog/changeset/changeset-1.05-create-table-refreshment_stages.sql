--liquibase formatted sql

--changeset gznznzjsn:create-refreshment_stages

CREATE TABLE refreshment_stages
(
    refreshment_stage_id BIGSERIAL PRIMARY KEY,
    "order" INTEGER NOT NULL UNIQUE,
    "interval" BIGINT NOT NULL
)

--rollback drop table refreshment_stages;