package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.Constrain
import com.funivan.php.extremePhpInspections.visitors.FieldVisitor
import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor

class AvoidPublicOrProtectedPropertiesInspection : BaseInspection() {

    override fun getShortName(): String {
        return "AvoidPublicOrProtectedPropertiesInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return FieldVisitor(
                Constrain({ !it.modifier.isPrivate }),
                "Property should be private",
                holder
        )
    }
}