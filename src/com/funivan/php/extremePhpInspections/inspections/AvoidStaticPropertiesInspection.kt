package com.funivan.php.extremePhpInspections.inspections

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.psi.elements.Field
import com.jetbrains.php.lang.psi.visitors.PhpElementVisitor

class AvoidStaticPropertiesInspection : BaseInspection() {

    override fun getShortName(): String {
        return "AvoidStaticPropertiesInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PhpElementVisitor() {
            override fun visitPhpField(field: Field) {
                super.visitPhpField(field)
                val nameNode = field.nameNode
                if (nameNode != null && field.modifier.isStatic) {
                    holder.registerProblem(nameNode.psi, "$emoji Do not write static properties")
                }
            }
        }
    }
}