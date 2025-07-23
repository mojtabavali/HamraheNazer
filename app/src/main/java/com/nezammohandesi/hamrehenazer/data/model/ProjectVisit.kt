package com.nezammohandesi.hamrehenazer.data.model

import com.nezammohandesi.hamrehenazer.data.model.enum.PostType
import java.util.Date

open class ProjectVisit(
    var ProjectId: Int,
    var VisitDate: Date,
    var Description: String?,
    var Id:Int

)
