package com.funivan.php.extremePhpInspections.constrains


class AllOf<T>(vararg private val constrains: ConstrainInterface<T>) : ConstrainInterface<T> {
    override fun valid(target: T): Boolean {
        return constrains.all { it.valid(target) }
    }
}