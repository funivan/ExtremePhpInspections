package com.funivan.idea.php.extremePhpInspections.inspections

import com.funivan.idea.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection
import com.jetbrains.php.lang.psi.elements.PhpThrow


/**
 * Experimental function. Under development
 */
class ExceptionInConstructorInspection : PhpInspection() {

    override fun getShortName() = "ExceptionInConstructorInspection"

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return MethodVisitor(
                com.funivan.idea.php.extremePhpInspections.constrains.AllOf(
                        com.funivan.idea.php.extremePhpInspections.constrains.OneOf(
                                com.funivan.idea.php.extremePhpInspections.constrains.method.Name(Regex("^__construct$")),
                                com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.NamedConstructor()
                        ),
                        com.funivan.idea.php.extremePhpInspections.constrains.method.WithChildElement { it is PhpThrow }
                ),
                "Do not throw exceptions while initializing object",
                holder
        )
    }
}