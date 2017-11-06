package com.funivan.php.extremePhpInspections.constrains

class NoneOf<T>(vararg private val constrains: ConstrainInterface<T>) : ConstrainInterface<T> {
    override fun valid(target: T): Boolean {
        return constrains.none { it.valid(target) }
    }
}