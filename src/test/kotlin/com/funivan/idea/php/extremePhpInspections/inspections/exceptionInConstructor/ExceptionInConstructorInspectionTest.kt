package com.funivan.idea.php.extremePhpInspections.inspections.exceptionInConstructor

import com.funivan.idea.php.extremePhpInspections.inspections.InspectionsTestCase


internal class ExceptionInConstructorInspectionTest : InspectionsTestCase() {

    fun `test positive`() {
        assert(
                ExceptionInConstructorInspection(),
                """<?php
        class A {

         public static function <weak_warning descr="Do not throw exceptions while initializing object">create</weak_warning>() : self {
            throw new \Exception();
         }
        }""")
    }
}