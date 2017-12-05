package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.constrains.AllOf
import com.funivan.php.extremePhpInspections.constrains.NoneOf
import com.funivan.php.extremePhpInspections.constrains.method.Static
import com.funivan.php.extremePhpInspections.constrains.method.aliases.Internal
import com.funivan.php.extremePhpInspections.constrains.method.aliases.InvalidClassReturnType
import com.funivan.php.extremePhpInspections.constrains.method.aliases.NamedConstructor
import com.funivan.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


class NonStrictReturnTypeInspection : PhpInspection() {

    private val constrain = AllOf(
            NoneOf(
                    Static(),
                    NamedConstructor(),
                    Internal()
            ),
            InvalidClassReturnType()
    )

    override fun getShortName(): String {
        return "NonStrictReturnTypeInspection"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return MethodVisitor(
                constrain,
                "Specify interface FQN in the return type",
                holder
        )
    }
}


