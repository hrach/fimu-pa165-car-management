INSERT INTO PA165.SERVICETYPE ("NAME") 
	VALUES ('STK');

INSERT INTO PA165.SERVICETYPE ("NAME") 
	VALUES ('Vymena oleje');

INSERT INTO PA165.SERVICETYPE ("NAME") 
	VALUES ('Servisni prohlidka');

INSERT INTO PA165.VEHICLETYPE (MAXKM, "NAME") 
	VALUES (100000, 'Trida A');

INSERT INTO PA165.VEHICLETYPE (MAXKM, "NAME") 
	VALUES (500000, 'Trida B');

INSERT INTO PA165.EMPLOYEE (EMPLOYEEROLE, FAMILYNAME, FIRSTNAME, PASSWORD, USERNAME) 
	VALUES (2, 'Boss', 'Joe', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'admin');

INSERT INTO PA165.EMPLOYEE (EMPLOYEEROLE, FAMILYNAME, FIRSTNAME, PASSWORD, USERNAME) 
	VALUES (1, 'Novak', 'Adam', '0e18f44c1fec03ec4083422cb58ba6a09ac4fb2a', 'adam');

INSERT INTO PA165.EMPLOYEE (EMPLOYEEROLE, FAMILYNAME, FIRSTNAME, PASSWORD, USERNAME) 
	VALUES (1, 'Pracovity', 'Eduard', '9f5b2e4c02a063822535af58fedb94550ecc79cc', 'eda');

INSERT INTO PA165.VEHICLE ("NAME", VIN,CONSTRUCTIONYEAR, FUEL, REGISTRATIONPLATE,TACHOMETER,TYPE_ID)
        VALUES ('Trabant 601', '1122334455', 1985, 1, '1a11111', 854752, 2); 

INSERT INTO PA165.VEHICLE ("NAME", VIN,CONSTRUCTIONYEAR, FUEL, REGISTRATIONPLATE,TACHOMETER,TYPE_ID)
        VALUES ('Skoda Octavia 1.9 TDI', '11266994455', 1985, 1, '1B32349', 190500, 2); 

INSERT INTO PA165.VEHICLE ("NAME", VIN,CONSTRUCTIONYEAR, FUEL, REGISTRATIONPLATE,TACHOMETER,TYPE_ID)
        VALUES ('Audi A4 Allroad', '11266334455', 1985, 1, '1B22221', 70500, 1); 


INSERT INTO PA165.RIDE (STARTTIME, ENDTIME, TACHOMETERSTART, TACHOMETEREND, DESCRIPTION, EMPLOYEE_ID, VEHICLE_ID)
        VALUES ('2014-01-02', '2014-01-03', 14562, 14592, 'Cesta z mesta pro Boss', 1, 3);

INSERT INTO PA165.RIDE (STARTTIME, ENDTIME, TACHOMETERSTART, TACHOMETEREND, DESCRIPTION, EMPLOYEE_ID, VEHICLE_ID)
        VALUES ('2014-01-04', '2014-01-05', 120233, 120923, 'Cesta do mesta pro Novak', 2, 2);