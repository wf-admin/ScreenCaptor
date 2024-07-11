plugins {
  alias(libs.plugins.androidTest)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.compose.compiler)
}

android {
  namespace = "com.wealthfront.screencaptor.sample.test"
  compileSdk = 34

  defaultConfig {
    minSdk = 26
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  compileOptions {
    sourceCompatibility = Versions.javaVersion
    targetCompatibility = Versions.javaVersion
  }

  kotlinOptions {
    jvmTarget = Versions.javaVersion.toString()
    freeCompilerArgs += listOf(
      "-opt-in=androidx.compose.material.ExperimentalMaterialApi",
      "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
    )
  }

  buildFeatures {
    compose = true
  }

  targetProjectPath(":screencaptor-sample")
}

dependencies {
  implementation(project(":screencaptor"))
  implementation(project(":internal-test-support"))

  implementation(libs.androidx.test)
  implementation(libs.androidx.test.ktx)
  implementation(libs.junit)
  implementation(libs.truth)
  implementation(libs.espresso.core)
  implementation(libs.espresso.contrib)
  implementation(libs.androidx.test.rules)
  implementation(libs.androidx.test.junit)

  implementation(enforcedPlatform(libs.compose.bom))
  implementation(libs.compose.foundation)
  implementation(libs.compose.ui)
  implementation(libs.compose.tooling)
  implementation(libs.compose.tooling.preview)
  implementation(libs.compose.material)
  implementation(libs.compose.material3)
  implementation(libs.compose.manifest)
  implementation(libs.compose.junit4)
}