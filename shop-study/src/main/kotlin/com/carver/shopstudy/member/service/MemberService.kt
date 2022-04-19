package com.carver.shopstudy.member.service

import com.carver.shopstudy.member.entity.Member
import com.carver.shopstudy.member.repository.MemberRepository

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class MemberService(private val memberRepository: MemberRepository) {

    @Transactional
    @Throws(IllegalAccessException::class)
    fun join(member: Member) {
        validateDuplicateMember(member)
        memberRepository.save(member)
    }

    @Throws(IllegalAccessException::class)
    private fun validateDuplicateMember(member: Member) {
        if (memberRepository.existsByName(member.name)) {
            throw IllegalAccessException("이미 존재하는 회원입니다.")
        }
    }

    @Transactional
    fun changeName(id: Long, name: String) {
        val member : Member = memberRepository.findById(id).orElseThrow()
        member.changeName(name)
    }
}