CREATE TABLE users
(
    id bigint NOT NULL,
    creation_date timestamp without time zone,
    deletion_date timestamp without time zone,
    date_of_birth date NOT NULL,
    email character varying(100) NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    password character varying(30) NOT NULL,
    user_role character varying(32) NOT NULL DEFAULT 'USER'::character varying,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

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

CREATE TABLE users_favorite_challenges
(
    users_who_favorited_id bigint NOT NULL,
    favorite_challenges_id bigint NOT NULL,
    CONSTRAINT users_who_favorited_fkey FOREIGN KEY (users_who_favorited_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT favorite_challenges_fkey FOREIGN KEY (favorite_challenges_id)
        REFERENCES public.challenges (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);