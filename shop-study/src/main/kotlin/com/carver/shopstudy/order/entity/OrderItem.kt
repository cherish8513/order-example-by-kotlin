package com.carver.shopstudy.order.entity

import com.carver.shopstudy.item.entity.Item
import javax.persistence.*


@Entity
class OrderItem(item: Item, orderPrice: Int, count: Int) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    var id: Long? = null
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    var item: Item = item
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order: Order? = null
        private set

    var orderPrice = orderPrice
        private set

    var count = count
        private set

    //==생성 메서드==//
    fun createOrderItem(item: Item, orderPrice: Int, count: Int): OrderItem? {
        val orderItem = OrderItem(item, orderPrice, count)
        item.removeStock(count)
        return orderItem
    }

    fun changeOrder(order: Order) {
        this.order = order
    }

    //==비지니스 로직==//
    fun cancel() {
        item.addStock(count)
    }

    //==조회 로직==//
    fun getTotalPrice(): Int {
        return orderPrice * count
    }
}