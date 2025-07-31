plugins {
    // Apply the shared build logic from a convention plugin.
    // The shared code is located in `buildSrc/src/main/kotlin/kotlin-jvm.gradle.kts`.
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
    alias(libs.plugins.kotlinSpring)
    alias(libs.plugins.springBoot)
    alias(libs.plugins.springDependencyManagement)
    alias(libs.plugins.osdetectorPlugin)
}

dependencies {
    implementation(libs.kotlinReflect)
    implementation(libs.bundles.kotlinxEcosystem)
    if ("osx-aarch_64" == osdetector.classifier) {
        runtimeOnly("io.netty:netty-resolver-dns-native-macos:4.1.100.Final:osx-aarch_64")
    }
    implementation(libs.bundles.kotlinxCoroutinesReactor)
    implementation(libs.springBootStarterWebflux)
//    implementation(libs.bundles.springApiGateway)
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation(libs.springBootStartActuator)
    implementation(libs.kotlinLogging)

    testImplementation(libs.junit)
    testImplementation(kotlin("test"))
    testImplementation(libs.springBootStarterTest)
}

dependencyManagement {
    val springCloudTrainVersion = libs.versions.springCloudTrainVersion.get()
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudTrainVersion}")
    }
}

val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks
jar.enabled = false
jar.archiveBaseName.set("api-gateway")
bootJar.enabled = true
