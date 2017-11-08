package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.funivan.php.extremePhpInspections.constrains.Not
import com.funivan.php.extremePhpInspections.constrains.method.Static
import com.funivan.php.extremePhpInspections.constrains.method.aliases.NamedConstructor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor

class AvoidStaticMethodsInspection : BaseInspection() {

    private val constrain = Static() andNot Not(NamedConstructor(Regex("^create[.]+$")))

    override fun getShortName(): String {
        return "AvoidStaticMethodsInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return MethodVisitor(
                constrain,
                "Do not write static methods",
                holder
        )
    }
}


