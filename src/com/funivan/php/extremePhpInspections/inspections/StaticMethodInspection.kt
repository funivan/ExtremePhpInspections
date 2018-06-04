package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.AllOf
import com.funivan.php.extremePhpInspections.constrains.Not
import com.funivan.php.extremePhpInspections.constrains.method.Static
import com.funivan.php.extremePhpInspections.constrains.method.aliases.NamedConstructor
import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


class StaticMethodInspection : PhpInspection() {

    private val constrain = AllOf(
            Static(),
            Not(NamedConstructor())
    )

    override fun getShortName(): String {
        return "StaticMethodInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return MethodVisitor(
                constrain,
                "Do not write static methods",
                holder
        )
    }
}


