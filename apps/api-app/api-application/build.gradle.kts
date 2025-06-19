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
    implementation(project(":core-domain"))
    implementation(project(":core-domain-api"))
    implementation(project(":rest-api-model"))
    implementation(project(":utils"))
    implementation(project(":spring-r2dbc-storage-mysql"))

    implementation(libs.bundles.kotlinxEcosystem)
    implementation(libs.bundles.jackson)
    if ("osx-aarch_64" == osdetector.classifier) {
        runtimeOnly("io.netty:netty-resolver-dns-native-macos:4.1.100.Final:osx-aarch_64")
    }
    implementation(libs.bundles.kotlinxCoroutinesReactor)
    implementation(libs.reactorTest)
    implementation(libs.jasypt)
    implementation(libs.bundles.springBootWebFluxDependencies)
    implementation(libs.springBootStartActuator)

    testImplementation(libs.junit)
    testImplementation(kotlin("test"))
    testImplementation(libs.springBootStarterTest)
}

