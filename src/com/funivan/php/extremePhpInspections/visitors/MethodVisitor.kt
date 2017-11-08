package com.funivan.php.extremePhpInspections.visitors

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.intellij.codeInspection.ProblemsHolder
import com.jetbrains.php.lang.psi.elements.Method
import com.jetbrains.php.lang.psi.visitors.PhpElementVisitor

class MethodVisitor(
        private val constraint: ConstrainInterface<Method>,
        private val message: String,
        private val holder: ProblemsHolder
) : PhpElementVisitor() {
    override fun visitPhpMethod(method: Method) {
        super.visitPhpMethod(method)
        val nameNode = method.nameNode
        if (nameNode != null && constraint.valid(method)) {
            holder.registerProblem(nameNode.psi, message)
        }
    }
}