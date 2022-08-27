object Versions {
    /** 1.7.0 */
    const val core_ktx_version = "1.7.0"

    /** 1.4.0 */
    const val activity_compose_version = "1.4.0"
    /** 2.4.1 */
    const val lifecycle_version = "2.4.1"
    /** 1.1.1 */
    const val compose_version = "1.1.1"

    /**2.9.0*/
    const val retrofit = "2.9.0"

    /** 2.8.9 */
    const val gson = "2.8.9"

    /** 2.4.2 */
    const val room = "2.4.2"

    /** 1.6.0 */
    const val coroutine_core_version = "1.6.0"

    /** 1.6.0 */
    const val coroutine_android_version = "1.6.0"

    /** 2.38.1 */
    const val hilt_android_version = "2.38.1"

    /** 1.0.0-alpha03 */
    const val hilt_lifecycle_viewmodel_version = "1.0.0-alpha03"

    /** 1.0.0 */
    const val hilt_compiler_version = "1.0.0"

    /** 1.0.0 */
    const val hilt_navigation_compose_version = "1.0.0"
}

@Suppress("unused")
object Dependencies {
    // Gradle Versions Plugin
    const val gradle_versions_plugin = "com.github.ben-manes:gradle-versions-plugin:0.42.0"

    // Compose
    /** androidx.core:core-ktx:[Versions.core_ktx_version] */
    const val coreKtx = "androidx.core:core-ktx:${Versions.core_ktx_version}"
    /** androidx.compose.ui:ui:[Versions.compose_version] */
    const val compose_ui = "androidx.compose.ui:ui:${Versions.compose_version}"
    /** androidx.compose.material:material:[Versions.compose_version] */
    const val compose_material = "androidx.compose.material:material:${Versions.compose_version}"
    /** androidx.compose.ui:ui-tooling-preview:[Versions.compose_version] */
    const val compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_version}"
    /**
     * Require use of *debugImplementation*
     * androidx.compose.ui:ui-tooling:[Versions.activity_compose_version]
     * */
    const val compose_ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose_version}"
    /** androidx.activity:activity-compose:[Versions.activity_compose_version] */
    const val activity_compose = "androidx.activity:activity-compose:${Versions.activity_compose_version}"

    // Lifecycle
    /** androidx.lifecycle:lifecycle-runtime-ktx:[Versions.lifecycle_version] */
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"
    /** androidx.lifecycle:lifecycle-viewmodel-compose:[Versions.lifecycle_version] */
    const val lifecycle_viewmodel_compose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle_version}"
    /** androidx.lifecycle:lifecycle-viewmodel-ktx:[Versions.lifecycle_version] */
    const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"

    /** com.squareup.retrofit2:retrofit:[Versions.retrofit] */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    /** com.squareup.retrofit2:converter-gson:[Versions.retrofit] */
    const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // Gson
    /** com.google.code.gson:gson:[Versions.gson] */
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // Room
    /** androidx.room:room-runtime:[Versions.room] */
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    /** Require use of kapt
     * androidx.room:room-compiler:[Versions.room]
     * */
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    /** androidx.room:room-ktx:[Versions.room] */
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"

    // Coroutines
    /** org.jetbrains.kotlinx:kotlinx-coroutines-core:[Versions.coroutine_core_version] */
    const val kotlinx_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine_core_version}"
    /** org.jetbrains.kotlinx:kotlinx-coroutines-android:[Versions.coroutine_android_version] */
    const val kotlinx_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine_android_version}"

    // Dagger Hilt
    /** com.google.dagger:hilt-android:[Versions.hilt_android_version] */
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_android_version}"
    /**
     * Require use of *kapt*
     * com.google.dagger:hilt-android:[Versions.hilt_android_version]
     */
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_android_version}"
    /** androidx.hilt:hilt-lifecycle-viewmodel:[Versions.hilt_lifecycle_viewmodel_version] */
    const val hilt_lifecycle_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_lifecycle_viewmodel_version}"
    /**
     * Require use of *kapt*
     * androidx.hilt:hilt-compiler:[Versions.hilt_compiler_version]
     */
    const val hilt_compiler = "androidx.hilt:hilt-compiler:${Versions.hilt_compiler_version}"
    /** androidx.hilt:hilt-navigation-compose:[Versions.hilt_navigation_compose_version] */
    const val hilt_navigation_compose = "androidx.hilt:hilt-navigation-compose:${Versions.hilt_navigation_compose_version}"
}