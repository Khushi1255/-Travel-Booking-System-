# ✈️ Travel Booking System 🏨

*A comprehensive microservices-based travel booking platform built with Spring Cloud and AngularJS.*  
This project demonstrates enterprise-level architecture using **Spring Boot**, **Spring Cloud**, **Netflix Eureka**, and **API Gateway**.

---

## 🏗️ System Architecture

The system follows a **microservices architecture pattern** with the following components:

### 🖥️ Backend Services

- **🛠 Config Server**: Centralized configuration management using Spring Cloud Config
- **🔍 Discovery Server**: Service discovery and registration with Netflix Eureka
- **🚪 API Gateway**: Single entry point for clients, using Spring Cloud Gateway
- **🏨 Hotel Service**: Manages hotel inventory and details
- **✈️ Flight Service**: Manages flight availability and bookings
- **📅 Booking Service**: Orchestrates the reservation process

### 🎨 Frontend Application

- **🌍 Travel Client**: AngularJS web application for end users

---

## 🛠 Technology Stack

### Backend 🚀
- ☕ Java 17
- 🌱 Spring Boot 3.2
- 🌩️ Spring Cloud (Config, Gateway, Eureka)
- 🗃️ Spring Data JPA
- 🛢️ MySQL Database
- 🔗 RESTful API Architecture

### Frontend 🎨
- 🖥️ HTML5/CSS3
- ⚛️ AngularJS 1.6.9
- 🎨 Bootstrap 3
- 📱 Responsive Design

---

## 🚀 Getting Started

### ✅ Prerequisites
- ☕ JDK 17+
- 🔧 Maven 3.8+
- 🛢️ MySQL 8.0+
- 🏗️ Git

### 📥 Clone the Repository

```bash
git clone https://github.com/jaimerocha/travel-booking-system.git
cd travel-booking-system
```

### 🗄 Database Setup

1. Create the MySQL database:
```bash
mysql -u root -p < database/viajes.sql
```

### 🚀 Running the Services

Start the services in the following order:

1️⃣ **Config Server**
```bash
cd backend/config-server
mvn spring-boot:run
```

2️⃣ **Discovery Server**
```bash
cd backend/discovery-server
mvn spring-boot:run
```

3️⃣ **Backend Services** (can be started in parallel)
```bash
cd backend/hotel-service
mvn spring-boot:run

cd backend/flight-service
mvn spring-boot:run

cd backend/booking-service
mvn spring-boot:run
```

4️⃣ **API Gateway**
```bash
cd backend/api-gateway
mvn spring-boot:run
```

5️⃣ **Frontend Application**
```bash
cd frontend/travel-client/public
python3 -m http.server 8080
```

This will make your frontend accessible at **[http://localhost:8080/reservas.html](http://localhost:8080/reservas.html)**.

>**💡 Note**: Opening HTML files directly from the file system (using `file:///` protocol) may cause AJAX requests to fail due to CORS restrictions. Always use a proper HTTP server like the one provided by Python.

---

## 🌐 Service URLs

| Service       | URL |
|--------------|----------------------------|
| **Config Server** | [http://localhost:8888](http://localhost:8888) |
| **Discovery Server (Eureka)** | [http://localhost:8761](http://localhost:8761) |
| **API Gateway** | [http://localhost:7000](http://localhost:7000) |
| **Hotel Service** | [http://localhost:8000](http://localhost:8000) |
| **Flight Service** | [http://localhost:9000](http://localhost:9000) |
| **Booking Service** | [http://localhost:10000](http://localhost:10000) |
| **Frontend** | [http://localhost:8080/reservas.html](http://localhost:8080/reservas.html) |

---

## 🏗️ Project Structure

```
travel-booking-system/
├── backend/                          # Backend services
│   ├── config-server/                # Configuration server
│   ├── discovery-server/             # Eureka discovery server
│   ├── api-gateway/                  # API Gateway
│   ├── hotel-service/                # Hotel service
│   ├── flight-service/               # Flight service
│   ├── booking-service/              # Booking service
├── frontend/                         # Frontend application
│   └── travel-client/                # AngularJS client
│       ├── public/                   # HTML files
│       │   ├── reservas.html         # Reservations view
│       │   └── nuevareserva.html     # New reservation view
│       └── .settings/                # Eclipse configuration
├── database/                         # Database scripts
│   └── viajes.sql                    # SQL schema and data
├── README.md                         # Project documentation
└── LICENSE                           # License file
```

---

## ⚙️ Configuration

The application uses **Spring Cloud Config** for centralized configuration management.  
Configuration files are stored in two locations:

1. **Local development**: `backend/config-server/src/main/resources/config/`
2. **Remote repository**: [GitHub Configuration Repo](https://github.com/jaimerocha/travel-config-repo)

To switch profiles, modify the `spring.profiles.active` property in the Config Server's `application.yml` or use:

```bash
--spring.profiles.active=git
```

---

## ❗ Troubleshooting

### 🔴 Common Issues

- **CORS Errors**: Ensure the API Gateway is correctly configured to allow cross-origin requests.
- **Connection Refused**: Make sure all services are running in the correct order.
- **Configuration Not Found**: Verify that the Config Server is running and configuration files exist.

### 🛠️ Fixing Config Server Issues

If you see **"Cannot execute request on any known server"**, follow these steps:

1️⃣ Check if the configuration files are correctly placed:
   - For native profile: in `backend/config-server/src/main/resources/config/`
   - For git profile: in the GitHub repository `travel-config-repo`
2️⃣ Verify that service names in the configuration files match the `spring.application.name` properties in each service.

---

## 🤝 Contributing

Contributions are welcome! 🎉  
Please feel free to submit a **Pull Request**.

---

## 📜 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## ✍️ Author

**Jaime Rocha**  
📌 [GitHub Profile](https://github.com/jaimerocha)
