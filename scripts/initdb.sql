CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE if not exists public.product (
	id uuid NOT NULL PRIMARY KEY,
	"name" varchar NOT NULL,
	description varchar NULL,
	purchasePrice number,
    stock smallint,
    created_at timestamptz NOT NULL DEFAULT now(),
    updated_at timestamptz NULL,
    CONSTRAINT id_pk PRIMARY KEY (id)
);


