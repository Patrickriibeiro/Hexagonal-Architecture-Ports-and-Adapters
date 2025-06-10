# Hexagonal-Architecture-Ports-and-Adapters
Hexagonal Architecture in microservices using Java, Spring Boot, MongoDB, and Kafka.

## 📐 What is Hexagonal Architecture (Ports and Adapters)?

Hexagonal Architecture, also known as **Ports and Adapters**, is a software design pattern that aims to create loosely coupled application components. It promotes a clear separation between the **core business logic** (the "inside") and external concerns like databases, web frameworks, messaging systems, and APIs (the "outside").

### 🔑 Core Principles:

* **Isolation of Business Logic**: The core domain (application logic) is completely independent of external technologies.
* **Ports**: Define interfaces through which the application communicates with the outside world (e.g., input ports for use cases, output ports for dependencies like repositories).
* **Adapters**: Implement the ports to interact with specific technologies (e.g., a REST controller adapter, a Kafka listener, a MongoDB repository).
* **Inversion of Control**: The application core defines *what* it needs, and the infrastructure layer provides the *how*.
* **Testability**: Since the core is decoupled, it can be easily tested with mocks or stubs.

### 🧱 Structure:

```
         +-------------------------+
         |     External World      |
         | (UI, DB, Kafka, etc.)   |
         +-----------+-------------+
                     |
              [Adapters]
                     |
             +-------+--------+
             |     Ports      |
             +-------+--------+
                     |
              Application Core
          (Domain + Use Cases)
```

This architecture helps to make systems more **modular, maintainable, and adaptable to change**.




## ✅ Overview: Ports vs Adapters in Code

In **Hexagonal Architecture (Ports and Adapters)**, it's common to confuse the roles. Here's the correct mapping:

> **Ports** are the **interfaces**
> **Adapters** are the **implementations**

---

## 🧱 Practical Example

Let's say we have a simple microservice in Java using Spring Boot that handles users.

### 1. **Domain Layer (Core of the Application)**

#### `User.java` (Entity)

```java
public class User {
    private String id;
    private String name;
    // getters/setters
}
```

#### `UserService.java` (Use Case)

```java
public class UserService {
    private final UserRepositoryPort userRepository;

    public UserService(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}
```

---

### 2. **Ports (Interfaces)**

#### `UserRepositoryPort.java`

```java
public interface UserRepositoryPort {
    void save(User user);
}
```

This interface defines what the application *needs* — in this case, a way to persist users — but doesn't care how it's done.

---

## 🔌 Outbound Adapter (e.g., MongoDB)

### 3. **Infrastructure implementation of the port**

#### `MongoUserRepository.java`

```java
@Repository
public class MongoUserRepository implements UserRepositoryPort {

    private final SpringDataUserRepository repository;

    public MongoUserRepository(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        repository.save(user); // perform mapping if necessary
    }
}
```

#### `SpringDataUserRepository.java`

```java
public interface SpringDataUserRepository extends MongoRepository<User, String> {}
```

This is the adapter that connects the application core to the MongoDB database.

---

## 🎯 Inbound Adapter (e.g., REST Controller)

### 4. **Controller as an entry point**

#### `UserController.java`

```java
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }
}
```

The controller acts as an adapter for incoming HTTP requests.

---

## 📌 Summary Table

| Layer          | Role             | Type           | Example               |
| -------------- | ---------------- | -------------- | --------------------- |
| Core           | Port             | Interface      | `UserRepositoryPort`  |
| Infrastructure | Outbound Adapter | Implementation | `MongoUserRepository` |
| API            | Inbound Adapter  | Controller     | `UserController`      |

---




