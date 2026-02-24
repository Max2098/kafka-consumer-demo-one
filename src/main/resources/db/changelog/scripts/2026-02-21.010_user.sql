CREATE TABLE edo.request
(
    id             bigserial primary key,
    headers        jsonb       NOT NULL,
    request_time   timestamptz NOT NULL,
    source_service varchar     NOT NULL,
    call_id        varchar     NOT NULL,
    create_at      timestamptz NOT NULL DEFAULT CURRENT_TIMESTAMP
);