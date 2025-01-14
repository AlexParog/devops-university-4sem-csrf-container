# Используем легковесный образ Nginx для статического контента
FROM nginx:alpine
# Копируем файлы HTML/JS/CSS в корневую директорию Nginx
COPY ./index.html /usr/share/nginx/html/index.html
COPY ./ /usr/share/nginx/html/

EXPOSE 80
