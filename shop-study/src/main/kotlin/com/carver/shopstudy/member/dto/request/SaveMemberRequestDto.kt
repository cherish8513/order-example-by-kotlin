package com.carver.shopstudy.member.dto.request

import com.carver.shopstudy.common.entity.Address
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class SaveMemberRequestDto(
    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name:String ?= null,

    @field:NotEmpty
    var address:Address ?= null

)