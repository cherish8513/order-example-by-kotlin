package com.carver.shopstudy.member.repository

import com.carver.shopstudy.common.entity.Address
import com.carver.shopstudy.member.entity.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.transaction.Transactional

@DataJpaTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    fun memberRepositoryIsNotNull() {
        Assertions.assertThat(memberRepository).isNotNull
    }

    @Test
    @Throws(Exception::class)
    fun 유저생성() {
        //given
        val address = Address("seoul", "street", "zipcode")
        val member = Member().createMember("name", address)

        //when
        memberRepository.save(member)

        //then
        Assertions.assertThat(memberRepository.count()).isEqualTo(1L);
    }
}