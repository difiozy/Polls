#Запуск
Приложение построено на основе Spring Boot.

Для запуска данного приложения необходимо выполнить подключение в базе данных указав название подключения и данные 
авторизации в файле src/main/resources/application.properties

Далее необходимо запустить psvm метод в классе src/main/java/com/shurov/polls/Main.java

После первого запуска будет произведено создание сущностей в базе данных и приложение начнет свою работы

# Описание API

Все написаное API возвращает и принимает json файлы.
Модель данных была построена при помощи Spring Data

##Admin Quiz Controller
### GET /admin/quiz/{quizId}

Получение опроса по id


### POST /admin/quiz

Создание опроса

### PUT /admin/quiz

Обновление опроса

### DELETE /admin/quiz

Удаление опроса

##Admin Question Controller
###Get admin/{quizId}/question

Получение всех вопросов относящихся к опросу с id = quizId

###POST admin/{quizId}/question

Создание нового вопроса в опросе с id = quizId

###PUT admin/{quizId}/question

Обновление вопроса в данном опросе

###DELETE admin/{quizId}/question

Удаление вопроса


##User Controller
###GET user/allQuiz

Получение всех активных опросов на данный момент времени

### GET user/vote/{quizId}

Получение опроса с id = quizId

### GET user/vote/question/{questionId}

Получение вопроса по id

### GET user/vote/question/{questionId}/answers

Получение всех ответов на вопрос

### POST user//vote/question/{questionId}/type=text

Создать ответ на вопрос в тектовом формате

### POST user/vote/question/type=enumeration

Создать ответ на вопрос выбрать один или несколько вариантов ответов

### GET user/{userId}/textAns

Получить все текстовые ответы данного пользователя

### GET user/{userId}/chooseAns

Получить все ответы пользователя с вариантами ответов
