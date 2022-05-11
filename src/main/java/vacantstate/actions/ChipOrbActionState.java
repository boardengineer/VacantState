package vacantstate.actions;

import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.actions.ActionState;
import theVacant.actions.ChipOrbAction;

public class ChipOrbActionState implements ActionState {
    private final int amount;
    private final int orbIndex;
    private final boolean limited;

    public ChipOrbActionState(AbstractGameAction action) {
        amount = action.amount;
        limited = ReflectionHacks.getPrivate(action, ChipOrbAction.class, "limited");

        AbstractOrb orb = ReflectionHacks.getPrivate(action, ChipOrbAction.class, "orb");

        // Find the orb
        int orbFinderIndex = -1;
        for (int i = 0; i < AbstractDungeon.player.orbs.size(); i++) {
            if (AbstractDungeon.player.orbs.get(i) == orb) {
                orbFinderIndex = i;
                break;
            }
        }

        orbIndex = orbFinderIndex;
    }

    @Override
    public AbstractGameAction loadAction() {
        return new ChipOrbAction(orbIndex == -1 ? null : AbstractDungeon.player.orbs
                .get(orbIndex), amount, limited);
    }
}
