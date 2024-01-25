@file:Suppress("GradlePackageUpdate")

plugins {
    id("org.openrewrite.build.recipe-library") version "latest.release"
}

group = "org.openrewrite.recipe"
description = "A rewrite module automating best practices and major version migrations for popular Java test frameworks like JUnit and Mockito"

recipeDependencies {
    parserClasspath("org.assertj:assertj-core:3.+")
    parserClasspath("junit:junit:latest.release")
    parserClasspath("pl.pragmatists:JUnitParams:1.+")
    parserClasspath("org.junit.jupiter:junit-jupiter-api:latest.release")
    parserClasspath("org.junit.jupiter:junit-jupiter-params:latest.release")
    parserClasspath("org.hamcrest:hamcrest:latest.release")
    parserClasspath("com.squareup.okhttp3:mockwebserver:3.14.9")
    parserClasspath("org.apiguardian:apiguardian-api:1.1.2")
    parserClasspath("com.github.tomakehurst:wiremock-jre8:2.35.0")
    parserClasspath("org.mockito:mockito-all:1.10.19")
    parserClasspath("org.mockito:mockito-core:3.+")
    parserClasspath("org.jmockit:jmockit:1.49")
    parserClasspath("org.mockito:mockito-junit-jupiter:3.+")
    parserClasspath("org.powermock:powermock-api-mockito:1.7.+")
    parserClasspath("org.powermock:powermock-core:1.7.+")
    parserClasspath("com.squareup.okhttp3:mockwebserver:4.10.0")
}

val rewriteVersion = rewriteRecipe.rewriteVersion.get()
dependencies {
    implementation(platform("org.openrewrite:rewrite-bom:$rewriteVersion"))
    implementation("org.openrewrite:rewrite-java")
    implementation("org.openrewrite:rewrite-gradle")
    implementation("org.openrewrite:rewrite-maven")
    implementation("org.openrewrite.recipe:rewrite-java-dependencies:$rewriteVersion")
    implementation("org.openrewrite.recipe:rewrite-static-analysis:$rewriteVersion")
    runtimeOnly("org.openrewrite:rewrite-java-17")

    compileOnly("org.projectlombok:lombok:latest.release")
    annotationProcessor("org.projectlombok:lombok:latest.release")

    implementation("org.testcontainers:testcontainers:latest.release")

    testImplementation("org.openrewrite:rewrite-java-17")
    testImplementation("org.openrewrite:rewrite-groovy")

    testRuntimeOnly("org.gradle:gradle-tooling-api:latest.release")

    testRuntimeOnly("com.tngtech.archunit:archunit:0.23.1")
    testRuntimeOnly("org.testcontainers:testcontainers:latest.release")
    testRuntimeOnly("org.testcontainers:nginx:latest.release")

//    testImplementation("org.hamcrest:hamcrest:latest.release")
//    testImplementation("org.assertj:assertj-core:latest.release")

    // The bom version can also be set to a specific version
    // https://github.com/openrewrite/rewrite-recipe-bom/releases
    implementation(platform("org.openrewrite.recipe:rewrite-recipe-bom:latest.release"))

    // Refaster style recipes need the rewrite-templating annotation processor and dependency for generated recipes
    // https://github.com/openrewrite/rewrite-templating/releases
    annotationProcessor("org.openrewrite:rewrite-templating:latest.release")
    implementation("org.openrewrite:rewrite-templating")
    // The `@BeforeTemplate` and `@AfterTemplate` annotations are needed for refaster style recipes
    compileOnly("com.google.errorprone:error_prone_core:2.19.1") {
        exclude("com.google.auto.service", "auto-service-annotations")
    }

    implementation("org.assertj:assertj-core:3.+")

}
