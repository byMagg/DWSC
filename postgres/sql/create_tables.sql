-- Creation of track table
CREATE TABLE IF NOT EXISTS track (
   id SERIAL PRIMARY KEY,
   name VARCHAR NOT NULL,
   year VARCHAR NOT NULL,
   score VARCHAR,
   artist VARCHAR NOT NULL,
   cover VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS comment (
  id SERIAL PRIMARY KEY,
  track_id INT NOT NULL,
  author TEXT NOT NULL,
  content TEXT NOT NULL,
  score INT NOT NULL,
  date TEXT NOT NULL,
  CONSTRAINT fk_track FOREIGN KEY(track_id) REFERENCES track(id)
);