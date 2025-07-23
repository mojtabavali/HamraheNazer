package com.edsab.pm.repository


import com.nezammohandesi.hamrehenazer.data.dao.ProjectDao

import com.nezammohandesi.hamrehenazer.data.model.ProjectDetail
import com.nezammohandesi.hamrehenazer.data.model.ProjectDoc
import com.nezammohandesi.hamrehenazer.data.model.TbProject
import com.nezammohandesi.hamrehenazer.data.model.enum.RowType
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectDetailRepository
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectDocumentlRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProjectDocumentRepoImpl(
    private val projectDao: ProjectDao,
    private val gson: Gson

) : ProjectDocumentlRepository {
    override fun InsertProjectDocument(project: ProjectDoc) {
        var detail= gson.toJson(project)
        val projectDoc= TbProject( RowType.toInteger(RowType.ProjectDocument),detail)
        projectDao.insert(projectDoc)
    }

    override fun GetAllProjectDocByProjId(projectId: Int): List<ProjectDoc> {
        val allProjectDoc=projectDao.getProjectWithType(RowType.toInteger(RowType.ProjectDocument)!!)
        if(allProjectDoc==null)
            return emptyList()
        val projectDoc = allProjectDoc.map { projDetails ->
            val parsed = gson.fromJson(projDetails.detail, ProjectDoc::class.java)
            parsed.Id = projDetails.id
            parsed
        }
        return projectDoc
    }

    override fun GetProjectDocById(projectDocId: Int): ProjectDoc {
        val projectDoc=projectDao.getProjectWithId(projectDocId)
        val parsed = gson.fromJson(projectDoc.detail, ProjectDoc::class.java)
        parsed.Id=projectDoc.id
        return parsed
    }

    override fun DeleteProjecDoctById(projectDocId: Int) {
        projectDao.deleteProjectWithId(projectDocId)
    }


}