
ALTER TABLE challenges
    ADD input_format text NOT NULL,
    ADD constraints text NOT NULL,
    ADD output_format text NOT NULL,
    ADD test_cases text NOT NULL,
    ADD test_expectation text NOT NULL