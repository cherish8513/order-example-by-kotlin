package com.carver.shopstudy.member.service

import com.carver.shopstudy.member.dto.request.SaveMemberRequestDto
import com.carver.shopstudy.member.entity.Member
import com.carver.shopstudy.member.repository.MemberRepository

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional(readOnly = true)
class MemberService(val memberRepository: MemberRepository) {

    @Transactional
    @Throws(IllegalAccessException::class)
    fun join(requestDto: SaveMemberRequestDto) {
        validateDuplicateMemberByName(requestDto.name)
        memberRepository.save(Member().createMember(requestDto.name, requestDto.address))
    }

    @Throws(IllegalAccessException::class)
    private fun validateDuplicateMemberByName(name: String) {
        if (memberRepository.existsByName(name)) {
            throw IllegalAccessException("이미 존재하는 회원입니다.")
        }
    }

    @Transactional
    fun changeName(id: Long, name: String) {
        val member: Member = memberRepository.findById(id).orElseThrow()
        member.changeName(name)
    }
}