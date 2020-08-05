package com.example.cleanarchitecture.data.mappers

interface NetworkEntityMapper<Entity, DataModel> {
    fun mapToEntity(dataModel: DataModel): Entity
}

interface CacheEntityMapper<Entity, DataModel> {
    fun mapToEntity(dataModel: DataModel): Entity
    fun mapFromEntity(entity: Entity): DataModel
}
