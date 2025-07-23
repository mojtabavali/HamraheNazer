package com.nezammohandesi.hamrehenazer.data.repositories.Interfaces

import com.nezammohandesi.hamrehenazer.data.model.ProjectDoc

interface ProjectDocumentlRepository {
    fun InsertProjectDocument(project: ProjectDoc)
    fun GetAllProjectDocByProjId(projectId:Int): List<ProjectDoc>
    fun GetProjectDocById(projectDocId:Int): ProjectDoc
    fun DeleteProjecDoctById(projectDocId:Int)
}