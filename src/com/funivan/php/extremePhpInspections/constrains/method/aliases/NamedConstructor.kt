package com.funivan.php.extremePhpInspections.constrains.method.aliases

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.funivan.php.extremePhpInspections.constrains.method.Name
import com.jetbrains.php.lang.psi.elements.ClassReference
import com.jetbrains.php.lang.psi.elements.Method
import com.jetbrains.php.lang.psi.elements.PhpClass


class NamedConstructor : ConstrainInterface<Method> {
    private val constrains = Name(Regex("^create.*$"))
    override fun match(target: Method): Boolean {
        var result = false
        if (constrains.match(target)) {
            val returnType = target.returnType
            if (returnType is ClassReference) {
                val containingClass = target.containingClass
                if (containingClass is PhpClass) {
                    val returnTypeFQN = returnType.fqn
                    result = (
                            returnType.fqn.equals(containingClass.fqn)
                                    || containingClass.implementedInterfaces.any { it.fqn == returnTypeFQN }
                            )
                }
            }
        }
        return result
    }

}