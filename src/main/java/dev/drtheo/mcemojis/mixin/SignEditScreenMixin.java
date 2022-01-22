package dev.drtheo.mcemojis.mixin;

import dev.drtheo.mcemojis.EmojiReplace;
import dev.drtheo.mcemojis.MCEmojis;
import net.minecraft.client.gui.screen.ingame.SignEditScreen;
import net.minecraft.client.util.SelectionManager;
import net.minecraft.text.LiteralText;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(SignEditScreen.class)
public class SignEditScreenMixin {

    @Shadow private int currentRow;
    @Final @Shadow private String[] text;
    @Shadow private SelectionManager selectionManager;

    @Inject(at = @At("HEAD"), method = "keyPressed")
    public void keyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        if(MCEmojis.isDebug)
            MCEmojis.client.player.sendMessage(new LiteralText(String.valueOf(keyCode)), true);
        if((Arrays.stream(EmojiReplace.ignore).noneMatch(i -> i == keyCode) && !Character.isAlphabetic(keyCode) && !Character.isDigit(keyCode)
                && !selectionManager.isSelecting()) || keyCode == 257) {
            String modified = EmojiReplace.GetEmojiText(text[currentRow]);
            if(modified != null) {
                if(MCEmojis.isDebug)
                    MCEmojis.client.player.sendMessage(new LiteralText("true"), true);
                text[currentRow] = modified;
            }
        }
    }
}
