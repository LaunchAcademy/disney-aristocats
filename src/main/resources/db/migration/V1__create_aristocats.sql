DROP TABLE IF EXISTS aristocats;

CREATE TABLE aristocats (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  photo_url VARCHAR(255) NOT NULL
);

INSERT INTO aristocats (first_name, last_name, photo_url) VALUES ('Thomas', 'O Malley', 'https://static.wikia.nocookie.net/disney-fan-fiction/images/f/f4/Thomasdisney.jpeg/revision/latest?cb=20140302135842');
INSERT INTO aristocats (first_name, last_name, photo_url) VALUES ('Duchess', 'Bonfamille', 'https://static.wikia.nocookie.net/disney/images/e/eb/Profile_-_Duchess.jpeg/revision/latest/scale-to-width-down/1032?cb=20190426050011');
