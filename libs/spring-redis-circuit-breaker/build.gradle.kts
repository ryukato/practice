plugins {
    // Apply the shared build logic from a convention plugin.
    // The shared code is located in `buildSrc/src/main/kotlin/kotlin-jvm.gradle.kts`.
    id("buildsrc.convention.kotlin-jvm")
    // Apply Kotlin Serialization plugin from `gradle/libs.versions.toml`.
    alias(libs.plugins.kotlinPluginSerialization)
    alias(libs.plugins.kotlinSpring)
    alias(libs.plugins.springBoot)
    alias(libs.plugins.springDependencyManagement)
}

dependencies {
    implementation(project(":core-domain-utility"))
    implementation(project(":date-util"))
    implementation(project(":spring-storage-redis"))
    // Apply the kotlinx bundle of dependencies from the version catalog (`gradle/libs.versions.toml`).
    implementation(libs.bundles.kotlinxEcosystem)
    implementation(libs.bundles.kotlinxCoroutinesReactor)
    implementation(libs.reactorTest)
    implementation(libs.springBootStarterDataRedisReactive)
    implementation(libs.redisson)
    implementation(libs.commonsPool)

    implementation(libs.bundles.springBootWebFluxDependencies)
    implementation(libs.jasypt)

    testImplementation(libs.junit)
    testImplementation(kotlin("test"))
    testImplementation(libs.springBootStarterTest)
    testImplementation(libs.bundles.testContainerMysql)
}

val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks
jar.enabled = true
jar.archiveBaseName.set("spring-redis-circuit-breaker")
bootJar.enabled = false
