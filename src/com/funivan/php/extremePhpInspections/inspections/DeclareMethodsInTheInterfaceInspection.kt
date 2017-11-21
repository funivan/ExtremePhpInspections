package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.AllOf
import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.funivan.php.extremePhpInspections.constrains.Not
import com.funivan.php.extremePhpInspections.constrains.method.aliases.InRegularClass
import com.funivan.php.extremePhpInspections.constrains.method.aliases.Internal
import com.funivan.php.extremePhpInspections.constrains.method.aliases.NamedConstructor
import com.funivan.php.extremePhpInspections.constrains.method.aliases.Public
import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection
import com.jetbrains.php.lang.psi.elements.Method


class DeclareMethodsInTheInterfaceInspection : PhpInspection() {
    private val notDeclaredInInterfaceConstrain = object : ConstrainInterface<Method> {
        override fun match(target: Method): Boolean {
            var match = false
            val baseClass = target.containingClass
            if (baseClass != null) {
                match = !baseClass.implementedInterfaces.any {
                    it.findMethodByName(target.name) != null
                }
            }
            return match
        }
    }

    override fun getShortName(): String {
        return "DeclareMethodsInTheInterfaceInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, p1: Boolean): PsiElementVisitor {
        return MethodVisitor(
            AllOf(
                Not(Internal()),
                InRegularClass(),
                Public(),
                Not(NamedConstructor()),
                this.notDeclaredInInterfaceConstrain
            ),
            "Method should be declared in the interface",
            holder
        )
    }

}