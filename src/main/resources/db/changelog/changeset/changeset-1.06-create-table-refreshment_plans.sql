--liquibase formatted sql

--changeset gznznzjsn:create-refreshment_plans

CREATE TABLE refreshment_plans
(
    refreshment_plan_id BIGSERIAL PRIMARY KEY,
    card_id BIGINT REFERENCES cards ON DELETE CASCADE NOT NULL UNIQUE,
    refresh_time TIMESTAMP,
    refreshment_stage_id BIGINT REFERENCES refreshment_stages ON DELETE CASCADE NOT NULL
)

--rollback drop table refreshment_plans;