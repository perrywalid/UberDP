-- Employee table
CREATE TABLE Employee (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          name TEXT NOT NULL,
                          email TEXT UNIQUE NOT NULL,
                          password TEXT NOT NULL,
                          phone TEXT NOT NULL
);

-- Driver table
CREATE TABLE Driver (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        email TEXT UNIQUE NOT NULL,
                        password TEXT NOT NULL,
                        phone TEXT NOT NULL
);

-- Customer table
CREATE TABLE Customer (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          name TEXT NOT NULL,
                          email TEXT UNIQUE NOT NULL,
                          password TEXT NOT NULL,
                          phone TEXT NOT NULL
);

-- Car table
CREATE TABLE Car (
                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                     model TEXT NOT NULL,
                     plateNumber TEXT NOT NULL,
                     color TEXT NOT NULL
);

-- Complaint table
CREATE TABLE Complaint (
                           id INTEGER PRIMARY KEY AUTOINCREMENT,
                           customer_id INTEGER NOT NULL,
                           description TEXT NOT NULL,
                           FOREIGN KEY (customer_id) REFERENCES Customer(id)
);

-- Trip table
CREATE TABLE Trip (
                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                      customer_id INTEGER NOT NULL,
                      driver_id INTEGER,
                      pickupLocation TEXT NOT NULL,
                      dropoffLocation TEXT NOT NULL,
                      pickupTime TEXT NOT NULL,
                      distance REAL,
                      duration REAL,
                      isCompleted INTEGER DEFAULT 0,
                      fare REAL,
                      FOREIGN KEY (customer_id) REFERENCES Customer(id),
                      FOREIGN KEY (driver_id) REFERENCES Driver(id)
);

-- Linking table for the many-to-many relationship between Driver and Car
CREATE TABLE DriverCar (
                           driver_id INTEGER NOT NULL,
                           car_id INTEGER NOT NULL,
                           PRIMARY KEY (driver_id, car_id),
                           FOREIGN KEY (driver_id) REFERENCES Driver(id),
                           FOREIGN KEY (car_id) REFERENCES Car(id)
);
