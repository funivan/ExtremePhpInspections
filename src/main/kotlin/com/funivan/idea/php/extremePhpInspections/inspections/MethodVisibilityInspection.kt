package com.funivan.idea.php.extremePhpInspections.inspections

import com.funivan.idea.php.extremePhpInspections.constrains.Constrain
import com.funivan.idea.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


class MethodVisibilityInspection : PhpInspection() {

    override fun getShortName(): String {
        return "MethodVisibilityInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return MethodVisitor(
                com.funivan.idea.php.extremePhpInspections.constrains.Constrain({ it.modifier.isProtected }),
                "Do not write protected methods. Only public or private",
                holder
        )
    }
}