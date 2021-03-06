package com.funivan.idea.php.extremePhpInspections.inspections.magicMethod

import com.funivan.idea.php.extremePhpInspections.constrains.OneOf
import com.funivan.idea.php.extremePhpInspections.constrains.method.Name
import com.funivan.idea.php.extremePhpInspections.visitors.MethodVisitor
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
                        Name(Regex("^__toString$"))
                ),
                "Avoid magic methods.",
                holder
        )
    }

}
