BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "ABONAMENT" (
	"abonament_id"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"client_id"	INTEGER,
	"tip" TEXT,
	"cu_antrenor"	INTEGER NOT NULL CHECK(cu_antrenor IN (0, 1)),
	"pret"	REAL NOT NULL,
	"durata" DATE,
    FOREIGN KEY("client_id") REFERENCES "CLIENT"("client_id")
);
CREATE TABLE IF NOT EXISTS "ANTRENOR" (
	"antrenor_id"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"nume"	TEXT NOT NULL,
	"prenume"	TEXT NOT NULL,
	"specializare"	TEXT,
	"parola"	TEXT NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS "CLIENT" (
	"client_id"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"nume"	TEXT NOT NULL,
	"prenume"	TEXT NOT NULL,
	"varsta"	NUMERIC NOT NULL,
	"abonament"	TEXT,
	"parola"	TEXT NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS "SESIUNE" (
	"sesiune_id" INTEGER PRIMARY KEY AUTOINCREMENT,
	"client_id"	INTEGER,
	"antrenor_id"	INTEGER,
	"data_sesiune"	DATE,
	FOREIGN KEY("antrenor_id") REFERENCES "ANTRENOR"("antrenor_id"),
    FOREIGN KEY("client_id") REFERENCES "CLIENT"("client_id")
);
COMMIT;
