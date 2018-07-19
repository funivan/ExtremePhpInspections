package com.funivan.idea.php.extremePhpInspections.constrains.method.aliases

import com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface
import com.jetbrains.php.lang.psi.elements.Method


class Public : com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<Method> {
    override fun match(target: Method) = target.modifier.isPublic
}