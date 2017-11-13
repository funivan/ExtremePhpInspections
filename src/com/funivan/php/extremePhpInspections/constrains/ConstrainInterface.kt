package com.funivan.php.extremePhpInspections.constrains


interface ConstrainInterface<T> {
    fun match(target: T): Boolean
    infix fun and(next: ConstrainInterface<T>): ConstrainInterface<T> {
        return AllOf(this, next)
    }
    infix fun andNot(next: ConstrainInterface<T>): ConstrainInterface<T> {
        return AllOf(this, Not(next))
    }
}