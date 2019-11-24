CREATE SEQUENCE seq_authorities START 1;

CREATE TABLE authorities
(
    id bigint NOT NULL,
    creation_date timestamp without time zone,
    deletion_date timestamp without time zone,
    email character varying(100) NOT NULL,
    authority character varying(15) NOT NULL,
    CONSTRAINT authorities_pkey PRIMARY KEY (id)
);
