package com.example.dmsapp.room

import com.example.dmsapp.model.Auto
import com.example.dmsapp.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
    EntityMapper<AutoCacheEntity, Auto> {

    override fun mapFromEntity(entity: AutoCacheEntity): Auto {
        return Auto(
            id = entity.id,
            nombre = entity.nombre,
            descripcion = entity.descripcion,
            img = entity.img
        )
    }

    override fun mapToEntity(domainModel: Auto): AutoCacheEntity {
        return AutoCacheEntity(
            id = domainModel.id,
            nombre = domainModel.nombre,
            descripcion = domainModel.descripcion,
            img = domainModel.img
        )
    }

    fun mapFromEntityList(entities: List<AutoCacheEntity>): List<Auto>{
        return entities.map { mapFromEntity(it) }
    }
}