package com.funivan.idea.php.extremePhpInspections.constrains


class OneOf<T>(vararg private val constrains: com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<T>) : com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<T> {
    override fun match(target: T): Boolean {
        return constrains.any { it.match(target) }
    }
}