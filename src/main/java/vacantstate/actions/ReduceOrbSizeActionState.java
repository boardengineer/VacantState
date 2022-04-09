package vacantstate.actions;

import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import savestate.actions.ActionState;
import theVacant.actions.ReduceOrbSizeAction;

public class ReduceOrbSizeActionState implements ActionState {
    private final int orbIndex;

    public ReduceOrbSizeActionState(AbstractGameAction action) {
        AbstractOrb orb = ReflectionHacks.getPrivate(action, ReduceOrbSizeAction.class, "orb");

        // Find the orb
        int orbFinderIndex = -1;
        for (int i = 0; i < AbstractDungeon.player.orbs.size(); i++) {
            if (AbstractDungeon.player.orbs.get(i) == orb) {
                orbFinderIndex = i;
                break;
            }
        }

        if (orbFinderIndex == -1) {
            throw new IllegalArgumentException("no orb found");
        }

        orbIndex = orbFinderIndex;
    }

    @Override
    public AbstractGameAction loadAction() {
        return new ReduceOrbSizeAction(AbstractDungeon.player.orbs.get(orbIndex));
    }
}
