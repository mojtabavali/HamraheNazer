package com.edsab.pm.repository


import com.nezammohandesi.hamrehenazer.data.dao.ProjectDao
import com.nezammohandesi.hamrehenazer.data.model.Project
import com.nezammohandesi.hamrehenazer.data.model.ProjectDoc
import com.nezammohandesi.hamrehenazer.data.model.TbProject
import com.nezammohandesi.hamrehenazer.data.model.enum.ProjectType
import com.nezammohandesi.hamrehenazer.data.model.enum.RowType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProjectRepoImpl(
    private val projectDao: ProjectDao,
    private val gson: Gson

) : ProjectRepository {
    override fun InsertProject(project: Project) {
        var detail= gson.toJson(project)
        val project= TbProject( RowType.toInteger(RowType.Project),detail)
        projectDao.insert(project)
    }

    override fun GetAllCurrentProject(): List<Project> {
        val allProject=projectDao.getProjectWithType(RowType.toInteger(RowType.Project)!!)
        if(allProject==null)
            return emptyList()
        val projectDoc = allProject.map { projDetails ->
            val parsed = gson.fromJson(projDetails.detail, Project::class.java)
            parsed.Id = projDetails.id
            parsed
        }
        return projectDoc.filter { it.Type== ProjectType.Current }
    }

    override fun GetAllArchivedProject(): List<Project> {
        val allProject=projectDao.getProjectWithType(RowType.toInteger(RowType.Project)!!)
        if(allProject==null)
            return emptyList()
        val projectDoc = allProject.map { projDetails ->
            val parsed = gson.fromJson(projDetails.detail, Project::class.java)
            parsed.Id = projDetails.id
            parsed
        }
        return projectDoc.filter { it.Type== ProjectType.Archived }
    }

    override fun GetProjectById(projId: Int): Project {
        val project=projectDao.getProjectWithId(projId)
        val parsed = gson.fromJson(project.detail, Project::class.java)
        parsed.Id=project.id
        return parsed
    }

    override fun DeleteProjectById(projectId: Int) {
        projectDao.deleteProjectWithId(projectId)
    }


}