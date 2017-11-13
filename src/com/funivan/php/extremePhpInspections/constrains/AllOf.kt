package com.funivan.php.extremePhpInspections.constrains


class AllOf<T>(vararg private val constrains: ConstrainInterface<T>) : ConstrainInterface<T> {
    override fun match(target: T): Boolean {
        return constrains.all { it.match(target) }
    }
}