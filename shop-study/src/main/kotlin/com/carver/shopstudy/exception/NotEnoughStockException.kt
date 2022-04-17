package com.carver.shopstudy.exception

class NotEnoughStockException : RuntimeException {
    constructor() : super()
    constructor(message: String) : super(message)
}