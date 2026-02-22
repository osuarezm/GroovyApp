# Grails 3.3.0 + H2 - Books API

- Java 8
- Grails 3.3.x
- H2

## RUN
```bash
grails run-app
```

## Endpoints
- GET /health
- GET /books
- GET /books/{id}

## Filters + pagination
GET /books?title=code&author=martin&year=2008&max=5&offset=0&sort=title&order=asc
