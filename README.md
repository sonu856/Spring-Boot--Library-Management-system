# Book Library Management System

Welcome to the Book Library Management System! This system allows you to manage books, authors, and rentals in a library setting.

## Getting Started

To use the Book Library Management System, follow the instructions below:

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/your_username/library-management-system.git
    ```

2. **Navigate to the Project Directory:**

    ```bash
    cd library-management-system
    ```

3. **Build and Run the Application:**

    - Ensure that you have Java and Maven installed on your system.
    - Build the project using Maven:

      ```bash
      mvn clean package
      ```

    - Run the application:

      ```bash
      java -jar target/library-management-system.jar
      ```

4. **Access the Application:**

    The application will be accessible at [http://localhost:8080](http://localhost:8080).

## Endpoints

### Authors Endpoints

#### Create an Author

Create a new author.

- **Method:** POST
- **URL:** [http://localhost:8080/api/authors](http://localhost:8080/api/authors)
- **Request Body:**
  ```json
  {
    "name": "F. Scott Fitzgerald",
    "biography": "American novelist and short story writer"
  }
  ```

#### Get All Authors

Retrieve a list of all authors.

- **Method:** GET
- **URL:** [http://localhost:8080/api/authors](http://localhost:8080/api/authors)

#### Get an Author by ID

Retrieve an author by their ID.

- **Method:** GET
- **URL:** [http://localhost:8080/api/authors/{id}](http://localhost:8080/api/authors/{id})

#### Update an Author

Update an existing author.

- **Method:** PUT
- **URL:** [http://localhost:8080/api/authors/{id}](http://localhost:8080/api/authors/{id})
- **Request Body:**
  ```json
  {
    "name": "F. Scott Fitzgerald (Updated)",
    "biography": "American novelist and short story writer"
  }
  ```

#### Delete an Author

Delete an author by their ID.

- **Method:** DELETE
- **URL:** [http://localhost:8080/api/authors/{id}](http://localhost:8080/api/authors/{id})

### Books Endpoints

#### Create a Book

Create a new book.

- **Method:** POST
- **URL:** [http://localhost:8080/api/books](http://localhost:8080/api/books)
- **Request Body:**
  ```json
  {
    "title": "The Great Gatsby",
    "author": {
      "id": 1
    },
    "isbn": "9780743273565",
    "publicationYear": 1925
  }
  ```

#### Get All Books

Retrieve a list of all books.

- **Method:** GET
- **URL:** [http://localhost:8080/api/books](http://localhost:8080/api/books)

#### Get a Book by ID

Retrieve a book by its ID.

- **Method:** GET
- **URL:** [http://localhost:8080/api/books/{id}](http://localhost:8080/api/books/{id})

#### Update a Book

Update an existing book.

- **Method:** PUT
- **URL:** [http://localhost:8080/api/books/{id}](http://localhost:8080/api/books/{id})
- **Request Body:**
  ```json
  {
    "title": "The Great Gatsby (Updated)",
    "author": {
      "id": 1
    },
    "isbn": "9780743273565",
    "publicationYear": 1925
  }
  ```

#### Delete a Book

Delete a book by its ID.

- **Method:** DELETE
- **URL:** [http://localhost:8080/api/books/{id}](http://localhost:8080/api/books/{id})

#### Get Books by Author

Retrieve a list of books by a specific author.

- **Method:** GET
- **URL:** [http://localhost:8080/api/books/author/{authorId}](http://localhost:8080/api/books/author/{authorId})

#### Get Available Books

Retrieve a list of available books.

- **Method:** GET
- **URL:** [http://localhost:8080/api/books/available](http://localhost:8080/api/books/available)

#### Get Rented Books

Retrieve a list of rented books.

- **Method:** GET
- **URL:** [http://localhost:8080/api/books/rented](http://localhost:8080/api/books/rented)

### Rentals Endpoints

#### Create a Rental

Create a new rental for a book.

- **Method:** POST
- **URL:** [http://localhost:8080/api/rentals](http://localhost:8080/api/rentals)
- **Request Body:**
  ```json
  {
    "bookId": 1,
    "renterName": "John Doe"
  }
  ```

#### Get All Rentals

Retrieve a list of all rentals.

- **Method:** GET
- **URL:** [http://localhost:8080/api/rentals](http://localhost:8080/api/rentals)

#### Get Overdue Rentals

Retrieve a list of overdue rentals.

- **Method:** GET
- **URL:** [http://localhost:8080/api/rentals/overdue](http://localhost:8080/api/rentals/overdue)

#### Return a Book

Return a rented book.

- **Method:** PUT
- **URL:** [http://localhost:8080/api/rentals/{rentalId}/return](http://localhost:8080/api/rentals/{rentalId}/return)

## Testing

You can use a tool like Postman, cURL, or any HTTP client to send these requests to your Spring Boot application running locally on http://localhost:8080.
