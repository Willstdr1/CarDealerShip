
INSERT INTO Supplier (id, phone_number, email, name  ) VALUES (1, '255010465', 'suplier@gmail.com', 'SuplierMain');


INSERT INTO Stand (id, Phone_Number, Supplier_Id, email_Adress, name) VALUES (1, '255090887', 1, 'ms@gmail.com',  'MainStand');


INSERT INTO Brand (id, name) VALUES (1, 'Opel');


INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (1, 1, 'Corsa');


INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, type, color, license_plate) VALUES (0, 2, 1, 1, 4, 5, 1, 3, 1, 1, 1,'white', '16-OE-61');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, type, color, license_plate) VALUES (0, 2, 2, 1, 4, 5, 1, 2, 1, 1, 1,'black', '23-TT-34');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, type, color, license_plate) VALUES (0, 2, 3, 1, 4, 5, 1, 1, 1, 1, 1,'yellow', '45-IE-87');
INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, type, color, license_plate) VALUES (0, 2, 4, 1, 4, 5, 1, 0, 1, 1, 1,'green', '56-MA-12');
