package com.carver.shopstudy.member.repository;

import com.carver.shopstudy.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
    fun existsByName(name: String): Boolean
}