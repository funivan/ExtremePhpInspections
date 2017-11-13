package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.Constrain
import com.funivan.php.extremePhpInspections.visitors.FieldVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection

class AvoidPublicOrProtectedPropertiesInspection : PhpInspection() {

    override fun getShortName(): String {
        return "AvoidPublicOrProtectedPropertiesInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return FieldVisitor(
                Constrain({ !it.isConstant && !it.modifier.isPrivate }),
                "Property should be private",
                holder
        )
    }
}