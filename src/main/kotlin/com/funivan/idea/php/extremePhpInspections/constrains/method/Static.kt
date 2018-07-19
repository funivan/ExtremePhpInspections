package com.funivan.idea.php.extremePhpInspections.constrains.method

import com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface
import com.jetbrains.php.lang.psi.elements.Method


class Static : com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<Method> {
    override fun match(target: Method) = target.modifier.isStatic
}