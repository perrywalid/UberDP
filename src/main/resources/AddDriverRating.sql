-- Add new columns to the Driver table
--ALTER TABLE Driver
--ADD COLUMN numberOfTrips INTEGER DEFAULT 0;
--ALTER TABLE Driver
--ADD COLUMN totalRating REAL DEFAULT 0.0;
--ALTER TABLE Driver
--ADD COLUMN averageRating REAL DEFAULT 0.0;
--ALTER TABLE Trip
--    ADD COLUMN rating REAL DEFAULT 0.0;
ALTER TABLE Car
    ADD COLUMN driver_id INTEGER;
