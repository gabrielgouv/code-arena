CREATE SEQUENCE seq_challenges START 1;

CREATE TABLE challenges
(
    id bigint NOT NULL,
    creation_date timestamp without time zone,
    deletion_date timestamp without time zone,
    content text NOT NULL,
    difficult_level character varying(255) NOT NULL,
    rating real,
    title character varying(255) NOT NULL,
    author_id bigint,
    CONSTRAINT challenges_pkey PRIMARY KEY (id),
    CONSTRAINT author_fkey FOREIGN KEY (author_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);