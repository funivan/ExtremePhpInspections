package com.funivan.idea.php.extremePhpInspections.inspections.exceptionInConstructor

import com.funivan.idea.php.extremePhpInspections.constrains.AllOf
import com.funivan.idea.php.extremePhpInspections.constrains.OneOf
import com.funivan.idea.php.extremePhpInspections.constrains.method.Name
import com.funivan.idea.php.extremePhpInspections.constrains.method.WithChildElement
import com.funivan.idea.php.extremePhpInspections.constrains.method.aliases.NamedConstructor
import com.funivan.idea.php.extremePhpInspections.visitors.MethodVisitor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.jetbrains.php.lang.inspections.PhpInspection
import com.jetbrains.php.lang.psi.elements.PhpThrow


class ExceptionInConstructorInspection : PhpInspection() {

    override fun getShortName() = "ExceptionInConstructorInspection"

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return MethodVisitor(
                AllOf(
                        OneOf(
                                Name(Regex("^__construct$")),
                                NamedConstructor()
                        ),
                        WithChildElement { it is PhpThrow }
                ),
                "Do not throw exceptions while initializing object",
                holder
        )
    }
}