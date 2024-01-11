plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.apache.activemq/artemis-jms-client-all
    implementation("org.apache.activemq:artemis-jms-client-all:2.31.2")

}

tasks.test {
    useJUnitPlatform()
}