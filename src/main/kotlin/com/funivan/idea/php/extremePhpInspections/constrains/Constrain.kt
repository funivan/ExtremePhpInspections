package com.funivan.idea.php.extremePhpInspections.constrains


class Constrain<T>(private val constrain: (T) -> Boolean) : com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<T> {
    override fun match(target: T): Boolean {
        return constrain(target)
    }
}