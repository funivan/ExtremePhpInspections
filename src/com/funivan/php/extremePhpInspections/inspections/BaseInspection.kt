package com.funivan.php.extremePhpInspections.inspections

import com.funivan.php.extremePhpInspections.Emojii
import com.jetbrains.php.lang.inspections.PhpInspection


abstract class BaseInspection : PhpInspection() {
    val emoji = Emojii()
}