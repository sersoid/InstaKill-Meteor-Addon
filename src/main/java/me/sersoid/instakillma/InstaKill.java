package me.sersoid.instakillma;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class InstaKill {
    public static final MinecraftClient minecraftClient = MinecraftClient.getInstance();

    public static Boolean activate = false;

    public static void addVelocityToPlayer() {
        if (activate) {
            assert minecraftClient.player != null;
            minecraftClient.player.networkHandler.sendPacket(new ClientCommandC2SPacket(minecraftClient.player, ClientCommandC2SPacket.Mode.START_SPRINTING));
            for (int i = 0; i < 100; i++) {
                minecraftClient.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(minecraftClient.player.getX(), minecraftClient.player.getY() - 0.000000001, minecraftClient.player.getZ(), true));
                minecraftClient.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(minecraftClient.player.getX(), minecraftClient.player.getY() + 0.000000001, minecraftClient.player.getZ(), false));
            }
        }
    }
}
