# URL Shortener Application

A simple and modern URL Shortener web application built using **Spring Boot**, **PostgreSQL**, **HTML**, **CSS**, and **JavaScript**.

This project allows users to:

* Shorten long URLs
* Redirect using short URLs
* Store URL mappings in PostgreSQL
* View generated short links instantly

---

# 🚀 Tech Stack

## Backend

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Lombok

## Frontend

* HTML
* CSS
* JavaScript

## Database

* PostgreSQL

---

# 📁 Project Structure

```bash
url-shortener/
│
├── src/
│   ├── main/
│   │   ├── java/com/example/urlshortener/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── entity/
│   │   │   └── UrlShortenerApplication.java
│   │   │
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   │   ├── index.html
│   │   │   │   ├── style.css
│   │   │   │   └── script.js
│   │   │   └── application.properties
│
├── pom.xml
└── README.md
```

---

# ⚙️ Features

* Generate short URLs
* Redirect to original URLs
* Responsive UI
* PostgreSQL database integration
* REST API support
* Clean layered architecture

---

# 🛠️ Setup Instructions

## 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/url-shortener.git
cd url-shortener
```

---

## 2️⃣ Configure PostgreSQL

Create a PostgreSQL database:

```sql
CREATE DATABASE url_shortener;
```

---

## 3️⃣ Configure `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/url_shortener
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

---

# 📦 Required Dependencies

Add these dependencies in `pom.xml`:

```xml
<dependencies>

    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- PostgreSQL Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

</dependencies>
```

---

# ▶️ Run Application

## Using Maven

```bash
mvn spring-boot:run
```

Application will start on:

```bash
http://localhost:8080
```

---

# 🌐 API Endpoints

## Create Short URL

### POST `/shorten`

Request Body:

```json
{
  "originalUrl": "https://google.com"
}
```

Response:

```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```

---

## Redirect URL

### GET `/{shortCode}`

Example:

```bash
http://localhost:8080/abc123
```

Redirects to original URL.

---

# 💻 Frontend

The frontend is built using:

* HTML
* CSS
* Vanilla JavaScript

Features:

* Input long URL
* Generate short URL
* Copy shortened link
* Responsive design

---

# 🗄️ Database Table Example

| id | original_url | short_code |
| -- | ------------ | ---------- |
| 1  | google.com   | abc123     |

---

# 🔥 Future Improvements

* User authentication
* URL expiration
* Click analytics
* QR code generation
* Custom short URLs
* Redis caching

---

# 📸 Screenshots

## Home Page

```text
+-----------------------------------+
| Enter Long URL                    |
| [ https://example.com        ]    |
|                                   |
|        [ Shorten URL ]            |
|                                   |
| Short URL: http://localhost/...   |
+-----------------------------------+
```

---

# 🤝 Contributing

Pull requests are welcome.

For major changes:

1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push branch
5. Create Pull Request

---

# 📄 License

This project is licensed under the MIT License.

---

# 👨‍💻 Author

Developed using Spring Boot and PostgreSQL.
