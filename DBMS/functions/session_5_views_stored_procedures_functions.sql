-- Session 5: Views, Stored Procedures & Functions
-- Use Case 21: Create View for Latest COVID Data
CREATE OR REPLACE VIEW latest_covid_summary AS
SELECT
    country,
    date,
    confirmed_cases,
    deaths,
    recoveries
FROM (
    SELECT
        c.country,
        c.date,
        c.confirmed_cases,
        c.deaths,
        c.recoveries,
        ROW_NUMBER() OVER (
            PARTITION BY c.country
            ORDER BY c.date DESC
        ) AS rn
    FROM covid_cases c
) ranked
WHERE rn = 1;

-- Use Case 22: Build Mortality Rate Function
DELIMITER //
CREATE FUNCTION CalculateMortalityRate(country_name VARCHAR(100), report_date DATE)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE mortality_rate DECIMAL(10,2);

    SELECT IFNULL((deaths / confirmed_cases) * 100, 0)
    INTO mortality_rate
    FROM covid_cases
    WHERE country = country_name AND date = report_date
    LIMIT 1;

    RETURN mortality_rate;
END //
DELIMITER ;

-- Use Case 23: Create Stored Procedure for Data Updates
DELIMITER //
CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_new_confirmed INT,
    IN p_new_deaths INT,
    IN p_new_recoveries INT
)
BEGIN
    UPDATE covid_cases
    SET confirmed_cases = p_new_confirmed,
        deaths = p_new_deaths,
        recoveries = p_new_recoveries
    WHERE country = p_country AND date = p_date;
END //
DELIMITER ;

-- Use Case 24: Implement Recovery Rate Function
DELIMITER //
CREATE FUNCTION CalculateRecoveryRate(country_name VARCHAR(100), report_date DATE)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE recovery_rate DECIMAL(10,2);

    SELECT IFNULL((recoveries / confirmed_cases) * 100, 0)
    INTO recovery_rate
    FROM covid_cases
    WHERE country = country_name AND date = report_date
    LIMIT 1;

    RETURN recovery_rate;
END //
DELIMITER ;

-- Use Case 25: Create Audit Trigger for Data Changes
CREATE TABLE IF NOT EXISTS covid_cases_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100),
    date DATE,
    old_confirmed_cases INT,
    new_confirmed_cases INT,
    old_deaths INT,
    new_deaths INT,
    old_recoveries INT,
    new_recoveries INT,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //
CREATE TRIGGER before_covid_cases_update
BEFORE UPDATE ON covid_cases
FOR EACH ROW
BEGIN
    INSERT INTO covid_cases_audit (
        country,
        date,
        old_confirmed_cases,
        new_confirmed_cases,
        old_deaths,
        new_deaths,
        old_recoveries,
        new_recoveries
    )
    VALUES (
        OLD.country,
        OLD.date,
        OLD.confirmed_cases,
        NEW.confirmed_cases,
        OLD.deaths,
        NEW.deaths,
        OLD.recoveries,
        NEW.recoveries
    );
END //
DELIMITER ;

-- Example usage
-- SELECT * FROM latest_covid_summary;
-- SELECT CalculateMortalityRate('India', '2024-01-01');
-- CALL UpdateCovidStats('India', '2024-01-01', 1000, 20, 900);
-- SELECT CalculateRecoveryRate('India', '2024-01-01');
