package com.nezammohandesi.hamrehenazer.data.model

import com.nezammohandesi.hamrehenazer.data.model.enum.PostType
import java.util.Date

open class ProjectDetail(
    var ProjectId: Int,
    var Name: String?,
    var PostType: PostType?,
    var Phone: Long,
    var  Description: String?,
    var Id:Int=0

)
