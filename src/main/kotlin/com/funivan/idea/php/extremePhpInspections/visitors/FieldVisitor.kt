package com.funivan.idea.php.extremePhpInspections.visitors

import com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface
import com.intellij.codeInspection.ProblemsHolder
import com.jetbrains.php.lang.psi.elements.Field
import com.jetbrains.php.lang.psi.visitors.PhpElementVisitor

class FieldVisitor(
        private val constraint: com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<Field>,
        private val message: String,
        private val holder: ProblemsHolder
) : PhpElementVisitor() {
    override fun visitPhpField(field: Field) {
        super.visitPhpField(field)
        val nameNode = field.nameNode
        if (nameNode != null && constraint.match(field)) {
            holder.registerProblem(nameNode.psi, message)
        }
    }
}