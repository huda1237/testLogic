-- Table: sales.product_groups

-- DROP TABLE IF EXISTS sales.product_groups;

CREATE TABLE IF NOT EXISTS sales.product_groups
(
    group_id integer NOT NULL DEFAULT nextval('sales.product_groups_group_id_seq'::regclass),
    description text COLLATE pg_catalog."default",
    group_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT group_id_pkey PRIMARY KEY (group_id)
    )
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS sales.product_groups
    OWNER to postgres;






-- Table: sales.products

-- DROP TABLE IF EXISTS sales.products;

CREATE TABLE IF NOT EXISTS sales.products
(
    product_id integer NOT NULL DEFAULT nextval('sales.products_product_id_seq'::regclass),
    product_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    price numeric(11,2),
    group_id integer NOT NULL,
    CONSTRAINT product_id_pkey PRIMARY KEY (product_id),
    CONSTRAINT foreign_key_group FOREIGN KEY (group_id)
    REFERENCES sales.product_groups (group_id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE NO ACTION
    )
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS sales.products
    OWNER to postgres;


