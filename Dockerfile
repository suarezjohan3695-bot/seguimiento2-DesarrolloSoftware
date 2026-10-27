FROM eclipse-temurin:17

WORKDIR /app

COPY src ./src

RUN javac biblioteca/Main/*.java

COPY data ./data

VOLUME /app/data

CMD ["java", "biblioteca.Main"]