package com.funivan.php.extremePhpInspections.constrains

class Not<T>(private val constrain: ConstrainInterface<T>) : ConstrainInterface<T> {
    override fun valid(target: T): Boolean {
        return !constrain.valid(target)
    }
}