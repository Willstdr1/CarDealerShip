
INSERT INTO Supplier (id, phone_number, email, name  ) VALUES (1, '255010465', 'suplier@gmail.com', 'SuplierMain');


INSERT INTO Stand (id, Phone_Number, Supplier_Id, email_Adress, name) VALUES (1, '255090887', 1, 'ms@gmail.com',  'MainStand');


INSERT INTO Brand (id, name) VALUES (1, 'Opel');
INSERT INTO Brand (id, name) VALUES (2, 'Renault');
INSERT INTO Brand (id, name) VALUES (3, 'Mercedes');
INSERT INTO Brand (id, name) VALUES (4, 'Audi');
INSERT INTO Brand (id, name) VALUES (5, 'KIA');

--brand_id - id - name
INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (1, 1, 'Corsa');
INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (1, 2, 'Astra');
INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (2, 3, 'Clio');
INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (2, 4, 'Espace');
INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (3, 5, 'Accelo');
INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (3, 6, 'Actros');
INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (4, 7, 'A3');
INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (4, 8, 'A4');
INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (5, 9, 'Besta');
INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (5, 10, 'Soul');


INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, transaction, type, color, license_plate) VALUES (0, 2, 1, 1, 4, 5, 1, 3, 1, 1, 0, 1,'white', '16-OE-61');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, transaction, type, color, license_plate) VALUES (0, 2, 2, 1, 4, 5, 1, 2, 1, 1, 0, 1,'black', '23-TT-34');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, transaction, type, color, license_plate) VALUES (0, 2, 3, 1, 4, 5, 1, 1, 1, 1, 0, 1,'yellow', '45-IE-87');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, transaction, type, color, license_plate) VALUES (0, 2, 4, 1, 4, 5, 1, 0, 1, 1, 0, 1,'green', '56-MA-12');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, transaction, type, color, license_plate) VALUES (0, 3, 10, 2, 5, 5, 1, 1, 1, 1, 0, 1, 'white', '53-AG-54');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, transaction, type, color, license_plate) VALUES (1, 1, 5, 1, 2, 2, 1, 2, 1, 2, 0, 2, 'black', '76-JH-78');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, transaction, type, color, license_plate) VALUES (1, 2, 7, 2, 3, 4, 1, 0, 1, 1, 0, 4, 'navyBlue', '16-RE-12');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, transaction, type, color, license_plate) VALUES (1, 1, 8, 3, 4, 4, 1, 2, 1, 2, 0, 5, 'gray', '87-KJ-23');

INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, transaction, type, color, license_plate) VALUES (1, 4, 6, 3, 4, 4, 1, 3, 1, 0, 0, 3, 'orange', '17-TY-23');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, transaction, type, color, license_plate) VALUES (0, 0, 9, 5, 2, 2, 1, 1, 1, 2, 0, 6, 'lime', '16-PO-32');