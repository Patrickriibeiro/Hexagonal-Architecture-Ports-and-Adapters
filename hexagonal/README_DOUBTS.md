## 📦 Where to Place Custom Exceptions in Hexagonal Architecture

In a hexagonal (ports and adapters) architecture, the location of your custom exceptions depends on **what layer** they belong to. Below is a clean structure and guidelines to help you organize them properly.

---

### 🔶 1. Domain Exceptions

If the exception represents a **business rule violation**, it should be placed in the **domain layer**.

- 📁 **Package**: `com.yourproject.domain.exception`
- ✅ **Examples**:
  - `OutOfStockException`
  - `InvalidOrderException`

---

### 🔷 2. Application Exceptions

If the exception occurs during the execution of a **use case**, but is **not part of core domain logic**, place it in the **application layer**.

- 📁 **Package**: `com.yourproject.application.exception`
- ✅ **Examples**:
  - `EmailSendingFailedException`
  - `UserNotAuthenticatedException`

---

### 🔸 3. Adapter Exceptions

If the exception is related to a **specific technology or interface**, it should be placed in the **corresponding adapter** (e.g., persistence, web, API).

- 📁 **Packages**:
  - `com.yourproject.adapter.out.persistence.exception`
  - `com.yourproject.adapter.in.web.exception`
- ✅ **Examples**:
  - `DatabaseConnectionException`
  - `BadRequestException`

---

### 📁 Recommended Folder Structure

```text
com.yourproject
│
├── domain
│   └── exception
├── application
│   └── exception
├── adapter
│   ├── in
│   │   └── web
│   │       └── exception
│   └── out
│       └── persistence
│           └── exception

