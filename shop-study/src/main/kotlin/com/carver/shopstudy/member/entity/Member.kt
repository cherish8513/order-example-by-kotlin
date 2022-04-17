package com.carver.shopstudy.member.entity

import com.carver.shopstudy.order.entity.Order
import lombok.AccessLevel
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
class Member(name:String, address: Address) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private val id: Long? = null

    private var name:String = name

    @Embedded
    private var address:Address = address

    @OneToMany(mappedBy = "member")
    private val orders: List<Order> = listOf()

}