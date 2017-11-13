package com.funivan.php.extremePhpInspections.constrains.method.aliases

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.jetbrains.php.lang.psi.elements.Method


class InRegularClass : ConstrainInterface<Method> {
    override fun match(target: Method): Boolean {
        val baseClass = target.containingClass
        var result = false
        if (baseClass != null) {
            result = !baseClass.isAbstract && !baseClass.isInterface && !baseClass.isTrait && !baseClass.isAnonymous
        }
        return result
    }
}