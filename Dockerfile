FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /opt/shopping-cart

COPY target/shopping-cart-product-service-1.0.0.jar /opt/shopping-cart/

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JVM_OPTS -jar shopping-cart-product-service-1.0.0.jar"]