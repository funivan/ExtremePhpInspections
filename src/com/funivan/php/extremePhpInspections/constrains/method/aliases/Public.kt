package com.funivan.php.extremePhpInspections.constrains.method.aliases

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.jetbrains.php.lang.psi.elements.Method


class Public : ConstrainInterface<Method> {
    override fun match(target: Method) = target.modifier.isPublic
}