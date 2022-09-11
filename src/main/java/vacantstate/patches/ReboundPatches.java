package vacantstate.patches;

import basemod.BaseMod;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theVacant.actions.VacantMillAction;
import theVacant.cards.AbstractDynamicCard;
import theVacant.characters.TheVacant;
import theVacant.powers.AquamarinePower;
import theVacant.powers.CleanseSoulPower;
import theVacant.powers.ForgeSoulPower;
import theVacant.powers.RunicThoughtsPower;
import theVacant.relics.LocketRelic;

public class ReboundPatches {
    @SpirePatch(clz = VacantMillAction.class, method = "Rebound")
    public static class NoEffectRebound {
        @SpirePrefixPatch
        public static SpireReturn reboundWithoutEffect(VacantMillAction action, AbstractCard card) {
            if (AbstractDungeon.player.hand.size() >= BaseMod.MAX_HAND_SIZE) {
                if (card instanceof AbstractDynamicCard && ((AbstractDynamicCard) card).postMillAction) {
                    ((AbstractDynamicCard) card).PostMillAction();
                }

                MoveToDiscard(card);
            } else {
                AbstractDungeon.player.drawPile.removeCard(card);

                // This logic is currently done by an effect that is removed by the simulator
                if (AbstractDungeon.player.hand.size() < BaseMod.MAX_HAND_SIZE) {
                    AbstractDungeon.player.hand.addToTop(card);
                    AbstractDungeon.player.hand.refreshHandLayout();
                    AbstractDungeon.player.hand.applyPowers();
                    PostRebound(card);
                }

                if (card instanceof AbstractDynamicCard && ((AbstractDynamicCard) card).postMillAction) {
                    ((AbstractDynamicCard) card).PostMillAction();
                }

                ProcessPostMill(card, true);
            }

            return SpireReturn.Return(null);
        }
    }

    private static void PostRebound(AbstractCard card) {
        AbstractPlayer player = AbstractDungeon.player;
        if (player != null && player.hasRelic(LocketRelic.ID)) {
            player.getRelic(LocketRelic.ID).flash();
            AbstractDungeon.actionManager
                    .addToBottom(new GainBlockAction(player, LocketRelic.BLOCK_AMOUNT));
        }

        if (player.hasPower(RunicThoughtsPower.POWER_ID)) {
            card.setCostForTurn(0);
            player.getPower(RunicThoughtsPower.POWER_ID).flash();
        }

    }

    private static void PostMillCard(AbstractCard card) {
        AbstractPlayer player = AbstractDungeon.player;
        if (player != null) {
            if (player
                    .hasPower(CleanseSoulPower.POWER_ID) && (card.type == AbstractCard.CardType.STATUS || card.type == AbstractCard.CardType.CURSE)) {
                if (player.discardPile.contains(card)) {
                    player.discardPile.moveToExhaustPile(card);
                    player.getPower(CleanseSoulPower.POWER_ID).flash();
                }
            }

            if (player.hasPower(AquamarinePower.POWER_ID) && player
                    .getPower(AquamarinePower.POWER_ID).amount > 0) {
                AbstractDungeon.actionManager.addToBottom(new GainBlockAction(player, player
                        .getPower(AquamarinePower.POWER_ID).amount));
            }

            if (player instanceof TheVacant) {
                ++((TheVacant) player).millsThisTurn;
            }

            if (player.hasPower(ForgeSoulPower.POWER_ID) && card.canUpgrade()) {
                card.upgrade();
            }
        }

    }

    private static void MoveToDiscard(AbstractCard card) {
        AbstractDungeon.player.drawPile.removeCard(card);
        AbstractDungeon.player.discardPile.addToTop(card);
        ProcessPostMill(card, false);
    }

    private static void ProcessPostMill(AbstractCard card, boolean rebounded) {
        PostMillCard(card);
    }
}
