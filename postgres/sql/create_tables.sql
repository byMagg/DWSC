-- Creation of track table
CREATE TABLE IF NOT EXISTS track (
   id SERIAL PRIMARY KEY,
   name VARCHAR NOT NULL,
   year INT NOT NULL,
   score REAL,
   artist VARCHAR NOT NULL,
   cover VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS comment (
  id SERIAL PRIMARY KEY,
  trackid INT NOT NULL,
  author TEXT NOT NULL,
  content TEXT NOT NULL,
  score INT NOT NULL,
  date DATE DEFAULT CURRENT_DATE,
  CONSTRAINT fk_track FOREIGN KEY(trackid) REFERENCES track(id)
);