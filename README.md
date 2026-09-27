# Notes Service — REST API для заметок на Spring Boot + PostgreSQL

## 📋 Описание проекта

REST-сервис для управления заметками с полным CRUD, поиском по подстроке 
и валидацией входных данных. Реализован на Spring Boot с использованием 
Spring Data JPA, PostgreSQL и Swagger UI.

## 🎯 Цель

Отработать:
- Создание REST API на Spring Boot;
- Работу с Spring Data JPA и PostgreSQL;
- Валидацию через Jakarta Bean Validation;
- Регистронезависимый поиск по `title` и `content`;
- Транзакционность через `@Transactional`;
- Глобальную обработку ошибок через `@RestControllerAdvice`;
- Документацию API через Swagger UI;
- Запуск в Docker Compose.

## 🛠️ Используемые технологии

- Java 17+
- Spring Boot
- Spring Web MVC
- Spring Data JPA + Hibernate
- Jakarta Bean Validation
- Lombok
- Docker / Docker Compose
- Maven
