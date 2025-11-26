CREATE TABLE role(
    id_role UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    `nome` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`id_role`)
);

INSERT INTO role(id, nome) VALUES (1, 'ROLE_ADMIN');