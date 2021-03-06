object App {
    val id = "by.gomel.marseille"
    val versionCode = 1
    val versionName = "0.1"
}

object Modules {
    val app = ":app"
    val coreUiKit = ":core:core-uikit"
    val data = ":data"
    val coreBase = ":core:core-base"
    val featureMain = ":feature:feature-main"
    val featureGoods = ":feature:feature-goods"
    val featureSplash = ":feature:feature-splash"
    val featureAbout = ":feature:feature-about"
    val featureService = ":feature:feature-service"
    val featureOrder = ":feature:feature-order"
}

object Versions {
    val compileSdk = 28
    val minSdk = 21
    val targetSdk = 28

    val javaSdk = 1.8

    val gradle = "3.4.0"
    val kotlin = "1.3.11"
    val googleServices = "4.2.0"

    val koin = "1.0.2"
    val core = "1.0.1"
    val material = "1.1.0-alpha05"
    val appcompat = "1.0.2"
    val navigation = "2.0.0"
    val rxjava2 = "2.2.8"
    val rxkotlin = "2.3.0"
    val rxandroid = "2.1.1"
    val exoplayer = "2.9.6"
    val exoplayerIcyMetadata = "1.0.1"
    val glide = "4.9.0"
    val retrofit = "2.5.0"
    val okhttp3 = "3.12.0"
    val gson = "2.8.5"
    val firebase = "16.0.1"
    val mapServices = "16.1.0"
    val room = "2.1.0-rc01"

    val jUnit = "4.12"
    val testCore = "1.2.0"
    val espresso = "3.2.0"
    val mockito = "2.8.9"
    val testExtJUnit = "1.1.1"
    val robolectric = "4.3"
    val testExtTruth = "1.2.0-beta01"
    val kakao = "2.0.0"
}

object Libraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    
    val firebase = "com.google.firebase:firebase-core:${Versions.firebase}"
    val firebaseDatabase = "com.google.firebase:firebase-database:${Versions.firebase}"

    val coreKtx = "androidx.core:core-ktx:${Versions.core}"
    val core = "androidx.core:core:${Versions.core}"
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val material = "com.google.android.material:material:${Versions.material}"

    // Koin
    val koin = "org.koin:koin-android:${Versions.koin}"
    val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"

    // Navigation
    val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Reactive programming
    val rxjava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxjava2}"
    val rxkotlin =  "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"

    // ImageLoading
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val /** KAPT */ glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofitRxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"

    // OkHttp3
    val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    val okhttp3LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"

    // Gson - json object serializer
    val gson = "com.google.code.gson:gson:${Versions.gson}"

    // Google services
    val mapsServices = "com.google.android.gms:play-services-maps:${Versions.mapServices}"

    // Room database ORM
    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val /** KAPT */ roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRxjava2 = "androidx.room:room-rxjava2:${Versions.room}"
    val roomQuava = "androidx.room:room-guava:${Versions.room}"
    val /** TEST */ roomTest = "androidx.room:room-testing:${Versions.room}"

    // Test
    val /* TEST */ jUnit = "junit:junit:${Versions.jUnit}"
    val /* ANDROID TEST */ testRunner = "androidx.test:runner:${Versions.testCore}"
    val /* ANDROID TEST */ espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val /* TEST */ kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val /* TEST */ mockito = "org.mockito:mockito-core:${Versions.mockito}"
    val /* TEST */ mockitoInline = "org.mockito:mockito-inline:${Versions.mockito}"

    val /* ANDROID TEST */ testCore = "androidx.test:core:${Versions.testCore}"
    val /* ANDROID TEST */ testCoreKtx = "androidx.test:core-ktx:${Versions.testCore}"
    val /* ANDROID TEST */ testRules = "androidx.test:rules:${Versions.testCore}"
    val /* ANDROID TEST */ testExtJUnit = "androidx.test.ext:junit:${Versions.testExtJUnit}"
    val /* ANDROID TEST */ testExtJUnitKtx = "androidx.test.ext:junit-ktx:${Versions.testExtJUnit}"

    val /* TEST */ robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    val /* TEST */ espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"
    val /* TEST */ testExtTruth = "androidx.test.ext:truth:${Versions.testExtTruth}"
    val /* ANDROID TEST */ kakao = "com.agoda.kakao:kakao:${Versions.kakao}"
}