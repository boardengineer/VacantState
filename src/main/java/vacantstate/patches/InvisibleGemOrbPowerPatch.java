package vacantstate.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theVacant.powers.InvisibleGemOrbPower;

public class InvisibleGemOrbPowerPatch {
    @SpirePatch(clz = ChannelAction.class, method = "update")
    public static class CreatePowerOnChannelAction {
        @SpirePrefixPatch
        public static void stop(ChannelAction action) {
            float duration = ReflectionHacks
                    .getPrivate(action, AbstractGameAction.class, "duration");

            AbstractPlayer player = AbstractDungeon.player;
            if (duration == Settings.ACTION_DUR_FAST) {
                if (!player.hasPower(InvisibleGemOrbPower.POWER_ID)) {
                    AbstractDungeon.actionManager
                            .addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new InvisibleGemOrbPower(player, player, 1), 1));
                }
            }
        }
    }


}
