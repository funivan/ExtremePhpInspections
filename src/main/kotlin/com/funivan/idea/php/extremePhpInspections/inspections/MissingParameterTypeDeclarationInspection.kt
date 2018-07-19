package com.funivan.idea.php.extremePhpInspections.inspections

import com.funivan.idea.php.extremePhpInspections.constrains.Constrain
import com.funivan.idea.php.extremePhpInspections.visitors.ParameterVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


class MissingParameterTypeDeclarationInspection : PhpInspection() {

    override fun getShortName(): String {
        return "MissingParameterTypeDeclarationInspection"
    }


    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return ParameterVisitor(
                com.funivan.idea.php.extremePhpInspections.constrains.Constrain({ it.declaredType.size() == 0 }),
                "Missing parameter type declaration",
                holder
        )
    }

}
