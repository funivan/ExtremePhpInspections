package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.Not
import com.funivan.php.extremePhpInspections.constrains.method.Static
import com.funivan.php.extremePhpInspections.constrains.method.aliases.NamedConstructor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.psi.elements.Method
import com.jetbrains.php.lang.psi.visitors.PhpElementVisitor

class AvoidStaticMethodsInspection : BaseInspection() {
    private val constrain = Static() andNot Not(NamedConstructor(Regex("^create[.]+$")))

    override fun getShortName(): String {
        return "AvoidStaticMethodsInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PhpElementVisitor() {
            override fun visitPhpMethod(method: Method) {
                super.visitPhpMethod(method)
                val nameNode = method.nameNode
                if (nameNode != null && constrain.valid(method)) {
                    holder.registerProblem(nameNode.psi, "$emoji Do not write static methods")
                }
            }
        }
    }
}


