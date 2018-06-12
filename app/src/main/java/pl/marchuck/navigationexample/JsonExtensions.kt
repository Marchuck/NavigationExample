package pl.marchuck.navigationexample

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException

object MoshiHelper {
    val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
}

fun <T> String.fromJson(clazz: Class<T>): T? {
    return try {
        MoshiHelper.moshi.adapter(clazz).fromJson(this)
    } catch (ignored: IOException) {
        null
    }
}

inline fun <reified T> T.toJson(): String {
    return MoshiHelper.moshi.adapter(T::class.java).toJson(this)
}