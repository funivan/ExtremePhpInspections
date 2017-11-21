package com.funivan.php.extremePhpInspections.constrains.method.aliases

import com.funivan.php.extremePhpInspections.constrains.ConstrainInterface
import com.jetbrains.php.lang.psi.elements.Method


class Internal : ConstrainInterface<Method> {
    private val names = listOf(
        "__construct",
        "__destruct",
        "__call",
        "__callStatic",
        "__get",
        "__set",
        "__isset",
        "__unset",
        "__sleep",
        "__wakeup",
        "__toString",
        "__invoke",
        "__set_state",
        "__clone",
        "__debugInfo"
    )

    override fun match(target: Method): Boolean {
        return names.contains(target.name)
    }
}