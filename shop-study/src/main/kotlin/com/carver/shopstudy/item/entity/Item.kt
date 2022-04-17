package com.carver.shopstudy.item.entity

import com.carver.shopstudy.exception.NotEnoughStockException
import javax.persistence.*


@Entity
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    var id: Long? = null
        private set

    var name: String? = null
        private set

    var price = 0
        private set

    var stockQuantity = 0
        private set

    fun addStock(quantity: Int) {
        stockQuantity += quantity
    }

    fun removeStock(quantity: Int) {
        val restStock = stockQuantity - quantity
        if (restStock < 0) {
            throw NotEnoughStockException("재고량이 부족합니다.")
        }
        stockQuantity = restStock
    }
}