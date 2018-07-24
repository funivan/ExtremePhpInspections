package com.funivan.idea.php.extremePhpInspections.inspections.staticProperty

import com.funivan.idea.php.extremePhpInspections.inspections.PhpInspectionsTestCase


internal class StaticPropertyInspectionTest : PhpInspectionsTestCase() {


    fun `test fire error on static properties`() {
        assert(
                StaticPropertyInspection(),
                """
<?php
class A {
 public static <weak_warning descr="Do not use static properties">${'$'}name</weak_warning>;
}
?>
                """
        )
    }
}