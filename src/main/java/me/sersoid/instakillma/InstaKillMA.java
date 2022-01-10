package me.sersoid.instakillma;

import me.sersoid.instakillma.modules.InstaKillModule;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.invoke.MethodHandles;

public class InstaKillMA extends MeteorAddon {
	public static final Logger LOG = LogManager.getLogger();

	@Override
	public void onInitialize() {
		LOG.info("Initializing InstaKill Meteor Addon");
		MeteorClient.EVENT_BUS.registerLambdaFactory("me.sersoid.instakillma", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
		Modules.get().add(new InstaKillModule());
	}
}
