package com.carver.shopstudy.member.entity

import com.carver.shopstudy.common.entity.Address
import com.carver.shopstudy.order.entity.Order
import javax.persistence.*

@Entity
class Member(name: String, address: Address) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    val id: Long? = null

    var name: String = name
        private set

    @Embedded
    var address: Address = address
        private set

    @OneToMany(mappedBy = "member")
    val orders = mutableListOf<Order>()

}