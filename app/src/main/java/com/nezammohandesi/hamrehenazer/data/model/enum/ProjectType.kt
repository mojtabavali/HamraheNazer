package com.nezammohandesi.hamrehenazer.data.model.enum

enum class ProjectType(private val type: Int)  {
    Current(1),
    Archived(2);

    companion object {

        fun fromInteger(x: Int): ProjectType? {
            when (x) {
                1 -> return Current
                2 -> return Archived

            }
            return null
        }

        fun toInteger(x: ProjectType): Int? {
            return when (x) {
                Current -> 1
                Archived-> 2

            }

        }
    }
}