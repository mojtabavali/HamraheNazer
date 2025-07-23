package com.nezammohandesi.hamrehenazer.data.model

import com.nezammohandesi.hamrehenazer.data.model.enum.PostType
import java.util.Date

open class ProjectVisitDoc(
    var ProjectVisitId: Int,
    var DocPath: String,
    var CreatedDate: Date,
    var  Description: String?,
    var Id:Int

)
