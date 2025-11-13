CREATE TABLE tb_person (
    id_person UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(20) UNIQUE NOT NULL,
    date_of_birth DATE NOT NULL,
    genere VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    number_residence VARCHAR(20),
    email VARCHAR(255) UNIQUE NOT NULL,
    registration_date TIMESTAMP NOT NULL
);

ALTER TABLE tb_client_user ADD CONSTRAINT uc_tb_client_user_email UNIQUE(email);