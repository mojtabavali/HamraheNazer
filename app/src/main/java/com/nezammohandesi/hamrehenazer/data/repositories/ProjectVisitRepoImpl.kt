package com.edsab.pm.repository


import com.nezammohandesi.hamrehenazer.data.dao.ProjectDao

import com.nezammohandesi.hamrehenazer.data.model.ProjectDetail
import com.nezammohandesi.hamrehenazer.data.model.ProjectVisit
import com.nezammohandesi.hamrehenazer.data.model.ProjectVisitDoc
import com.nezammohandesi.hamrehenazer.data.model.TbProject
import com.nezammohandesi.hamrehenazer.data.model.enum.RowType
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectDetailRepository
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectVisitRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProjectVisitRepoImpl(
    private val projectDao: ProjectDao,
    private val gson: Gson

) : ProjectVisitRepository {
    override fun InsertProjectVisit(project: ProjectVisit) {
        var detail= gson.toJson(project)
        val project= TbProject( RowType.toInteger(RowType.ProjectVisit),detail)
        projectDao.insert(project)
    }

    override fun GetAllProjectVisitByProjId(projectId: Int): List<ProjectVisit> {
        val allProjectVisit=projectDao.getProjectWithType(RowType.toInteger(RowType.ProjectVisit)!!)
        if(allProjectVisit==null)
            return emptyList()
        val projectVisit = allProjectVisit.map { projDetails ->
            val parsed = gson.fromJson(projDetails.detail, ProjectVisit::class.java)
            parsed.Id = projDetails.id
            parsed
        }
        return projectVisit
    }

    override fun GetProjectVisitById(projVisitId: Int): ProjectVisit {
        val projectVisitDoc=projectDao.getProjectWithId(projVisitId)
        val parsed = gson.fromJson(projectVisitDoc.detail, ProjectVisit::class.java)
        parsed.Id=projectVisitDoc.id
        return parsed
    }

    override fun DeleteProjectVisitById(projectVisitId: Int) {
        projectDao.deleteProjectWithId(projectVisitId)
    }


}