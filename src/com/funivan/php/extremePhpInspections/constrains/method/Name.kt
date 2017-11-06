package com.funivan.php.extremePhpInspections.constrains.method

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.jetbrains.php.lang.psi.elements.Method


class Name(private val regex : Regex) : ConstrainInterface<Method> {

    override fun valid(target: Method): Boolean {
        return target.name.matches(regex)
    }
}