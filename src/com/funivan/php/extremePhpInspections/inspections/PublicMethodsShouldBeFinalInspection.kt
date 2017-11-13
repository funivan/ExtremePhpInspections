package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.Constrain
import com.funivan.php.extremePhpInspections.constrains.Not
import com.funivan.php.extremePhpInspections.constrains.method.aliases.InRegularClass
import com.funivan.php.extremePhpInspections.constrains.method.aliases.Internal
import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.psi.elements.Method

class PublicMethodsShouldBeFinalInspection : BaseInspection() {

    override fun getShortName(): String {
        return "PublicMethodsShouldBeFinalInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, p1: Boolean): PsiElementVisitor {
        return MethodVisitor(
                Not(Internal()) and
                InRegularClass() and
                Constrain<Method>({ it.modifier.isPublic && !it.isFinal }),
                "Method should be final",
                holder
        )
    }

}