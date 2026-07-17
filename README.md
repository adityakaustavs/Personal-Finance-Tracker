# Personal Finance Tracker

This workspace contains two intentionally separate applications:

- `backend-finance-tracker`: Spring Boot 3 / Java 17 REST API.
- `frontend-finance-tracker`: Angular application.

## Run the backend

Create or run MySQL, then set `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`, and a strong `JWT_SECRET` (at least 32 characters). From `backend-finance-tracker`, run `mvn spring-boot:run`.

## Run the frontend

From `frontend-finance-tracker`, run `npm install` and `npm start`. Open `http://localhost:4200`.
