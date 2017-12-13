package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.AllOf
import com.funivan.php.extremePhpInspections.constrains.Constrain
import com.funivan.php.extremePhpInspections.constrains.Not
import com.funivan.php.extremePhpInspections.constrains.method.aliases.InRegularClass
import com.funivan.php.extremePhpInspections.constrains.method.aliases.Internal
import com.funivan.php.extremePhpInspections.constrains.method.aliases.NamedConstructor
import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


class MethodFinalModifierInspection : PhpInspection() {

    override fun getShortName(): String {
        return "MethodFinalModifierInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, p1: Boolean): PsiElementVisitor {
        return MethodVisitor(
                AllOf(
                        Not(Internal()),
                        InRegularClass(),
                        Constrain({ it.modifier.isPublic && !it.isFinal }),
                        Not(NamedConstructor())
                ),
                "Method should be final",
                holder
        )
    }

}