DROP TABLE food IF EXISTS;
CREATE TABLE IF NOT EXISTS food(id INTEGER IDENTITY PRIMARY KEY, name VARCHAR(255), imgurl VARCHAR(255), tag VARCHAR(255), done BOOLEAN );