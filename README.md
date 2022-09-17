Celem projektu było opracowanie prostej aplikacji aplikacji back-endowej w języku Java umożliwiającej dostęp i zarządzanie prostą bazą danych (CRUD).
Aplikacja została stworzona z użyciem biblioteki Spring Boot, dzięki której znacznie skrócił się proces tworzenia aplikacji.
Baza danych, w tym przypadku sklepu, oparta jest na 4 tabelach (clients, orders, details, products) została stworzona z użyciem oprogramowania MySQL Workbench.
Do API wykorzystałem darmową platformę Postman dzięki której możemy sprawnie zarządzać naszą bazą danych, wykonywać na niej podstawowe metody HTTP takie jak:
GET – pobranie wskazanego zasobu
POST – przesłanie danych do serwera 
PUT – przesłanie danych do serwera w celu zaktualizowania danych
DELETE – przesłanie żądania usunięcia danego zasobu
Za wdrożenie aplikacji odpowiedzialny jest Docker, jako najpopularniejszy system do konteneryzacji aplikacji 
Za przekazywanie i kolejkowanie naszych wiadomości odpowiedzialny jest RabbitMQ

W celu uruchomienia aplikacji należy pobrać aplikację z GitHub:
https://github.com/oskarmirocha/java-project-shop
następnie otworzyć terminal w katalogu projektu i kolejno wykonać polecenia:
docker pull mysql
docker run --name shoplibrary-mysql -e mysql_root_password=admin -d -p 3306:3306 mysql
docker run -d – hostname my-rabbit  -- name somerabbit -p 15672:15672 -p 5672:5672 rabbitmq:3management
java -jar shoplibrary-0.0.1-SNAPSHOT.jar

URL z którego korzystam lokalnie to: https://localhost:8080
