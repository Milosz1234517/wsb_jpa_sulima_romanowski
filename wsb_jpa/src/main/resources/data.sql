--insert into address (id, address_line1, address_line2, city, postal_code)
--      values (901, 'xx', 'yy', 'city', '60-400');

INSERT INTO address (address_line1, address_line2, city, postal_code)
VALUES ('Jeden 5', '4', 'Łódź', '011-111'),
       ('Dwa 5', NULL, 'Kraków', '22-222'),
       ('Trzy 3', '1', 'Łódź', '33-333'),
       ('Cztery 7', NULL, 'Warszawa', '44-444'),
       ('Trzy1 3', '2', 'Łódź1', '33-334');

INSERT INTO doctor (address_id, doctor_number, email, first_name, last_name, telephone_number, specialization)
VALUES (1, '1', 'abc@gmail.com', 'Milosz', 'Romanowski', '123456789', 'GP'),
       (2, '2', 'efg@gmail.com', 'Bartosz', 'Sulima', '987654321', 'DERMATOLOGIST');


INSERT INTO patient (pesel, address_id, date_of_birth, email, first_name, last_name, patient_number, telephone_number)
VALUES (1,3, '1999-07-11', 'p1@gmail.com', 'Tadeusz', 'But', '1', '123456789'),
       (2,4, '1997-09-22', 'p2@gmail.com', 'Anna', 'Test', '2', '234567890'),
       (3,5, '1999-07-11', 'p3@gmail.com', 'Tadeusz1', 'But1', '3', '123456789');



INSERT INTO visit (doctor_id, patient_id, time, description)
VALUES (1, 1, '2025-03-20 11:00:00', 'Test'),
       (2, 2, '2025-01-21 15:30:00', 'Test 2');


INSERT INTO medical_treatment (visit_id, description, type)
VALUES (1, 'Badanie 1', 'EKG'),
       (2, 'Badanie 2', 'RTG');