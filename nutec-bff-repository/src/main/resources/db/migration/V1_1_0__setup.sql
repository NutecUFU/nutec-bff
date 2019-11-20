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

CREATE SEQUENCE experiment_id_seq;

CREATE TABLE IF NOT EXISTS experiment (
    id BIGINT PRIMARY KEY DEFAULT nextval('experiment_id_seq'),
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1800),
    url VARCHAR(512) NOT NULL,
    status VARCHAR(255) NOT NULL
);

ALTER SEQUENCE experiment_id_seq
OWNED BY experiment.id;

CREATE SEQUENCE privilege_id_seq;

CREATE TABLE IF NOT EXISTS privilege (
    id BIGINT PRIMARY KEY DEFAULT nextval('privilege_id_seq'),
    name VARCHAR(255) NOT NULL
);

ALTER SEQUENCE privilege_id_seq
OWNED BY privilege.id;

CREATE SEQUENCE role_id_seq;

CREATE TABLE IF NOT EXISTS role (
    id BIGINT PRIMARY KEY DEFAULT nextval('role_id_seq'),
    name VARCHAR(255) NOT NULL
);

ALTER SEQUENCE role_id_seq
OWNED BY role.id;

CREATE TABLE IF NOT EXISTS roles_privileges (
    role_id BIGINT NOT NULL,
    privilege_id BIGINT NOT NULL,
    UNIQUE(role_id, privilege_id),
    FOREIGN KEY (role_id) REFERENCES role (id),
    FOREIGN KEY (privilege_id) REFERENCES privilege (id)
);

CREATE TABLE IF NOT EXISTS customer_roles (
    customer_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    UNIQUE(customer_id, role_id),
    FOREIGN KEY (role_id) REFERENCES role (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);