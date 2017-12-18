package com.funivan.php.extremePhpInspections.inspections

import com.intellij.testFramework.builders.ModuleFixtureBuilder
import com.intellij.testFramework.fixtures.CodeInsightFixtureTestCase

internal class MethodDeclarationInspectionTest : CodeInsightFixtureTestCase<ModuleFixtureBuilder<*>>() {

    fun `test named constructor should not be skipped in the interface declaration`() {
        myFixture.enableInspections(MethodDeclarationInspection())
        myFixture.configureByFile("fixtures/MethodDeclarationInspection/a1.php")
        myFixture.testHighlighting(true, false, true)
    }
}