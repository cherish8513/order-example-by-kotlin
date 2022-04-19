package com.carver.shopstudy.member.controller

import com.carver.shopstudy.member.dto.request.SaveMemberRequestDto
import com.carver.shopstudy.member.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/api/v1/members")
class MemberController(val memberService: MemberService) {

    @PostMapping
    @Throws(IllegalAccessException::class)
    fun saveMemberV2(@RequestBody request: @Valid SaveMemberRequestDto): ResponseEntity<Void> {
        memberService.join(request)
        return ResponseEntity.status(200).build()
    }
}