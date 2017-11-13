package com.funivan.php.extremePhpInspections.constrains.method

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.jetbrains.php.lang.psi.elements.ClassReference
import com.jetbrains.php.lang.psi.elements.Method
import com.jetbrains.php.lang.psi.elements.PhpClass

class ReturnSelf : ConstrainInterface<Method> {
    override fun match(target: Method): Boolean {
        var returnSelf = false
        val returnType = target.returnType
        if (returnType is ClassReference) {
            val containingClass = target.getContainingClass()
            if (containingClass is PhpClass) {
                returnSelf = returnType.fqn.equals(containingClass.fqn)
            }
        }
        return returnSelf
    }
}