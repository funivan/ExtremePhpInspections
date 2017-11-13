package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.Constrain
import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


class AvoidProtectedMethodsInspection : PhpInspection() {

    override fun getShortName(): String {
        return "AvoidProtectedMethodsInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return MethodVisitor(
                Constrain({ it.modifier.isProtected }),
                "Do not write protected methods. Only public or private",
                holder
        )
    }
}