package com.funivan.idea.php.extremePhpInspections.constrains


class AllOf<T>(vararg private val constrains: com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<T>) : com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<T> {
    override fun match(target: T): Boolean {
        return constrains.all { it.match(target) }
    }
}