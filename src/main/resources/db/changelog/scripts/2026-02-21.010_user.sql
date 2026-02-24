CREATE TABLE kafka.user
(
    id              bigserial primary key,
    name            varchar     NOT NULL,
    phone           varchar     NOT NULL,
    balance         varchar     NOT NULL,
    birthday        date        NOT NULL,
    create_at       timestamptz NOT NULL
);