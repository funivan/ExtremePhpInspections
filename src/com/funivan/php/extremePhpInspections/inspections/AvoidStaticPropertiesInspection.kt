package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.Constrain
import com.funivan.php.extremePhpInspections.visitors.FieldVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor

class AvoidStaticPropertiesInspection : BaseInspection() {

    override fun getShortName(): String {
        return "AvoidStaticPropertiesInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return FieldVisitor(
                Constrain({ it.modifier.isStatic }),
                "Do not write static properties",
                holder
        )
    }
}