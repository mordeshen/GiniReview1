package com.e.ginireview.model

data class NumberModel(
    val number: Int? = null,
    var isPairToResult0: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NumberModel) return false

        if (number != other.number) return false
        if (isPairToResult0 != other.isPairToResult0) return false

        return true
    }

    override fun hashCode(): Int {
        var result = number ?: 0
        result = 31 * result + isPairToResult0.hashCode()
        return result
    }

    override fun toString(): String {
        return "NumberModel(number=$number, isPairToResult0=$isPairToResult0)"
    }


}