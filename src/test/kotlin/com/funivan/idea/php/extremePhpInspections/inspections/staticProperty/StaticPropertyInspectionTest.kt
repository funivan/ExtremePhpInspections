package com.funivan.idea.php.extremePhpInspections.inspections.staticProperty

import com.intellij.psi.PsiDocumentManager
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase
import com.jetbrains.php.lang.PhpFileType


internal class StaticPropertyInspectionTest : LightCodeInsightFixtureTestCase() {


    fun `test fire error on static properties`() {
        val code =
                """
<?php
class A {
 public static <weak_warning descr="Do not use static properties">${'$'}name</weak_warning>;
}
?>
                """
        myFixture.configureByText(PhpFileType.INSTANCE, code)
        PsiDocumentManager.getInstance(project).commitAllDocuments()

        myFixture.enableInspections(StaticPropertyInspection())
        myFixture.testHighlighting(true, false, true)
    }
}