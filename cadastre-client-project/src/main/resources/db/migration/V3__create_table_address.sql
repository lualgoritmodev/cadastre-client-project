CREATE TABLE tb_address (
    id_address UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    cep                VARCHAR(255) NOT NULL,
    neighborhood       VARCHAR(255) NOT NULL,
    road               VARCHAR(255) NOT NULL,
    city               VARCHAR(255) NOT NULL,
    number_residence   VARCHAR(255),
    ddd                VARCHAR(10) NOT NULL,
    uf                 VARCHAR(10),

    person_id UUID,

    CONSTRAINT fk_address_person
        FOREIGN KEY (person_id)
        REFERENCES tb_person(id_person)
        ON DELETE CASCADE
);
