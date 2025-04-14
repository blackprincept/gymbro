plugins {
    alias(libs.plugins.gymbro.android.presentation)
}

android {
    namespace = "com.pegio.presentation"
}

dependencies {
    implementation(project(":core:uploadmanager"))
    implementation(project(":feature:aichat:domain"))

    implementation(libs.kotlinx.datetime)
}