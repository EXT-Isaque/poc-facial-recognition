pluginManagement {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2")
            metadataSources {
                ignoreGradleMetadataRedirection()
                mavenPom()
                artifact()
            }
        }
    }
}

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2")
            metadataSources {
                ignoreGradleMetadataRedirection()
                mavenPom()
                artifact()
            }
        }
    }
    dependencies {
        uri("com.android.tools.build:gradle:8.1.4")
        uri("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        uri("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.0")
        uri("com.github.dcendents:android-maven-plugin:1.0")
    }
//    dependencies {
//
//        classpath 'com.android.tools.build:gradle:8.1.4'
//        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21"
//        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.5.0"
//        classpath 'com.github.dcendents:android-maven-plugin:1.0'
//
//        // NOTE: Do not place your application dependencies here; they belong
//        // in the individual module build.gradle files
//    }
}



dependencyResolutionManagement {
    repositories {
        google()
        jcenter()
        maven {
            url = uri("https://pkgs.dev.azure.com/nxcd/ef9b4772-b664-4276-aeca-9b430422da12/_packaging/nxcd_SDK/maven/v1")
        }
    }
}

rootProject.name = "poc-facial-recognition"
include(":app")