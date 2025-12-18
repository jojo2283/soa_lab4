plugins {
    java
    id("org.springframework.boot") version "3.4.6"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "backend films"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")


    implementation("jakarta.validation:jakarta.validation-api:3.1.1")
//    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
    implementation("org.hibernate.orm:hibernate-core:6.6.33.Final")
//    implementation("org.springframework.cloud:spring-cloud-starter-consul-discovery:4.2.2")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
