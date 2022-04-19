package com.carver.shopstudy.order.entity

import com.carver.shopstudy.member.entity.Member
import com.querydsl.core.annotations.QueryEntity
import javax.persistence.*


@QueryEntity
@Table(name = "orders")
@Entity
class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    var id: Long? = null
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member? = null
        private set

    @OneToMany(mappedBy = "order", cascade = [CascadeType.PERSIST])
    val orderItems = mutableListOf<OrderItem>()

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "delivery_id")
    var delivery: Delivery? = null
        private set

    @Enumerated(EnumType.STRING)
    private var status: OrderStatus = OrderStatus.ORDER

    fun createOrder(member: Member, delivery: Delivery, vararg orderItems: OrderItem): Order {
        val order = Order()
        order.changeMember(member)
        order.addDelivery(delivery)
        for (orderItem in orderItems) {
            order.addOrderItem(orderItem)
        }
        return order
    }

    fun cancel() {
        if (delivery?.status == DeliveryStatus.COMP) {
            throw IllegalStateException("이미 배송이 완료된 상품은 취소가 불가능합니다.")
        }
        this.changeStatus(OrderStatus.CANCEL)
        for (orderItem in orderItems) {
            orderItem.cancel()
        }
    }

    fun changeMember(member: Member) {
        this.member = member
        member.orders.add(this)
    }

    fun addOrderItem(orderItem: OrderItem) {
        orderItems.add(orderItem)
        orderItem.changeOrder(this)
    }

    fun addDelivery(delivery: Delivery) {
        this.delivery = delivery
        delivery.changeOrder(this)
    }

    fun changeStatus(orderStatus: OrderStatus) {
        this.status = orderStatus
    }
}
