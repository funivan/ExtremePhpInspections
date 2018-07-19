package com.funivan.idea.php.extremePhpInspections.inspections

import com.funivan.idea.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


class StaticMethodInspection : PhpInspection() {

    private val constrain = com.funivan.idea.php.extremePhpInspections.constrains.AllOf(
            com.funivan.idea.php.extremePhpInspections.constrains.method.Static(),
            com.funivan.idea.php.extremePhpInspections.constrains.Not(com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.NamedConstructor())
    )

    override fun getShortName(): String {
        return "StaticMethodInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return MethodVisitor(
                constrain,
                "Do not write static methods",
                holder
        )
    }
}


