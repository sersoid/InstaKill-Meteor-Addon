package me.sersoid.instakillma.modules;

import me.sersoid.instakillma.InstaKill;
import me.sersoid.instakillma.InstaKillMA;
import meteordevelopment.meteorclient.systems.modules.Module;

public class InstaKillModule extends Module {
    public InstaKillModule() {
        super(InstaKillMA.CATEGORY, "InstaKill", "InstaKill exploit");
    }

    @Override
    public void onActivate() {
        InstaKill.activate = true;
    }

    @Override
    public void onDeactivate() {
        InstaKill.activate = false;
    }
}
