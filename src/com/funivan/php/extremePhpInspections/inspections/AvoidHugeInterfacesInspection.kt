package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.Constrain
import com.funivan.php.extremePhpInspections.visitors.ClassVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection

class AvoidHugeInterfacesInspection : PhpInspection() {

    override fun getShortName(): String {
        return "AvoidHugeInterfacesInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return ClassVisitor(
            Constrain({ it.isInterface && it.ownMethods.size > 10 }),
            "Interface contains more than 10 methods",
            holder
        )
    }
}