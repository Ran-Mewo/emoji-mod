package dev.drtheo.mcemojis.mixin;

import dev.drtheo.mcemojis.EmojiReplace;
import dev.drtheo.mcemojis.MCEmojis;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(ChatScreen.class)
public class ChatScreenMixin extends Screen {

    @Shadow protected TextFieldWidget chatField;
    protected ChatScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "keyPressed")
    public void keyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        if(MCEmojis.isDebug)
            MCEmojis.client.player.sendMessage(new LiteralText(String.valueOf(keyCode)), true);
        int cursorPos;
        int textLength;

        if((Arrays.stream(EmojiReplace.ignore).noneMatch(i -> i == keyCode) && !Character.isAlphabetic(keyCode) && !Character.isDigit(keyCode)
                && chatField.getSelectedText().length() == 0) || keyCode == 257) {
            String modified = EmojiReplace.GetEmojiText(chatField.getText());
            if(modified != null) {
                cursorPos = chatField.getCursor();
                textLength = chatField.getText().length();
                if(MCEmojis.isDebug)
                    MCEmojis.client.player.sendMessage(new LiteralText("true"), true);
                chatField.setText(modified);
                chatField.setCursor(cursorPos + (chatField.getText().length() - textLength));
            }
        }
    }
}
