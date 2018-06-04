package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.OneOf
import com.funivan.php.extremePhpInspections.constrains.method.Name
import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


class MagicMethodInspection : PhpInspection() {
    override fun getShortName(): String {
        return "MagicMethodInspection"
    }


    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return MethodVisitor(
                OneOf(
                        Name(Regex("^__toString$")),
                        Name(Regex("^count"))
                ),
                "Avoid magic methods.",
                holder
        )
    }

}
