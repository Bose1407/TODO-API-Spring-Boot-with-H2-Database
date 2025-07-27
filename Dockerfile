FROM ubuntu:22.04

# Install required dependencies
RUN apt-get update && apt-get install -y wget unzip git maven

# Install JDK 24 (early access)
RUN wget https://download.java.net/java/early_access/jdk24/XYZ/jdk-24_linux-x64_bin.tar.gz \
    && tar -xvf jdk-24_linux-x64_bin.tar.gz -C /opt \
    && ln -s /opt/jdk-24/bin/java /usr/bin/java \
    && ln -s /opt/jdk-24/bin/javac /usr/bin/javac

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
