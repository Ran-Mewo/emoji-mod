package dev.drtheo.mcemojis.mixin;

import net.minecraft.client.util.SelectionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SelectionManager.class)
public interface SelectionManagerInvoker {
    @Invoker("getSelectedText")
    String invokeGetSelectedText(String text);
}
