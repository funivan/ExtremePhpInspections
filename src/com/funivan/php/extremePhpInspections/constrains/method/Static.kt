package com.funivan.php.extremePhpInspections.constrains.method

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.jetbrains.php.lang.psi.elements.Method


class Static : ConstrainInterface<Method> {
    override fun match(target: Method) = target.modifier.isStatic
}