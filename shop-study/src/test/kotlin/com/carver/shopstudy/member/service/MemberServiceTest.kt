package com.carver.shopstudy.member.service

import com.carver.shopstudy.common.entity.Address
import com.carver.shopstudy.member.entity.Member
import com.carver.shopstudy.member.repository.MemberRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberServiceTest {
    @Autowired
    lateinit var memberService: MemberService

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    @Throws(Exception::class)
    fun memberServiceIsNotNull() {
        assertThat(memberService).isNotNull
    }

    @Test
    @Throws(Exception::class)
    fun 회원가입_성공() {
        //given
        val address = Address("seoul", "street", "zipcode")
        val member = Member("name", address)

        //when
        memberService.join(member)

        //then
        assertThat(memberRepository.count()).isEqualTo(1)
    }

}