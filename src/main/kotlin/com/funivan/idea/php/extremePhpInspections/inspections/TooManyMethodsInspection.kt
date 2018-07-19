package com.funivan.idea.php.extremePhpInspections.inspections

import com.funivan.idea.php.extremePhpInspections.constrains.Constrain
import com.funivan.idea.php.extremePhpInspections.visitors.ClassVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection

class TooManyMethodsInspection : PhpInspection() {

    override fun getShortName(): String {
        return "TooManyMethodsInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return ClassVisitor(
                Constrain({ it.isInterface && it.ownMethods.size > 10 }),
                "Interface contains more than 10 methods",
                holder
        )
    }
}