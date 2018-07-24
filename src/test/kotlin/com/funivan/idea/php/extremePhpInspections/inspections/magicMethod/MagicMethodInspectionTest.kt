package com.funivan.idea.php.extremePhpInspections.inspections.magicMethod

import com.funivan.idea.php.extremePhpInspections.inspections.PhpInspectionsTestCase

internal class MagicMethodInspectionTest : PhpInspectionsTestCase() {


    fun `test positive`() {
        assert(
                MagicMethodInspection(),
                """
<?php
class A {
 public function <weak_warning descr="Avoid magic methods.">__toString</weak_warning>(){}
}
?>
                """
        )
    }
}