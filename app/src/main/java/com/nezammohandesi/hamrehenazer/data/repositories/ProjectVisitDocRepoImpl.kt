package com.edsab.pm.repository


import com.nezammohandesi.hamrehenazer.data.dao.ProjectDao

import com.nezammohandesi.hamrehenazer.data.model.ProjectDetail
import com.nezammohandesi.hamrehenazer.data.model.ProjectVisit
import com.nezammohandesi.hamrehenazer.data.model.ProjectVisitDoc
import com.nezammohandesi.hamrehenazer.data.model.TbProject
import com.nezammohandesi.hamrehenazer.data.model.enum.RowType
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectDetailRepository
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectVisitDocRepository
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectVisitRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProjectVisitDocRepoImpl(
    private val projectDao: ProjectDao,
    private val gson: Gson

) : ProjectVisitDocRepository {
    override fun InsertProjectVisitDoc(project: ProjectVisitDoc) {
        var detail= gson.toJson(project)
        val project= TbProject( RowType.toInteger(RowType.ProjectVisitDoc),detail)
        projectDao.insert(project)
    }

    override fun GetAllProjectVisitDocByProjId(projectId: Int): List<ProjectVisitDoc> {
        val allProjectVisitDoc=projectDao.getProjectWithType(RowType.toInteger(RowType.ProjectVisitDoc)!!)
        if(allProjectVisitDoc==null)
            return emptyList()
        val projectVisitDocs = allProjectVisitDoc.map { projDetails ->
            val parsed = gson.fromJson(projDetails.detail, ProjectVisitDoc::class.java)
            parsed.Id = projDetails.id
            parsed
        }
        return projectVisitDocs
    }

    override fun GetProjectVisitDocById(projVisitId: Int): ProjectVisitDoc {
        val projectVisitDoc=projectDao.getProjectWithId(projVisitId)
        val parsed = gson.fromJson(projectVisitDoc.detail, ProjectVisitDoc::class.java)
        parsed.Id=projectVisitDoc.id
        return parsed
    }

    override fun DeleteProjecVisittById(ProjectVisitDocId: Int) {
        projectDao.deleteProjectWithId(ProjectVisitDocId)
    }


}