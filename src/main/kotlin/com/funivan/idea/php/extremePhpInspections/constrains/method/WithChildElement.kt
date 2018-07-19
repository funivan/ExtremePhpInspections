package com.funivan.idea.php.extremePhpInspections.constrains.method

import com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface
import com.intellij.psi.PsiElement
import com.jetbrains.php.lang.psi.elements.Method


class WithChildElement(private val check: (PsiElement) -> Boolean) : com.funivan.idea.php.extremePhpInspections.constrains.ConstrainInterface<Method> {

    override fun match(target: Method): Boolean {
        return findChild(target)
    }

    private fun findChild(target: PsiElement): Boolean {
        return this.check(target) || target.children.any { findChild(it) }
    }


}