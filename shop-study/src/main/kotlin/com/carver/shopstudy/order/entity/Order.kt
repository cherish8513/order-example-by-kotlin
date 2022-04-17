package com.carver.shopstudy.order.entity

import com.carver.shopstudy.member.entity.Member
import lombok.AccessLevel
import lombok.NoArgsConstructor
import javax.persistence.*


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private val id: Long ?= null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private var member:Member ?= null


}