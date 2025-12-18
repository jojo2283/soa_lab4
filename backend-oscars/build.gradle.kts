plugins {
    java
    id("org.springframework.boot") version "3.5.5"
    id("io.spring.dependency-management") version "1.1.7"

}

group = "com.jellyone"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.7.0")

    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")

    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok:1.18.28")

    implementation("wsdl4j:wsdl4j:1.6.3")

    implementation("jakarta.xml.bind:jakarta.xml.bind-api")
    runtimeOnly("org.glassfish.jaxb:jaxb-runtime")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.rest-assured:rest-assured:5.4.0")
}


tasks.test {
    useJUnitPlatform()
}

//tasks.bootJar {
//    enabled = false
//}

//tasks.war {
//    archiveFileName.set("backend-oscars-0.0.1-SNAPSHOT.war")
//}

