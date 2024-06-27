FROM openjdk:17

WORKDIR /app

COPY . .
WORKDIR /app/src/main/java

RUN javac org/example/*.java

WORKDIR /app/src/main/java

CMD ["sh", "-c", "java -cp /app/src/main/java org.example.TowerDefenseGame && tail -f /dev/null"]
