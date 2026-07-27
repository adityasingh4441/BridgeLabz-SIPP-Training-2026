-- Session 6: Indexing & ACID Properties

-- Use Case 26: Create Indexes on Frequently Searched Columns
CREATE INDEX idx_covid_country_date ON covid_cases (country, date);
CREATE INDEX idx_covid_date ON covid_cases (date);

-- Use Case 27: Optimize Top 10 High Infection Rate Queries
-- Assumes infection_rate column exists in covid_cases.
CREATE INDEX idx_covid_infection_rate ON covid_cases (infection_rate, country);

-- Use Case 28: Analyze Query Execution Plans
-- Example complex query with join and filtering
EXPLAIN
SELECT c.country, c.date, v.vaccine_name, v.doses_distributed
FROM covid_cases c
JOIN vaccine_distribution v
    ON c.country = v.country AND c.date = v.date
WHERE c.country = 'India' AND c.date = '2024-01-01';

-- Use Case 29: Implement ACID Transaction for Vaccine Data
START TRANSACTION;

INSERT INTO vaccine_distribution (country, date, vaccine_name, doses_distributed)
VALUES ('India', '2024-01-01', 'Covaxin', 50000);

INSERT INTO vaccine_distribution (country, date, vaccine_name, doses_distributed)
VALUES ('India', '2024-01-01', 'Covishield', 70000);

COMMIT;

-- Example rollback version
-- START TRANSACTION;
-- INSERT INTO vaccine_distribution (country, date, vaccine_name, doses_distributed)
-- VALUES ('India', '2024-01-01', 'Sputnik', 30000);
-- INSERT INTO vaccine_distribution (country, date, vaccine_name, doses_distributed)
-- VALUES ('India', '2024-01-01', 'Covaxin', 50000);
-- ROLLBACK;

-- Use Case 30: Demonstrate Isolation Levels
-- Transaction 1: Dirty Read prevention
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;
SELECT * FROM covid_cases WHERE country = 'India';
COMMIT;

-- Transaction 2: Non-repeatable Read prevention
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
START TRANSACTION;
SELECT * FROM covid_cases WHERE country = 'India';
-- Another transaction may update rows here
SELECT * FROM covid_cases WHERE country = 'India';
COMMIT;

-- Transaction 3: Phantom Read prevention
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
START TRANSACTION;
SELECT * FROM covid_cases WHERE date = '2024-01-01';
-- Another transaction may insert rows here
SELECT * FROM covid_cases WHERE date = '2024-01-01';
COMMIT;
