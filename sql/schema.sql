DROP TABLE IF EXISTS user_profiles CASCADE;
CREATE TABLE user_profiles
(
    id SERIAL PRIMARY KEY,
    username VARCHAR(50),
    gender CHAR,
    topics INTEGER,
    photo_url VARCHAR(255)
);

DROP TABLE IF EXISTS messages CASCADE;
CREATE TABLE messages
(
    id INTEGER REFERENCES user_profiles(id),
    text VARCHAR(255),
    start_datetime TIMESTAMP,
    duration INTEGER
);

DROP TABLE IF EXISTS topics CASCADE;
CREATE TABLE topics
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

