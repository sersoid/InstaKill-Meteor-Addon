package me.sersoid.instakillma.mixin;

import me.sersoid.instakillma.modules.InstaKillModule;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin({ClientPlayerInteractionManager.class})
public class ClientPlayerInteractionManagerMixin {
    @Inject(at = {@At("HEAD")}, method = {"stopUsingItem"})
    private void onStopUsingItem(PlayerEntity player, CallbackInfo ci) {
        if (player.getMainHandStack().getItem().equals(Items.BOW)) {
            InstaKillModule.addVelocityToPlayer();
        }
    }
}
