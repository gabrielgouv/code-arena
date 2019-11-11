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