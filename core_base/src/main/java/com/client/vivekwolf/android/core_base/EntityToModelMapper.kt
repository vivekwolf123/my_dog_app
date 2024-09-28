package com.client.vivekwolf.android.core_base

import kotlin.reflect.KClass

class EntityToModelMapper<E : Any, M : Any>(
    private val entityClass: KClass<E>,
    private val fromEntity: (E) -> M,
) {

    @Suppress("UNCHECKED_CAST")
    fun mapEntityToModel(entity: Any): Any {
        return when (entity) {
            is List<*> -> (entity as List<E>).map { fromEntity(it) }
            is Map<*, *> -> (entity as Map<E, E>).map { fromEntity(it.key) to fromEntity(it.value) }
                .toMap()

            else -> if (entityClass.isInstance(entity)) {
                fromEntity(entity as E)
            } else {
                throw IllegalArgumentException("Unsupported type")
            }
        }
    }
}
