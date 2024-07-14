# Cinestar - Online Cinema Ticket Booking Platform

Cinestar is a modern, user-friendly online platform for booking cinema tickets. Built with Spring Boot for the backend and Angular for the frontend, this application aims to provide a seamless movie-going experience.

## Key Features

- User authentication with role-based access control
- Social login integration (Google, Facebook)
- Advanced movie search functionality
- Interactive seat selection and booking system
- E-ticket generation and email delivery
- Administrative tools for managing movies, bookings, and promotions
- Performance analytics and reporting for cinema operators

## Tech Stack

- Backend: Spring Boot
- Frontend: Angular
- Database: PostgreSQL
- Authentication: Spring Security
- Testing: JUnit, Karma, Jasmine

## How to generate JWT keys
### Go the src/main/resources folder and run the following commands:
- mkdir certs && cd certs
- openssl genrsa -out keypair.pem 2048
- openssl rsa -in keypair.pem -pubout -out public.pem
- openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem