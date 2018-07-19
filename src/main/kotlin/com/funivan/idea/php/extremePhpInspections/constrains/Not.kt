package com.funivan.idea.php.extremePhpInspections.constrains

class Not<T>(private val constrain: com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<T>) : com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<T> {
    override fun match(target: T): Boolean {
        return !constrain.match(target)
    }
}