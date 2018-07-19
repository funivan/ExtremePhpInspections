package com.funivan.idea.php.extremePhpInspections.inspections

import com.intellij.psi.PsiDocumentManager
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase
import com.jetbrains.php.lang.PhpFileType


internal class StaticPropertyInspectionTest : LightCodeInsightFixtureTestCase() {
    @Throws(Exception::class)


    fun `test fire error on static properties`() {
        val code =
                """
<?php
class A {
 public static <TYPO descr="Do not use static properties">${'$'}name</TYPO>;
}
?>
                """
        myFixture.configureByText(PhpFileType.INSTANCE, code)
        PsiDocumentManager.getInstance(project).commitAllDocuments()

        myFixture.enableInspections(StaticPropertyInspection())
        myFixture.testHighlighting(true, false, true)
    }
}