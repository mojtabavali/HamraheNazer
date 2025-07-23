package com.nezammohandesi.hamrehenazer.data.model

import com.nezammohandesi.hamrehenazer.data.model.enum.PostType
import java.util.Date

open class ProjectDoc(
    var ProjectId: Int,
    var DocPath: String?,
    var createdDate: Date,
    var SignatureDate: Date?,
    var Description: String?,
    var Id:Int

)
