package com.carver.shopstudy.order.entity

import com.carver.shopstudy.common.entity.Address
import javax.persistence.*

@Entity
class Delivery(address: Address) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    var id: Long? = null
        private set

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    var order: Order? = null
        private set

    @Embedded
    var address: Address = address
        private set

    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus = DeliveryStatus.READY
        private set

    fun changeOrder(order: Order) {
        this.order = order
    }
}