plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    `version-catalog`
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    namespace = "com.infore.version.catalog"
}

// 版本目录配置
catalog {
    /**
     * version - 用于声明可以被依赖项引用的版本
     * plugin  - 用于声明插件
     * library - 用于声明坐标的别名
     * bundle  - 用于声明依赖包
     */
    versionCatalog {
        version("compileSdk", "32")
        version("minSdk", "21")
        version("targetSdk", "32")
        version("android", "7.2.1")
        version("kotlin", "1.7.0")

        // plugin
        plugin("android-application", "com.android.application").versionRef("android")
        plugin("android-library", "com.android.library").versionRef("android")
        plugin("kotlin-android", "org.jetbrains.kotlin.android").versionRef("kotlin")
        plugin("kotlin-kapt", "org.jetbrains.kotlin.kapt").versionRef("kotlin")
        plugin("kotlin-parcelize", "org.jetbrains.kotlin.plugin.parcelize").versionRef("kotlin")

        // infore
        library("infore-jetpack-mvvm", "com.infore.robot:jetpack-mvvm:1.2.5")

        // androidx
        library("androidx-activity-ktx", "androidx.activity", "activity-ktx").version("1.6.1")
        library("androidx-annotation", "androidx.annotation", "annotation").version("1.5.0")
        library("androidx-appcompat", "androidx.appcompat", "appcompat").version("1.5.1")
        library("androidx-cardview", "androidx.cardview", "cardview").version("1.0.0")
        library("androidx-constraintlayout", "androidx.constraintlayout", "constraintlayout").version("2.1.4")
        library("androidx-core-ktx", "androidx.core", "core-ktx").version("1.7.0")
        version("androidx-datastore", "1.0.0")
        library("androidx-datastore", "androidx.datastore", "datastore").versionRef("androidx-datastore")
        library("androidx-datastore-preferences", "androidx.datastore", "datastore-preferences")
            .versionRef("androidx-datastore")
        bundle("androidx-datastore", listOf("androidx-datastore", "androidx-datastore-preferences"))
        library("androidx-fragment-ktx", "androidx.fragment", "fragment-ktx").version("1.5.4")
        library("androidx-multidex", "androidx.multidex", "multidex").version("2.0.1")
        library("androidx-paging", "androidx.paging", "paging-runtime").version("3.1.1")
        library("androidx-recyclerview", "androidx.recyclerview", "recyclerview").version("1.2.1")
        library("androidx-recyclerview-selection", "androidx.recyclerview", "recyclerview-selection").version("1.1.0")
        library("androidx-startup-runtime", "androidx.startup", "startup-runtime").version("1.1.1")
        library("androidx-swiperefreshlayout", "androidx.swiperefreshlayout", "swiperefreshlayout").version("1.1.0")
        library("androidx-viewpager2", "androidx.viewpager2", "viewpager2").version("1.0.0")
        library("androidx-legacy", "androidx.legacy", "legacy-support-v4").version("1.0.0")

        // material
        library("material", "com.google.android.material", "material").version("1.5.0")

        // lifecycle
        version("lifecycle", "2.5.1")
        library("lifecycle-viewmodel-ktx", "androidx.lifecycle", "lifecycle-viewmodel-ktx").versionRef("lifecycle")
        library("lifecycle-livedata-ktx", "androidx.lifecycle", "lifecycle-livedata-ktx").versionRef("lifecycle")
        library("lifecycle-runtime-ktx", "androidx.lifecycle", "lifecycle-runtime-ktx").versionRef("lifecycle")
        library("lifecycle-viewmodel-savedstate", "androidx.lifecycle", "lifecycle-viewmodel-savedstate")
            .versionRef("lifecycle")
        library("lifecycle-common-java8", "androidx.lifecycle", "lifecycle-common-java8").versionRef("lifecycle")
        library("lifecycle-service", "androidx.lifecycle", "lifecycle-service").versionRef("lifecycle")
        library("lifecycle-process", "androidx.lifecycle", "lifecycle-process").versionRef("lifecycle")
        library("lifecycle-reactivestreams-ktx", "androidx.lifecycle", "lifecycle-reactivestreams-ktx")
            .versionRef("lifecycle")
        bundle("lifecycle", listOf(
            "lifecycle-viewmodel-ktx",
            "lifecycle-livedata-ktx",
            "lifecycle-runtime-ktx",
            "lifecycle-viewmodel-savedstate",
            "lifecycle-common-java8",
            "lifecycle-service",
            "lifecycle-process",
            "lifecycle-reactivestreams-ktx",
        ))

        // navigation
        version("navigation", "2.5.3")
        plugin("navigation-safeargs", "androidx.navigation.safeargs.kotlin").versionRef("navigation")
        library("navigation-fragment-ktx", "androidx.navigation", "navigation-fragment-ktx")
            .versionRef("navigation")
        library("navigation-ui-ktx", "androidx.navigation", "navigation-ui-ktx")
            .versionRef("navigation")
        bundle("navigation", listOf("navigation-fragment-ktx", "navigation-ui-ktx"))

        // coroutines
        version("coroutines", "1.6.4")
        library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core")
            .versionRef("coroutines")
        library("kotlinx-coroutines-android", "org.jetbrains.kotlinx", "kotlinx-coroutines-android")
            .versionRef("coroutines")
        bundle("coroutines", listOf("kotlinx-coroutines-core", "kotlinx-coroutines-android"))

        // room
        version("room", "2.5.0-alpha02")
        library("room-runtime", "androidx.room", "room-runtime").versionRef("room")
        library("room-ktx", "androidx.room", "room-ktx").versionRef("room")
        library("room-compiler", "androidx.room", "room-compiler").versionRef("room")
        bundle("room", listOf("room-runtime", "room-ktx"))

        // coil
        version("coil", "2.2.2")
        library("coil", "io.coil-kt", "coil").versionRef("coil")
        library("coil-gif", "io.coil-kt", "coil-gif").versionRef("coil")
        bundle("coil", listOf("coil", "coil-gif"))

        // compose
        version("compose", "1.2.0")
        library("androidx-compose-animation", "androidx.compose.animation", "animation").versionRef("compose")
        library("androidx-compose-foundation", "androidx.compose.foundation", "foundation").versionRef("compose")
        library("androidx-compose-material", "androidx.compose.material", "material").versionRef("compose")
        library("androidx-compose-ui", "androidx.compose.ui", "ui").versionRef("compose")
        library("androidx-compose-ui-tooling", "androidx.compose.ui", "ui-tooling").versionRef("compose")
        library("androidx-compose-ui-tooling-preview", "androidx.compose.ui", "ui-tooling-preview")
            .versionRef("compose")
        library("androidx-compose-runtime-livedata", "androidx.compose.runtime", "runtime-livedata")
            .versionRef("compose")
        bundle("compose", listOf(
            "androidx-compose-animation",
            "androidx-compose-foundation",
            "androidx-compose-material",
            "androidx-compose-ui",
            "androidx-compose-ui-tooling-preview",
            "androidx-compose-runtime-livedata",
        ))
        library("androidx-activity-compose", "androidx.activity:activity-compose:1.5.1")
        library("androidx-lifecycle-viewmodel-compose", "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

        // dokit(https://github.com/didi/DoraemonKit)
        version("dokit", "3.5.0")
        library("dokit", "io.github.didi.dokit", "dokit").versionRef("dokit")
        library("dokit-ft", "io.github.didi.dokit", "dokitx-ft").versionRef("dokit")
        library("dokit-mc", "io.github.didi.dokit", "dokitx-mc").versionRef("dokit")
        library("dokit-weex", "io.github.didi.dokit", "dokitx-weex").versionRef("dokit")
        library("dokit-no-op", "io.github.didi.dokit", "dokitx-no-op").versionRef("dokit")
        bundle("dokit", listOf("dokit", "dokit-ft", "dokit-mc", "dokit-weex", "dokit-no-op"))

        // bugly
        library("bugly", "com.tencent.bugly:crashreport:4.0.4")
        // androidautosize
        library("androidautosize", "com.github.JessYanCoding:AndroidAutoSize:v1.2.1")
        // easyfloat
        library("easyfloat", "com.github.princekin-f:EasyFloat:2.0.4")
        // powerspinner
        library("powerspinner", "com.github.skydoves:powerspinner:1.2.3")
        // photoview
        library("photoview", "com.github.chrisbanes:PhotoView:2.3.0")
        // bannerviewpager
        library("bannerviewpager", "com.github.zhpanvip:bannerviewpager:3.5.7")
        // baserecyclerviewadapterhelper
        library("baserecyclerviewadapterhelper", "io.github.cymchad:BaseRecyclerViewAdapterHelper:4.0.0-beta02")

        // test
        library("test-core-ktx", "androidx.test:core-ktx:1.4.0")
        library("test-junit-junit", "junit:junit:4.13.2")
        library("test-junit-ktx", "androidx.test.ext:junit-ktx:1.1.3")
        library("test-espresso-core", "androidx.test.espresso:espresso-core:3.4.0")
    }
}

apply(from = "maven.gradle")
