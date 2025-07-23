package com.nezammohandesi.hamrehenazer.data.repositories.Interfaces

import com.nezammohandesi.hamrehenazer.data.model.ProjectVisitDoc

interface ProjectVisitDocRepository {
    fun InsertProjectVisitDoc(project: ProjectVisitDoc)
    fun GetAllProjectVisitDocByProjId(projectId:Int): List<ProjectVisitDoc>
    fun GetProjectVisitDocById(projVisitId:Int): ProjectVisitDoc
    fun DeleteProjecVisittById(ProjectVisitDocId:Int)
}