package com.funivan.php.extremePhpInspections.inspections

import com.intellij.testFramework.builders.ModuleFixtureBuilder
import com.intellij.testFramework.fixtures.CodeInsightFixtureTestCase

internal class DeclareMethodsInTheInterfaceInspectionTest : CodeInsightFixtureTestCase<ModuleFixtureBuilder<*>>() {

    fun `test named constructor should not be skipped in the interface declaration`() {
        myFixture.enableInspections(MethodDeclarationInspection())
        myFixture.configureByFile("fixtures/MethodDeclarationInspection/skip.php")
        myFixture.testHighlighting(true, false, true)
    }
}