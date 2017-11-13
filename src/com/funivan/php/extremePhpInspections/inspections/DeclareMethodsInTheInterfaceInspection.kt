package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.psi.elements.Method


class DeclareMethodsInTheInterfaceInspection : BaseInspection() {

    override fun getShortName(): String {
        return "DeclareMethodsInTheInterfaceInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, p1: Boolean): PsiElementVisitor {
        return MethodVisitor(
                object : ConstrainInterface<Method> {
                    override fun match(target: Method): Boolean {
                        var match = false
                        if (target.modifier.isPublic && target.isInternal) {
                            val baseClass = target.containingClass
                            if (baseClass != null && !baseClass.isInterface) {
                                match = !baseClass.implementedInterfaces.any {
                                    it.findMethodByName(target.name) != null
                                }
                            }
                        }
                        return match
                    }
                },
                "Method should be defined in the interface",
                holder
        )
    }

}