# Fullstack App – Spring Boot + Next.js + PostgreSQL

This is a fullstack application using:

- ✅ **Spring Boot** (Java backend)
- ✅ **Next.js** (React frontend)
- ✅ **PostgreSQL** (database)

You can run it **entirely with Docker** or **run frontend/backend manually** if you prefer.

---

## 🚀 Quick Start (with Docker)

### ✅ Prerequisites
- [Docker](https://www.docker.com/products/docker-desktop) installed

### ▶️ Run Everything

```bash
docker-compose up --build
```

This will:
- Start PostgreSQL (port `5432`)
- Build and run Spring Boot app (port `8080`)
- Build and run Next.js frontend (port `3000`)

### 🌐 Access the App
- Frontend: [http://localhost:3000](http://localhost:3000)  
- Backend API: [http://localhost:8080](http://localhost:8080)  
- PostgreSQL: `localhost:5432`, DB = `esttly-db`, user = `user`, password = `password`

---

## 🧪 Local Run (without Docker)

### 1️⃣ PostgreSQL

Install and run PostgreSQL manually:

```sql
-- Connect using any client (e.g. psql, PgAdmin)
CREATE DATABASE esttly-db;
CREATE USER user WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE esttly-db TO user;
```

You may also need to allow connections in `pg_hba.conf` and listen on `localhost`.

---

### 2️⃣ Spring Boot (Backend)

#### Prerequisites:
- Java 17+
- Maven installed

#### Run:

```bash
cd backend
./mvnw spring-boot:run
```

Ensure your `application.properties` contains:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/esttly-db
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

---

### 3️⃣ Next.js (Frontend)

#### Prerequisites:
- Node.js `v22.16.0` (Recommended)
- npm or yarn

#### Run:

```bash
cd frontend
npm install
npm run dev
```

Make sure `.env.local` contains:

```env
NEXT_PUBLIC_API_URL=http://localhost:8080
```

---

## 🗃️ Initial Database Data

If the PostgreSQL database is **empty**, the backend will initialize it with the following sample clients:

```java
new Client("Derrar", "Othmane", "oth.derrar@gmail.com"),
new Client("Hjira", "Saad", "hjira@example.com")
```

---

## 📦 Project Structure

```
.
├── docker-compose.yml
├── backend/               # Spring Boot app
│   └── Dockerfile
├── frontend/              # Next.js app
│   └── Dockerfile
```

---

### ✅ Lancer les tests (Backend)

Pour exécuter les tests unitaires sur le backend Client-API :

```bash
cd backend
./mvnw test
```

Ou si Maven est installé globalement :

```bash
mvn test
```


---

## 🧼 Clean Up (Docker)

To stop and remove containers + volume:

```bash
docker-compose down -v
```

---

## 📬 Contact

Feel free to reach out to [oth.derrar@gmail.com](mailto:oth.derrar@gmail.com) for any questions or help setting this up.
