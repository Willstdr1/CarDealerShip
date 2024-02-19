
INSERT INTO Supplier (id, phone_number, email, name  ) VALUES (1, '255010465', 'suplier@gmail.com', 'SuplierMain');


INSERT INTO Stand (id, Phone_Number, Supplier_Id, email_Adress, name) VALUES (1, '255090887', 1, 'ms@gmail.com',  'MainStand');


INSERT INTO Brand (id, name) VALUES (1, 'Opel');


INSERT INTO Vehicle_Model (brand_id, id, name) VALUES (1, 1, 'corsa');


INSERT INTO Vehicle (condition, fuel, id, model_id, number_of_doors, number_of_seats, stand_id, status, supplier_id, traction, type, color, license_plate) VALUES (0, 2, 1, 1, 4, 5, 1, 2, 1, 1, 1,'amarelo', 'AA-01-AA');
