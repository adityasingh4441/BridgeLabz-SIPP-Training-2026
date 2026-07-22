-- Use Case 1: Find Highest Confirmed Cases using INNER JOIN
-- Objective: Retrieve the country with the highest confirmed cases on a specific date.
SELECT c.country_name,
       cc.confirmed_cases,
       cc.date
FROM covid_cases cc
INNER JOIN countries c
    ON cc.country_id = c.country_id
WHERE cc.date = '2021-01-01'
ORDER BY cc.confirmed_cases DESC
LIMIT 1;

-- Use Case 2: Join COVID Deaths and Vaccination Data
-- Objective: Consolidate death counts and vaccination data for all countries.
SELECT d.country_id,
       c.country_name,
       d.total_deaths,
       v.vaccination_status
FROM covid_deaths d
LEFT JOIN covid_vaccines v
    ON d.country_id = v.country_id
LEFT JOIN countries c
    ON d.country_id = c.country_id
ORDER BY c.country_name;

-- Use Case 3: Analyze Deaths by Continent
-- Objective: Determine the total number of COVID deaths by continent.
SELECT cont.continent_name,
       SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN countries c
    ON cc.country_id = c.country_id
INNER JOIN continents cont
    ON c.continent_id = cont.continent_id
GROUP BY cont.continent_name
ORDER BY total_deaths DESC;

-- Use Case 4: Calculate Average New Deaths Per Day
-- Objective: Track the global trend of average daily COVID deaths.
SELECT date,
       AVG(new_deaths) AS avg_new_deaths
FROM covid_cases
GROUP BY date
ORDER BY date;

-- Use Case 5: Find Countries with Highest Infection Rates
-- Objective: Identify countries ranked by infection rate.
SELECT c.country_name,
       (cc.confirmed_cases / c.population) * 100 AS infection_rate
FROM covid_cases cc
INNER JOIN countries c
    ON cc.country_id = c.country_id
ORDER BY infection_rate DESC;
