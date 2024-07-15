package dev.codex.cinestar;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModularityTests {

    ApplicationModules modules = ApplicationModules.of(Application.class);

    @Test
    @DisplayName("test the application modularity")
    void modulesShouldBeDefined() {
        modules.verify();
    }
}
