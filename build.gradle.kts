// Root build.gradle.kts – legacy-kompatibel, funktioniert ohne pluginManagement
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
    }
}

// keine Plugins hier anwenden – nur Klassenpfade bereitstellen
