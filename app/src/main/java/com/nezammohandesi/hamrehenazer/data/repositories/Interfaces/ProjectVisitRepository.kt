package com.nezammohandesi.hamrehenazer.data.repositories.Interfaces

import com.nezammohandesi.hamrehenazer.data.model.ProjectVisit

interface ProjectVisitRepository {
    fun InsertProjectVisit(project: ProjectVisit)
    fun GetAllProjectVisitByProjId(projectId:Int): List<ProjectVisit>
    fun GetProjectVisitById(projVisitId:Int): ProjectVisit
    fun DeleteProjectVisitById(projectVisitId:Int)
}