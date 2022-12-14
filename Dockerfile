FROM adoptopenjdk/openjdk11:jdk-11.0.16.1_1-slim

ENV APP_HOME=/opt/app

RUN mkdir -p $APP_HOME

WORKDIR $APP_HOME

COPY target/vehiclemanagement-*.jar api.jar
<<<<<<< HEAD

=======
>>>>>>> 2c321502a705a32f87ee45a4cd662cead248f1d8
EXPOSE 9090

ENTRYPOINT java -jar api.jar