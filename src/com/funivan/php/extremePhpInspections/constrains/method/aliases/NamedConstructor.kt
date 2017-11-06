package com.funivan.php.extremePhpInspections.constrains.method.aliases

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.funivan.php.extremePhpInspections.constrains.method.Name
import com.funivan.php.extremePhpInspections.constrains.method.ReturnSelf
import com.jetbrains.php.lang.psi.elements.Method


class NamedConstructor(regex: Regex) : ConstrainInterface<Method> {
    private val constrains = Name(regex) and ReturnSelf()
    override fun valid(target: Method) = constrains.valid(target)
}