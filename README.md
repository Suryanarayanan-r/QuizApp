Here's a sample `README.md` file for your project, including the SQL commands for creating the `question` table and inserting sample data:

---

# QuizApp

QuizApp is a full-stack application developed using Spring Boot to manage quiz questions. The application provides CRUD (Create, Read, Update, Delete) operations for quiz questions, including functionalities to filter questions by category.

## Features

- **Create**: Add new quiz questions.
- **Read**: Retrieve all questions or filter by category.
- **Update**: Modify existing questions by their ID.
- **Delete**: Remove questions by their ID.
- **Validation**: Ensure data integrity with validation.
- **Exception Handling**: Handle exceptions gracefully.

## Technologies Used

- **Backend**: Java, Spring Boot, Spring Data JPA
- **Database**: PostgreSQL
- **Testing Tools**: Postman
- **Other Tools**: Lombok, Maven

## Setup Instructions

### Prerequisites

- Java 11 or higher
- Maven
- PostgreSQL
- IDE such as IntelliJ IDEA
- Postman (for testing APIs)

### Steps to Run the Application

1. **Clone the Repository**:
    ```sh
    git clone https://github.com/suryanarayanan-r/QuizApp.git
    cd quizapp
    ```

2. **Set Up the Database**:
    - Create a PostgreSQL database named `quizapp`.
    - Use the following SQL commands to create the `question` table and insert sample data:

    ```sql
    CREATE TABLE IF NOT EXISTS public.question
    (
        id integer NOT NULL DEFAULT nextval('question_id_seq'::regclass),
        category character varying(255),
        difficultylevel character varying(255),
        option1 character varying(255),
        option2 character varying(255),
        option3 character varying(255),
        option4 character varying(255),
        question_title character varying(255),
        right_answer character varying(255),
        CONSTRAINT question_pkey PRIMARY KEY (id)
    );

    INSERT INTO public.question (
        id, category, difficultylevel, option1, option2, option3, option4, question_title, right_answer
    )
    VALUES
        (1, 'Java', 'Easy', 'JVM', 'JRE', 'JDK', 'JIT', 'What does JRE stand for?', 'Java Runtime Environment'),
        (2, 'Java', 'Easy', 'Object-oriented', 'Platform-independent', 'Secure', 'All of the above', 'Which of the following are features of Java?', 'All of the above'),
        (3, 'Java', 'Easy', 'Specific to object', 'Independent of object', 'Assigns at runtime', 'None', 'What is the meaning of static?', 'Independent of object'),
        (4, 'Java', 'Easy', 'try', 'catch', 'finally', 'extends', 'Which block is used to run at anytime?', 'finally'),
        (5, 'Java', 'Easy', '+', '-', '*', '@', 'Which Java keyword is used to concatenate strings?', '+'),
        (6, 'Java', 'Easy', 'hashmap', 'ArrayList', 'Array', 'Linkedlist', 'Which class is an implementation of a dynamic array?', 'ArrayList'),
        (7, 'Java', 'Easy', 'try', 'catch', 'throw', 'throws', 'Which Java keyword is used to explicitly throw an exception?', 'throw'),
        (8, 'Java', 'Easy', 'terminate loop', 'throw exception', 'not a keyword', 'create thread', 'What is the use of break?', 'terminate loop'),
        (9, 'Java', 'Easy', 'for loop', 'while loop', 'do while', 'switch loop', 'Which loop in Java is executed at least once?', 'do while'),
        (10, 'Python', 'Easy', 'set', 'tuple', 'list', 'array', 'In Python, which datatype is mutable?', 'list'),
        (11, 'Python', 'Easy', 'numpy', 'date and time', 'sys', 'array', 'In Python, which module works with date and time?', 'date and time'),
        (12, 'Python', 'Easy', 'length()', 'len()', 'range()', 'add()', 'In Python, which function is used to calculate the length of a list?', 'len()');
    ```

3. **Configure Application Properties**:
    - Update `src/main/resources/application.properties` with your PostgreSQL database credentials:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/quizapp
    spring.datasource.username=your_db_username
    spring.datasource.password=your_db_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

4. **Run the Application**:
    - Open the project in IntelliJ IDEA.
    - Navigate to `QuizappApplication.java` and run the main method.

5. **Test the APIs**:
    - Use Postman to test the API endpoints.
    - Example endpoints:
        - Get all questions: `GET http://localhost:8080/question/allQuestions`
        - Get questions by category: `GET http://localhost:8080/question/category/{category}`
        - Add a question: `POST http://localhost:8080/question/add`
        - Update a question: `PUT http://localhost:8080/question/update/{id}`
        - Delete a question: `DELETE http://localhost:8080/question/delete/{id}`

## API Endpoints

- `GET /question/allQuestions`: Retrieve all questions.
- `GET /question/category/{category}`: Retrieve questions by category.
- `POST /question/add`: Add a new question.
- `PUT /question/update/{id}`: Update an existing question by ID.
- `DELETE /question/delete/{id}`: Delete a question by ID.
