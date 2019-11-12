CREATE SEQUENCE seq_users START 1;

CREATE TABLE users
(
    id bigint NOT NULL,
    creation_date timestamp without time zone,
    deletion_date timestamp without time zone,
    date_of_birth date NOT NULL,
    email character varying(100) NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    user_role character varying(32) NOT NULL DEFAULT 'USER'::character varying,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);
