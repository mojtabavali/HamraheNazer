package com.nezammohandesi.hamrehenazer.data.model.enum

enum class RowType(private val type: Int) {

    Project(1),
    ProjectDetail(2),
    ProjectDocument(3),
    ProjectVisit(4),
    ProjectVisitDoc(5);

    companion object {

        fun fromInteger(x: Int): RowType? {
            when (x) {
                1 -> return Project
                2 -> return ProjectDetail
                3 -> return ProjectDocument
                4 -> return ProjectVisit
                5 -> return Project
            }
            return null
        }

        fun toInteger(x: RowType): Int? {
            return when (x) {
               Project -> 1
                ProjectDetail-> 2
                ProjectDocument->3
                ProjectVisit->4
                ProjectVisitDoc->5
            }

        }
    }
}