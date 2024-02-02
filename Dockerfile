FROM xldevops/jdk17-lts
COPY target/CHATGPT_SPRINGBOOT_WMICROSERVICE-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]