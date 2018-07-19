package com.funivan.idea.php.extremePhpInspections.inspections.magicMethod

import com.intellij.psi.PsiDocumentManager
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase
import com.jetbrains.php.lang.PhpFileType

internal class MagicMethodInspectionTest : LightCodeInsightFixtureTestCase() {


    fun `test positive`() {
        val code =
                """
<?php
class A {
 public function <weak_warning descr="Avoid magic methods.">__toString</weak_warning>(){}
}
?>

                """
        myFixture.configureByText(PhpFileType.INSTANCE, code)
        PsiDocumentManager.getInstance(project).commitAllDocuments()

        myFixture.enableInspections(MagicMethodInspection())
        myFixture.testHighlighting(true, false, true)
    }
}