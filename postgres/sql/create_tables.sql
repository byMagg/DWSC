-- Creation of track table
CREATE TABLE IF NOT EXISTS track (
   id SERIAL PRIMARY KEY,
   name VARCHAR NOT NULL,
   year VARCHAR NOT NULL,
   artist VARCHAR NOT NULL,
   score VARCHAR,
   cover VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS comment (
  id SERIAL PRIMARY KEY,
  trackid INT NOT NULL,
  author TEXT NOT NULL,
  content TEXT NOT NULL,
  score INT NOT NULL,
  date TEXT NOT NULL,
  CONSTRAINT fk_track FOREIGN KEY(trackid) REFERENCES track(id)
);