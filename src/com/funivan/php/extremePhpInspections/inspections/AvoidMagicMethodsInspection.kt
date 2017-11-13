package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.method.Name
import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


class AvoidMagicMethodsInspection : PhpInspection() {
    override fun getShortName(): String {
        return "AvoidMagicMethodsInspection"
    }


    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return MethodVisitor(
                Name(Regex("^__toString$")),
                "Avoid __toString",
                holder
        )
    }

}
