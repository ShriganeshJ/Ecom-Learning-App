plugins {
    id("java")
}
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


tasks.test {
    useJUnitPlatform()
}


repositories {
    mavenCentral()
}
dependencies {

    implementation ("org.springframework.boot:spring-boot-starter")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.2.0")
    // https://mvnrepository.com/artifact/org.redisson/redisson
    implementation("org.redisson:redisson:3.25.0")



}