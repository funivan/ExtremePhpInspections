package com.funivan.idea.php.extremePhpInspections.inspections

import com.funivan.idea.php.extremePhpInspections.constrains.AllOf
import com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface
import com.funivan.idea.php.extremePhpInspections.constrains.Not
import com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.InRegularClass
import com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.Internal
import com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.NamedConstructor
import com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.Public
import com.funivan.idea.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection
import com.jetbrains.php.lang.psi.elements.Method


class MethodDeclarationInspection : PhpInspection() {
    override fun getShortName() = "MethodDeclarationInspection"

    private val notDeclaredInInterfaceConstrain = object : com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<Method> {
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


    override fun buildVisitor(holder: ProblemsHolder, p1: Boolean): PsiElementVisitor {
        return MethodVisitor(
                com.funivan.idea.php.extremePhpInspections.constrains.AllOf(
                        com.funivan.idea.php.extremePhpInspections.constrains.Not(com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.Internal()),
                        com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.InRegularClass(),
                        com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.Public(),
                        com.funivan.idea.php.extremePhpInspections.constrains.Not(com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.NamedConstructor()),
                        this.notDeclaredInInterfaceConstrain
                ),
                "Method should be declared in the interface",
                holder
        )
    }

}