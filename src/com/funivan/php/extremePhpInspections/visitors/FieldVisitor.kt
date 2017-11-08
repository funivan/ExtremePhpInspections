package com.funivan.php.extremePhpInspections.visitors

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.intellij.codeInspection.ProblemsHolder
import com.jetbrains.php.lang.psi.elements.Field
import com.jetbrains.php.lang.psi.visitors.PhpElementVisitor

class FieldVisitor(
        private val constraint: ConstrainInterface<Field>,
        private val message: String,
        private val holder: ProblemsHolder
) : PhpElementVisitor() {
    override fun visitPhpField(field: Field) {
        super.visitPhpField(field)
        val nameNode = field.nameNode
        if (nameNode != null && constraint.valid(field)) {
            holder.registerProblem(nameNode.psi, message)
        }
    }
}