package vacantstate.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ChangeStateAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RollMoveAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.ending.SpireShield;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theVacant.characters.TheVacant;

/**
 * negative focus doesn't work well with gem effects, patch spire shield to not apply them
 */
public class SpireShieldPatch {
    @SpirePatch(clz = SpireShield.class, method = "takeTurn")
    public static class noFocusPatch {
        @SpirePrefixPatch
        public static SpireReturn takeTurnBetter(SpireShield spireShield) {
            if (AbstractDungeon.player instanceof TheVacant) {
                if(spireShield.nextMove == 1) {
                    AbstractDungeon.actionManager.addToBottom(new ChangeStateAction(spireShield, "ATTACK"));
                    AbstractDungeon.actionManager.addToBottom(new DamageAction(AbstractDungeon.player, (DamageInfo)spireShield.damage.get(0), AbstractGameAction.AttackEffect.BLUNT_HEAVY));

                    // Keep the if statement to maintain RNG state
                    if (!AbstractDungeon.player.orbs.isEmpty() && AbstractDungeon.aiRng.randomBoolean()) {
                        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, spireShield, new StrengthPower(AbstractDungeon.player, -1), -1));
                    } else {
                        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, spireShield, new StrengthPower(AbstractDungeon.player, -1), -1));
                    }

                    AbstractDungeon.actionManager.addToBottom(new RollMoveAction(spireShield));
                }
            }

            return SpireReturn.Continue();
        }
    }
}
