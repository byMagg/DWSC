-- Creation of track table
CREATE TABLE IF NOT EXISTS track (
   id SERIAL PRIMARY KEY,
   name VARCHAR,
   year VARCHAR,
   score VARCHAR,
   artist VARCHAR,
   cover VARCHAR
);

CREATE TABLE IF NOT EXISTS comment (
  id SERIAL PRIMARY KEY,
  track_id INT NOT NULL,
  author TEXT NOT NULL,
  content TEXT NOT NULL,
  date TEXT NOT NULL,
  CONSTRAINT fk_track FOREIGN KEY(track_id) REFERENCES track(id)
)