// java
package org.doogleoss;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ModuleBoundaryTest {

    @Test
    void modules_should_not_access_each_other_internal_packages() {
        JavaClasses classes = new ClassFileImporter().importPackages("com.example");

        noClasses()
            .that().resideOutsideOfPackages("..order.api..", "..order.internal..")
            .should().accessClassesThat().resideInAPackage("..order.internal..")
            .because("Order module internals should not be accessed by other modules")
            .check(classes);
    }
}
