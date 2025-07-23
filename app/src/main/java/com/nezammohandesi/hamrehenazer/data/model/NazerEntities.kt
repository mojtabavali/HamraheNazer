package com.nezammohandesi.hamrehenazer.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nezammohandesi.hamrehenazer.data.model.enum.RowType

@Entity(tableName = "TB_PROJECT")
data class TbProject(
    @ColumnInfo(name = "TYPE", typeAffinity = ColumnInfo.INTEGER)
    val type: Int? = null,

    @ColumnInfo(name = "DETAIL", typeAffinity = ColumnInfo.TEXT)
    var detail: String? = null,

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)