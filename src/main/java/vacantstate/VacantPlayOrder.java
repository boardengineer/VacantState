package vacantstate;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.curses.Pain;
import theVacant.cards.Attacks.*;
import theVacant.cards.Powers.*;
import theVacant.cards.Skills.*;

import java.util.Comparator;
import java.util.HashMap;

public class VacantPlayOrder {
    public static final HashMap<String, Integer> CARD_RANKS = new HashMap<String, Integer>() {{
        int size = 0;

        put(Pain.ID, size++);
        put(StealSoul.ID, size++);

        // powers
        put(RunicThoughts.ID, size++);
        put(Reflection.ID, size++);
        put(Immaterialize.ID, size++);
        put(ForgeSoul.ID, size++);
        put(Requiem.ID, size++);
        put(VoidEmbrace.ID, size++);
        put(VoidForm.ID, size++);
        put(IntoTheAbyss.ID, size++);
        put(Acceptance.ID, size++);
        put(Treasure.ID, size++);
        put(Gloom.ID, size++);
        put(Recover.ID, size++);
        put(Rejection.ID, size++);
        put(GotOurPickaxe.ID, size++);
        put(CleanseSoul.ID, size++);
        put(DiamondIsUnbreakable.ID, size++);
        put(BattleScars.ID, size++);
        put(Expand.ID, size++);

        // Big booms
        put(DarkStrike.ID, size++);
        put(Showdown.ID, size++);


        put(BrassMagnet.ID, size++);
        put(Jab.ID, size++);
        put(Shatter.ID, size++);

        // Draw Effects and other acceleration effects
        put(Spelunk.ID, size++);
        put(Memoria.ID, size++);
        put(Unearth.ID, size++);
        put(AbsorbAmethyst.ID, size++);
        put(OpalFracture.ID, size++);
        put(TopazFrenzy.ID, size++);
        put(OpalShine.ID, size++);
        put(EmeraldSplash.ID, size++);
        put(Corporeate.ID, size++);
        put(RubyRage.ID, size++);
        put(ReaperStrike.ID, size++);

        put(EssenceOfBismuth.ID, size++);
        put(SapphireStrike.ID, size++);
        put(Enchant.ID, size++);
        put(Exorcise.ID, size++);
        put(OnSecondThought.ID, size++);
        put(FromNothing.ID, size++);
        put(TimeSkip.ID, size++);
        put(AwMan.ID, size++);
        put(ReaperBlast.ID, size++);

        // Attacks
        put(Threat.ID, size++);
        put(SoulBarrage.ID, size++);
        put(SoulBash.ID, size++);
        put(OnyxBlaster.ID, size++);
        put(Hex.ID, size++);
        put(Fling.ID, size++);
        put(BurdenBreak.ID, size++);
        put(FranticBlow.ID, size++);
        put(GildedPickaxe.ID, size++);
        put(EmbraceDarkness.ID, size++);
        put(DimensionTear.ID, size++);
        put(Thoughtseize.ID, size++);

        put(LashOut.ID, size++);
        put(ShriekingBlast.ID, size++);
        put(FiendFrost.ID, size++);
        put(EyePoke.ID, size++);
        put(SurpriseAttack.ID, size++);
        put(Snowball.ID, size++);
        put(GraveDigger.ID, size++);
        put(CursedBlast.ID, size++);
        put(GraveWave.ID, size++);
        put(BackInTheMine.ID, size++);

        // Blocks
        put(Fortify.ID, size++);
        put(Dig.ID, size++);
        put(EmptyShield.ID, size++);
        put(Cower.ID, size++);
        put(Spinshield.ID, size++);

        put(VacantStarterStrike.ID, size++);
        put(VacantStarterDefend.ID, size++);

        put(Sneeze.ID, size++);

        // Unplayables
        put(TheAnvil.ID, size++);
    }};

    public static final Comparator<AbstractCard> COMPARATOR = (card1, card2) -> {
        if (CARD_RANKS.containsKey(card1.cardID) && CARD_RANKS
                .containsKey(card2.cardID)) {
            return CARD_RANKS.get(card1.cardID) - CARD_RANKS
                    .get(card2.cardID);
        }
        return 0;
    };
}
