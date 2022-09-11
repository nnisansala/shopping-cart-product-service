FROM adoptopenjdk/openjdk13:jre-13.0.2_8

WORKDIR /opt/shopping-cart

COPY target/shopping-cart-product-service-1.0.0.jar /opt/shopping-cart/

EXPOSE 7070

ENTRYPOINT ["sh", "-c", "java $JVM_OPTS -jar shopping-cart-product-service-1.0.0.jar"]