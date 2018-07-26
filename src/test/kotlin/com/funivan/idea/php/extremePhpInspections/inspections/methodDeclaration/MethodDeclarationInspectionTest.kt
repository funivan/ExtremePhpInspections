package com.funivan.idea.php.extremePhpInspections.inspections.methodDeclaration

import com.funivan.idea.php.extremePhpInspections.inspections.PhpInspectionsTestCase

class MethodDeclarationInspectionTest : PhpInspectionsTestCase() {
    fun `test positive`() {
        assert(
                MethodDeclarationInspection(),
                """
<?php
class User {
 public function <weak_warning descr="Method should be declared in the interface">delete</weak_warning>(){
 }
}
?>
                """
        )
    }
}