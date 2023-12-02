package net.rafaeltoledo.kotlin.util

import kotlin.reflect.KClass

fun KClass<*>.readContent(filename: String): String {
  return this::class.java.classLoader?.getResource(filename)?.readText() ?: ""
}
