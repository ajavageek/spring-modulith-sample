package ch.frankel.blog;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.model.ApplicationModules;

public class ModulithTests {

    @Test
    public void writeDocumentation() {
        var modules = ApplicationModules.of(DummyShop.class).verify();
        new Documenter(modules)
                .writeModulesAsPlantUml();
    }
}
