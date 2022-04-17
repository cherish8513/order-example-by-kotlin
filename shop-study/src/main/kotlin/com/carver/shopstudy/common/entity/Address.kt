package com.carver.shopstudy.common.entity

import lombok.AccessLevel
import lombok.NoArgsConstructor
import javax.persistence.Embeddable

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Address(city: String, street: String, zipcode: String) {
    private var city: String = city
    private var street: String = street
    private var zipcode: String = zipcode
}