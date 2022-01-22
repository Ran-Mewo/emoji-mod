package dev.drtheo.mcemojis;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;

@Environment(net.fabricmc.api.EnvType.CLIENT)
public class MCEmojis implements ClientModInitializer {

    public static final boolean isDebug = false;
    public static MinecraftClient client;

    @Override
    public void onInitializeClient() {
        client = MinecraftClient.getInstance();
    }
}
