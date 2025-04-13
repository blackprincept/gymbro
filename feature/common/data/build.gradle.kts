plugins {
    alias(libs.plugins.gymbro.android.library)
    alias(libs.plugins.gymbro.hilt)
}

android {
    namespace = "com.pegio.data"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:firestore"))
    implementation(project(":feature:common:domain"))

    implementation(libs.firebase.auth) // FIXME PLEASE
}