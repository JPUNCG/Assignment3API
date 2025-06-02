# Assignment3API

## Description

Simple CRUD API for Animal Objects using Spring Boot and JPA (Hibernate).

### Version

1.0.0

## Installation

* Get the project

  * clone

    ```bash
    git clone https://github.com/JPUNCG/Assignment3API
    ```
  * OR download as a zip file.

* Open the project in VS Code or your preferred IDE.

* This project is built to run with JDK 21.

* Dependencies include Spring Web, JPA (Hibernate), and PostgreSQL.

* Configure your database connection in:
  [`/src/main/resources/application.properties`](./src/main/resources/application.properties)

  * You MUST have a PostgreSQL database running.

    * Login to your Neon.tech account (or your own database host).
    * Obtain your database connection string.
    * Set it as the value of `spring.datasource.url` in the properties file.

* Build and run the main class. A new `Animal` table should be created in the database.

## API Endpoints

Base URL: [`http://localhost:8080/animals`](http://localhost:8080/animals)

### 1. `GET /`

Returns a list of all animals in the database.

**Response:**

```json
[
  {
    "animal_id":"1",
    "description":"Sitting",
    "name":"pikachu",
    "source":"Tik Tok",
    "species":"Rosy-Faced Lovebird"
  },
  {
    "animal_id":"2",
    "description":"Forcefield Cat",
    "name":"Brother",
    "source":"Tumblr",
    "species":"Cat"
  }
]
```

### 2. `GET /{animalId}`

Returns a single animal by its ID.

**Path Variable:**

* `animalId` `<Long>` — REQUIRED

**Response:**

```json
{
  "animal_id":"2",
  "description":"Forcefield Cat",
  "name":"Brother",
  "source":"Tumblr",
  "species":"Cat"
}
```

### 3. `GET /name?search=substring`

Searches animals by name containing the given substring.

**Query Parameter:**

* `search` `<String>` — REQUIRED

**Response:**

```json
[
  {
    "animal_id":"2",
    "description":"Forcefield Cat",
    "name":"Brother",
    "source":"Tumblr",
    "species":"Cat"
  }
]
```

### 4. `GET /species/{species}`

Returns a list of animals matching a given species.

**Path Variable:**

* `species` `<String>` — REQUIRED

**Response:**

```json
[
  {
    "animal_id":"4",
    "description":"Forcefield Cat",
    "name":"Brother",
    "source":"Tumblr",
    "species":"Cat"
  },
  {
    "animal_id":"2",
    "name":"blinky",
    "description":"Cat waving!",
    "source":"twitter",
    "species":"Cat"
  }
]
```

### 5. `GET /source/{source}`

Returns a list of animals matching a given source.

**Path Variable:**

* `source` `<String>` — REQUIRED

**Response:**

```json
[
  {
    "animal_id":"3",
    "name":"Otter",
    "description":"Otter with a hat!",
    "source":"twitter",
    "species":"Otter"
  },
  {
    "animal_id":"2",
    "name":"blinky",
    "description":"Cat waving!",
    "source":"twitter",
    "species":"Cat"
  }
]
```

### 6. `POST /`

Creates a new animal.

**Request Body:**

```json
{
  "name":"blinky",
  "description":"Cat waving!",
  "source":"twitter",
  "species":"Cat"}
```

**Response:**

```json
{
  "animal_id":"2",
  "name":"blinky",
  "description":"Cat waving!",
  "source":"twitter",
  "species":"Cat"
}
```



### 7. `PUT /{animalId}`

Updates an existing animal.

**Path Variable:**

* `animalId` `<Long>` — REQUIRED

**Request Body:**

```json
{
  "animal_id":"4",
  "description":"Forcefield Cat",
  "name":"Brother",
  "source":"Tumblr",
  "species":"Cat"
}
```

**Response:**

```json
{
  "animal_id":"4",
  "description":"Forcefield Cat",
  "name":"Brother",
  "source":"Tumblr",
  "species":"Cat"
}
```



### 8. `DELETE /{animalId}`

Deletes an animal by ID.

**Path Variable:**

* `animalId` `<Long>` — REQUIRED

**Response:** Updated list of animals.

```json
[
  {
    "animal_id":"1",
    "description":"Forcefield Cat",
    "name":"Brother",
    "source":"Tumblr",
    "species":"Cat"
  },
  {
    "animal_id":"3",
    "name":"Otter",
    "description":"Otter with a hat!",
    "source":"twitter",
    "species":"Otter"
  }
]
```