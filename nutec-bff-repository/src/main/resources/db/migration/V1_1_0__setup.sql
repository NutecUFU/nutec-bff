CREATE SEQUENCE customer_id_seq;
CREATE TABLE IF NOT EXISTS customer (
    id BIGINT PRIMARY KEY DEFAULT nextval('customer_id_seq'),
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

ALTER SEQUENCE customer_id_seq
OWNED BY customer.id;

CREATE SEQUENCE customer_info_id_seq;

CREATE TABLE IF NOT EXISTS customer_info (
    id BIGINT PRIMARY KEY DEFAULT nextval('customer_info_id_seq'),
    customer_id BIGINT NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    document_type VARCHAR(255),
    document_value VARCHAR(255),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

ALTER SEQUENCE customer_info_id_seq
OWNED BY customer_info.id;

CREATE SEQUENCE customer_social_network_id_seq;

CREATE TABLE IF NOT EXISTS customer_social_network (
    id BIGINT PRIMARY KEY DEFAULT nextval('customer_social_network_id_seq'),
    customer_info_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    url VARCHAR(512) NOT NULL,
    FOREIGN KEY (customer_info_id) REFERENCES customer_info (id)
);

ALTER SEQUENCE customer_social_network_id_seq
OWNED BY customer_social_network.id;