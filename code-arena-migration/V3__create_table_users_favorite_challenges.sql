CREATE TABLE user_favorite_challenges
(
    user_id bigint NOT NULL,
    challenge_id bigint NOT NULL,
    CONSTRAINT user_favorite_challenges_challenge_fkey FOREIGN KEY (challenge_id)
        REFERENCES challenges (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT user_favorite_challenges_user_fkey FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
