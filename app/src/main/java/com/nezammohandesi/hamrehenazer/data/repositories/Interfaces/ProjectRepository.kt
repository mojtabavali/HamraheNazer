package com.edsab.pm.repository

import com.nezammohandesi.hamrehenazer.data.model.Project

interface ProjectRepository {
    fun InsertProject(project: Project)
    fun GetAllCurrentProject(): List<Project>
    fun GetAllArchivedProject():List<Project>
    fun GetProjectById(projId:Int): Project
    fun DeleteProjectById(projectId:Int)

}