package com.funivan.idea.php.extremePhpInspections.inspections

import com.funivan.idea.php.extremePhpInspections.constrains.AllOf
import com.funivan.idea.php.extremePhpInspections.constrains.NoneOf
import com.funivan.idea.php.extremePhpInspections.constrains.method.Static
import com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.Internal
import com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.InvalidClassReturnType
import com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.NamedConstructor
import com.funivan.idea.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection


class NonStrictReturnTypeInspection : PhpInspection() {

    private val constrain = com.funivan.idea.php.extremePhpInspections.constrains.AllOf(
            com.funivan.idea.php.extremePhpInspections.constrains.NoneOf(
                    com.funivan.idea.php.extremePhpInspections.constrains.method.Static(),
                    com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.NamedConstructor(),
                    com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.Internal()
            ),
            com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.InvalidClassReturnType()
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


