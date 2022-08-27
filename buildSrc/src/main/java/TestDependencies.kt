object TestVersions {
    /** 1.4.0 */
    const val test_core_version = "1.4.0"

    /** 4.13.2 */
    const val junit_version = "4.13.2"

    /** 2.1.0 */
    const val core_testing_version = "2.1.0"

    /** 1.5.1 */
    const val kotlinx_coroutines_test_version = "1.5.1"

    /** 1.1.3 */
    const val google_truth_version = "1.1.3"

    /** 4.9.1 */
    const val okhttp_mockwebserver_version = "4.9.1"

    /** 1.10.5 */
    const val mock_io_version = "1.10.5"

    /** 1.1.0-alpha04 */
    const val compose_ui_test_version = "1.1.0-alpha04"
}

@Suppress("unused")
/**
 * Require use of *testImplementation*
 */
object TestDependencies {
    /** androidx.test:core:[TestVersions.test_core_version] */
    const val test_core = "androidx.test:core:${TestVersions.test_core_version}"
    /** androidx.test:core-ktx:[TestVersions.test_core_version] */
    const val test_core_ktx = "androidx.test:core-ktx:${TestVersions.test_core_version}"
    /** junit:junit:[TestVersions.junit_version] */
    const val junit = "junit:junit:${TestVersions.junit_version}"
    /** androidx.arch.core:core-testing:[TestVersions.core_testing_version] */
    const val core_testing = "androidx.arch.core:core-testing:${TestVersions.core_testing_version}"
    /** org.jetbrains.kotlinx:kotlinx-coroutines-test:[TestVersions.kotlinx_coroutines_test_version] */
    const val kotlinx_coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestVersions.kotlinx_coroutines_test_version}"
    /** com.google.truth:truth:[TestVersions.google_truth_version] */
    const val google_truth = "com.google.truth:truth:${TestVersions.google_truth_version}"
    /** com.squareup.okhttp3:mockwebserver:[TestVersions.okhttp_mockwebserver_version] */
    const val okhttp_mockwebserver = "com.squareup.okhttp3:mockwebserver:${TestVersions.okhttp_mockwebserver_version}"
    /** io.mockk:mockk:[TestVersions.mock_io_version] */
    const val mock_io = "io.mockk:mockk:${TestVersions.mock_io_version}"
    /**
     * Require use of *debugImplementation*
     * androidx.compose.ui:ui-test-manifest:[TestVersions.compose_ui_test_version]
     */
    const val compose_ui_test = "androidx.compose.ui:ui-test-manifest:${TestVersions.compose_ui_test_version}"
}