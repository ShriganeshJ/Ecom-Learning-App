plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.0")
    implementation("org.springframework.boot:spring-boot-starter-jdbc:3.2.0")
    implementation("mysql:mysql-connector-java:8.0.28")

}

tasks.test {
    useJUnitPlatform()
}