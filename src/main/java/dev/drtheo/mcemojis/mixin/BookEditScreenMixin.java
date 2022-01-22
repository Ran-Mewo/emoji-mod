package dev.drtheo.mcemojis.mixin;

import dev.drtheo.mcemojis.EmojiReplace;
import dev.drtheo.mcemojis.MCEmojis;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.BookEditScreen;
import net.minecraft.client.util.SelectionManager;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;

@Mixin(BookEditScreen.class)
public class BookEditScreenMixin extends Screen {

    @Final @Shadow private List<String> pages;
    @Shadow private int currentPage;
    @Final @Shadow private SelectionManager currentPageSelectionManager;

    protected BookEditScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "keyPressed")
    public void keyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        if(MCEmojis.isDebug)
            MCEmojis.client.player.sendMessage(new LiteralText(String.valueOf(keyCode)), true);
        if((Arrays.stream(EmojiReplace.ignore).noneMatch(i -> i == keyCode) && !Character.isAlphabetic(keyCode) && !Character.isDigit(keyCode)
                && !currentPageSelectionManager.isSelecting()) || keyCode == 257) {
            String modified = EmojiReplace.GetEmojiText(pages.get(currentPage));
            if(modified != null) {
                if(MCEmojis.isDebug)
                    MCEmojis.client.player.sendMessage(new LiteralText("true"), true);
                pages.set(currentPage, modified);
            }
        }
    }
}
