package com.nezammohandesi.hamrehenazer.data.repositories.Interfaces

import com.nezammohandesi.hamrehenazer.data.model.ProjectDetail

interface ProjectDetailRepository {
    fun InsertProjectDetail(project: ProjectDetail)
    fun GetAllProjectDetailByProjId(projectId:Int): List<ProjectDetail>
    fun GetProjectDetailById(projDetailId:Int): ProjectDetail
    fun DeleteProjecDetailtById(projectDetailId:Int)
}