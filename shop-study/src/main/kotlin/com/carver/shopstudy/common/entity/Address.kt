package com.carver.shopstudy.common.entity

import javax.persistence.Embeddable

@Embeddable
class Address(city: String, street: String, zipcode: String) {
    private var city: String = city
    private var street: String = street
    private var zipcode: String = zipcode
}