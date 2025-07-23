package com.edsab.pm.repository


import com.nezammohandesi.hamrehenazer.data.dao.ProjectDao

import com.nezammohandesi.hamrehenazer.data.model.ProjectDetail
import com.nezammohandesi.hamrehenazer.data.model.TbProject
import com.nezammohandesi.hamrehenazer.data.model.enum.RowType
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectDetailRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProjectDetailRepoImpl(
    private val projectDao: ProjectDao,
    private val gson: Gson

) : ProjectDetailRepository {
    override fun InsertProjectDetail(project: ProjectDetail) {
        var detail= gson.toJson(project)
        val projectDetail= TbProject( RowType.toInteger(RowType.ProjectDetail),detail)
        projectDao.insert(projectDetail)
    }

    override fun GetAllProjectDetailByProjId(projectId: Int): List<ProjectDetail> {
        val allProjectDetail=projectDao.getProjectWithType(RowType.toInteger(RowType.ProjectDetail)!!)
        if(allProjectDetail==null)
            return emptyList()
        val projectDetails = allProjectDetail.map { projDetails ->
            val parsed = gson.fromJson(projDetails.detail, ProjectDetail::class.java)
            parsed.Id = projDetails.id
            parsed
        }
        return projectDetails
    }

    override fun GetProjectDetailById(projDetailId: Int): ProjectDetail {
        val projectDetail=projectDao.getProjectWithId(projDetailId)
        val parsed = gson.fromJson(projectDetail.detail, ProjectDetail::class.java)
        parsed.Id=projectDetail.id
        return parsed
    }

    override fun DeleteProjecDetailtById(projectDetailId: Int) {
        projectDao.deleteProjectWithId(projectDetailId)
    }


}