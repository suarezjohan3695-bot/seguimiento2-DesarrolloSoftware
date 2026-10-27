FROM eclipse-temurin:17

WORKDIR /app

COPY src ./src
COPY data ./data

RUN javac src/biblioteca/java/Gestores/*.java src/biblioteca/java/Modelos/*.java src/biblioteca/java/Main/*.java

VOLUME /app/data

CMD ["java", "-cp", "src/biblioteca/java", "Main.Seguimiento2"]