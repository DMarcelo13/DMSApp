package com.example.dmsapp.retrofit

import com.example.dmsapp.model.Auto
import com.example.dmsapp.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<AutoNetworkEntity, Auto> {
    override fun mapFromEntity(entity: AutoNetworkEntity): Auto {
        return Auto(
            id = entity.id,
            nombre = entity.nombre,
            descripcion = entity.descripcion,
            img = entity.img
        )
    }

    override fun mapToEntity(domainModel: Auto): AutoNetworkEntity{
        return  AutoNetworkEntity(
            id = domainModel.id,
            nombre = domainModel.nombre,
            descripcion = domainModel.descripcion,
            img = domainModel.img
        )
    }

    fun mapFromEntityList(entities: List<AutoNetworkEntity>): List<Auto>{
        return entities.map { mapFromEntity(it) }
    }
}