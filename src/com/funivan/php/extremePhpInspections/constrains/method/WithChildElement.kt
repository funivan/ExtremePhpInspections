package com.funivan.php.extremePhpInspections.constrains.method

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.intellij.psi.PsiElement
import com.jetbrains.php.lang.psi.elements.Method


class WithChildElement(private val check: (PsiElement) -> Boolean) : ConstrainInterface<Method> {

    override fun match(target: Method): Boolean {
        return findChild(target)
    }

    private fun findChild(target: PsiElement): Boolean {
        return this.check(target) || target.children.any { findChild(it) }
    }


}