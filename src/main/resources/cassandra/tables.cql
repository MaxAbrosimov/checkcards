
CREATE TABLE IF NOT EXISTS some_keyspace.customer (
  id UUID PRIMARY KEY,
  firstname text,
  lastname text,
  email text
);

CREATE TABLE IF NOT EXISTS some_keyspace.place (
  id UUID PRIMARY KEY,
  name text,
  delimiter int,
);

CREATE TABLE IF NOT EXISTS some_keyspace.customer_check_cards (
  user_id UUID,
  place_id UUID,
  checkins int,
  delimeter int,
  style_id text,
  PRIMARY KEY (user_id, place_id)
);
