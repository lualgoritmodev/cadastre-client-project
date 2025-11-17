CREATE TABLE tb_person (
    id_person UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    name               VARCHAR(255) NOT NULL,
    cpf                VARCHAR(20) NOT NULL UNIQUE,
    rg                 VARCHAR(20) NOT NULL,
    date_of_birth      DATE NOT NULL,
    genere             VARCHAR(50) NOT NULL,
    phone              VARCHAR(20) NOT NULL,
    cep                VARCHAR(20) NOT NULL,
    number_residence   VARCHAR(50),
    email              VARCHAR(255) NOT NULL UNIQUE,
    registration_date  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
