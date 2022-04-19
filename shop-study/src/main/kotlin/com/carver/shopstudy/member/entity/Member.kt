package com.carver.shopstudy.member.entity

import com.carver.shopstudy.common.entity.Address
import com.carver.shopstudy.order.entity.Order
import com.querydsl.core.annotations.QueryEntity
import javax.persistence.*

@QueryEntity
@Entity
class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    val id: Long? = null

    var name: String? = null
        private set

    @Embedded
    var address: Address? = null
        private set

    @OneToMany(mappedBy = "member")
    val orders = mutableListOf<Order>()

    fun createMember(name: String, address: Address): Member {
        val member = Member()
        member.changeName(name)
        member.changeAddress(address)

        return member
    }

    fun changeName(name: String) {
        this.name = name
    }

    fun changeAddress(address: Address) {
        this.address = address
    }
}