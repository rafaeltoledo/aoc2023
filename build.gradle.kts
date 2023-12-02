plugins {
  kotlin("jvm") version "1.9.21"
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.21")
  testImplementation("com.google.truth:truth:1.1.5")
  testImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")
}

tasks.test {
  useJUnitPlatform()
}

kotlin {
  jvmToolchain(17)
}
