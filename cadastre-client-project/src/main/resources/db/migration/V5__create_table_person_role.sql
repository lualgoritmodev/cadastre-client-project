CREATE TABLE person_role(
    id_person_role UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    person_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person (id_person),
    FOREIGN KEY (role_id) REFERENCES role (id_role)
);

INSERT INTO person_role(person_id, role_id) VALUES (1, 1);