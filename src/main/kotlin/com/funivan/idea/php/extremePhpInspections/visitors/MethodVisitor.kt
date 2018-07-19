package com.funivan.idea.php.extremePhpInspections.visitors

import com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface
import com.intellij.codeInspection.ProblemsHolder
import com.jetbrains.php.lang.psi.elements.Method
import com.jetbrains.php.lang.psi.visitors.PhpElementVisitor

class MethodVisitor(
        private val constraint: com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<Method>,
        private val message: String,
        private val holder: ProblemsHolder
) : PhpElementVisitor() {
    override fun visitPhpMethod(method: Method) {
        super.visitPhpMethod(method)
        val nameNode = method.nameNode
        if (nameNode != null && constraint.match(method)) {
            holder.registerProblem(nameNode.psi, message)
        }
    }
}