import java.io.File
import com.github.gradle.node.npm.task.NpmTask

plugins {
	java
	id("org.springframework.boot") version "3.5.6"
	id("io.spring.dependency-management") version "1.1.7"
	id("com.github.node-gradle.node") version "5.0.0"
}

group = "com.notifications"
version = "0.0.1-SNAPSHOT"
description = "User interface Spring Project"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

node {
    download.set(false)
    workDir.set(file("${project.projectDir}/src/main/ts"))
    npmWorkDir.set(file("${project.projectDir}/src/main/ts"))
    nodeProjectDir.set(file("${project.projectDir}/src/main/ts"))
}

tasks.register<NpmTask>("appNpmInstall") {
    description = "read package.json and install all dependencies"
    workingDir.set(file("${project.projectDir}/src/main/ts"))
    args.set(listOf("install", "--loglevel=info")) 
}

tasks.register<NpmTask>("appNpmBuild") {
    description = "Builds application for your frontend"
    workingDir.set(file("${project.projectDir}/src/main/ts"))
    args.set(listOf("run", "build"))
}

tasks.register<Copy>("copyToFrontend") {
    description = "Copies frontend build files"
    from("$projectDir/src/main/ts/dist/")
    into("$projectDir/src/main/resources/static")
}
tasks.named("appNpmBuild") {
    dependsOn("appNpmInstall")
    finalizedBy("copyToFrontend")
}

tasks.named("compileJava") {
    dependsOn("copyToFrontend")
}

