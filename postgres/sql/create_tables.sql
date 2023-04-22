-- Creation of track table
CREATE TABLE IF NOT EXISTS track (
   id SERIAL PRIMARY KEY,
   name VARCHAR,
   year VARCHAR,
   score VARCHAR,
   artist VARCHAR,
   cover VARCHAR
);