# Учебный проект по смежным дисциплинам "Виртуализация и контейнерезация", "Разработка и интеграция"

## Виртуализация и контейнерезация
Этот проект представляет собой эмуляцию защиты от CSRF-атак (Spring Security) в банковском приложении, состоящее из трех микросервисов:
1. **bank-frontend**: Фронтенд-сервис для взаимодействия с пользователем. 
2. **bank-api-service**: Основной сервис, обрабатывающий бизнес-логику.
3. **bank-auth-csrf-service**: Сервис для защиты от CSRF-атак.

Проект развёрнут с использованием Docker и Kubernetes (Minikube). 

#### 1. Установки Minikube и запуск
```bash
minikube start
```
#### 2. Построение Docker-образов
```bash
eval $(minikube docker-env)
```
Docker-образы для каждого сервиса:
```bash
docker build -t bank-frontend ./bank-frontend
docker build -t bank-api ./bank-api-service
docker build -t bank-csrf ./bank-auth-csrf-service
```
#### 3. Загрузка Docker-образов
```bash
minikube image load bank-api:latest
minikube image load bank-csrf:latest
minikube image load bank-frontend:latest
minikube image load postgres:15-alpine
```
#### 4. Деплой в Kubernetes
```bash
kubectl apply -f bank-api-deployment.yaml
kubectl apply -f bank-csrf-deployment.yaml
kubectl apply -f bank-frontend-deployment.yaml
kubectl apply -f db-deployment.yaml
```
#### 5. Проверка статуса подов и сервисов
```bash
kubectl get pods
kubectl get services
```
#### 6. Доступ к bank-frontend внутри Minikube
```bash
minikube service bank-frontend --url
```
#### 7. Внешний ip
```bash
minikube ip
```
## Разработка и интеграция
soon
