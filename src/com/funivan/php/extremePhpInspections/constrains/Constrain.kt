package com.funivan.php.extremePhpInspections.constrains


class Constrain<T>(private val constrain: (T) -> Boolean) : ConstrainInterface<T> {
    override fun valid(target: T): Boolean {
        return constrain(target)
    }
}