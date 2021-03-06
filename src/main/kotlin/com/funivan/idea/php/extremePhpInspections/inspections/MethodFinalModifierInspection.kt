package com.funivan.idea.php.extremePhpInspections.inspections

import com.funivan.idea.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


/**
 * @todo check if class if final
 */
class MethodFinalModifierInspection : PhpInspection() {

    override fun getShortName(): String {
        return "MethodFinalModifierInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, p1: Boolean): PsiElementVisitor {
        return MethodVisitor(
                com.funivan.idea.php.extremePhpInspections.constrains.AllOf(
                        com.funivan.idea.php.extremePhpInspections.constrains.Not(com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.Internal()),
                        com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.InRegularClass(),
                        com.funivan.idea.php.extremePhpInspections.constrains.Constrain({ it.modifier.isPublic && !it.isFinal }),
                        com.funivan.idea.php.extremePhpInspections.constrains.Not(com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.NamedConstructor())
                ),
                "Method should be final",
                holder
        )
    }

}