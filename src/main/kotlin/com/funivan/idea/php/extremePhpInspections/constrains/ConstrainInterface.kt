package com.funivan.idea.php.extremePhpInspections.constrains


interface ConstrainInterface<T> {
    fun match(target: T): Boolean
    infix fun and(next: com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<T>): com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<T> {
        return com.funivan.idea.php.extremePhpInspections.constrains.AllOf(this, next)
    }

}