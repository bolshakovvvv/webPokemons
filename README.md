
# Приложение для управления карточками Покемонов

Это приложение на базе Spring Boot для управления карточками Покемонов, построенное с использованием Docker и PostgreSQL.

## Возможности

- Управление карточками Покемонов (CRUD операции).
- Учет студентов, владельцев карточек Покемонов.
- Использование Flyway для миграций базы данных.
- API для получения информации о карточках Покемонов.
- Построено с использованием Spring Boot, PostgreSQL и Docker.

## Технологии

- **Spring Boot**: Фреймворк для создания приложения.
- **PostgreSQL**: База данных для хранения карточек Покемонов и информации о студентах.
- **Flyway**: Инструмент миграции базы данных для управления изменениями схемы.
- **Docker**: Контейнеризация приложения и базы данных.
- **Maven**: Система сборки для управления зависимостями и упаковки приложения.
- **Jackson**: Для обработки JSON и десериализации данных.
- **Docker Compose**: Для управления многоконтейнерными приложениями на Docker.

## Структура проекта

- `src/main/java`: Содержит исходный код приложения.
  - `kseoni.ch.pkmn.models`: Модели для карточек Покемонов и студентов.
  - `kseoni.ch.pkmn.repositories`: Репозитории для взаимодействия с базой данных.
  - `kseoni.ch.pkmn.services`: Бизнес-логика и сервисные слои.
  - `kseoni.ch.pkmn.entities`: Сущности JPA для взаимодействия с базой данных.
  - `kseoni.ch.pkmn.clients`: Внешний клиент API для получения изображений карточек Покемонов (по желанию).
- `src/main/resources`: Конфигурационные файлы и скрипты миграций базы данных.
  - `application.properties`: Конфигурация Spring Boot.
  - `db/migration`: Скрипты миграций базы данных для Flyway.

## Настройка

### Необходимые компоненты

Перед запуском приложения убедитесь, что на вашем компьютере установлены Docker и Docker Compose.

### Переменные окружения

- `DATABASE_URL`: Хост PostgreSQL базы данных (по умолчанию `localhost`).
- `POSTGRES_USER`: Имя пользователя базы данных (по умолчанию `postgres`).
- `POSTGRES_PASSWORD`: Пароль пользователя базы данных (по умолчанию `root`).

### Запуск приложения

1. Клонируйте репозиторий:

   ```bash
   git clone https://github.com/yourusername/pokemon-card-management.git
   cd pokemon-card-management
   ```

2. Соберите и запустите приложение с помощью Docker Compose:

   ```bash
   docker-compose up --build
   ```

   Это создаст:
   - Сборку приложения и его Docker-образ.
   - Запустит контейнер PostgreSQL базы данных.
   - Применит миграции базы данных с помощью Flyway.
   - Запустит контейнер Spring Boot приложения на порту `8080`.

3. Доступ к приложению:
   - API будет доступно по адресу `http://localhost:8080`.
   - Вы можете взаимодействовать с карточками Покемонов и информацией о студентах через REST API.

### Команды Docker

- Чтобы остановить приложение:

  ```bash
  docker-compose down
  ```

- Чтобы пересобрать приложение:

  ```bash
  docker-compose up --build
  ```

### Миграции базы данных

Flyway используется для применения миграций базы данных. Скрипты миграций находятся в папке `db/migration`. При запуске приложения Flyway автоматически применит все новые миграции к базе данных PostgreSQL.

### Пример API эндпоинтов

- **GET /cards**: Получить все карточки Покемонов.
- **GET /cards/{id}**: Получить карточку Покемона по ID.
- **GET /cards/by-name/{name}**: Получить карточки Покемонов по имени.
- **GET /cards/by-owner/{ownerId}**: Получить карточку по ID владельца.
- **POST /cards**: Создать новую карточку Покемона.
- **DELETE /cards/{id}**: Удалить карточку Покемона по ID.

- **GET /students**: Получить всех студентов.
- **GET /students/{id}**: Получить студента по ID.
- **POST /students**: Добавить нового студента.
- **DELETE /students/{id}**: Удалить студента по ID.

## Структура директорий

```
.
├── src
│   └── main
│       └── java
│           └── kseoni
│               └── ch
│                   └── pkmn
│                       ├── models
│                       ├── entities
│                       ├── repositories
│                       ├── services
│                       └── clients
├── src/main/resources
│   ├── application.properties
│   └── db
│       └── migration
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

## Схема базы данных

База данных содержит следующие таблицы:

- **cards**: Содержит информацию о карточках Покемонов.
- **students**: Содержит информацию о студентах.
