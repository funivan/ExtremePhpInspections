package com.funivan.idea.php.extremePhpInspections.inspections

import com.funivan.idea.php.extremePhpInspections.constrains.Constrain
import com.funivan.idea.php.extremePhpInspections.visitors.FieldVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection

class PropertyVisibilityInspection : PhpInspection() {

    override fun getShortName(): String {
        return "PropertyVisibilityInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return FieldVisitor(
                com.funivan.idea.php.extremePhpInspections.constrains.Constrain({ !it.isConstant && !it.modifier.isPrivate }),
                "Property should be private",
                holder
        )
    }
}