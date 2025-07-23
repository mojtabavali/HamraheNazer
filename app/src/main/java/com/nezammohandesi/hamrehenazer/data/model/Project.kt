package com.nezammohandesi.hamrehenazer.data.model

import com.nezammohandesi.hamrehenazer.data.model.enum.ProjectType
import java.util.Date

open class Project (
    var Code: String,
    var Lat:Long?,
    var Long: Long?,
    var CreatedDate: Date,
    var CommitmentDate: Date?,
    var CommitmentFilePath: String?,
    var Type: ProjectType,
    var Id:Int

)
