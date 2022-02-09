package vacantstate.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theVacant.cards.Special.*;

public class OrbOptionCardPatches {
    @SpirePatch(clz = RubyOption.class, method = SpirePatch.CONSTRUCTOR)
    public static class SeedRubyOption {
        @SpirePostfixPatch
        public static void seed(RubyOption option) {
            try {
                option.magicNumber = option.baseMagicNumber = AbstractDungeon.miscRng.random(3, 6);
            } catch (NullPointerException e) {

            }
        }
    }

    @SpirePatch(clz = SapphireOption.class, method = SpirePatch.CONSTRUCTOR)
    public static class SeedSapphireOption {
        @SpirePostfixPatch
        public static void seed(SapphireOption option) {
            try {
                option.magicNumber = option.baseMagicNumber = AbstractDungeon.miscRng.random(3, 6);
            } catch (NullPointerException e) {

            }
        }
    }

    @SpirePatch(clz = OpalOption.class, method = SpirePatch.CONSTRUCTOR)
    public static class SeedOpalOption {
        @SpirePostfixPatch
        public static void seed(OpalOption option) {
            try {
                option.magicNumber = option.baseMagicNumber = AbstractDungeon.miscRng.random(2, 3);
            } catch (NullPointerException e) {

            }
        }
    }

    @SpirePatch(clz = EmeraldOption.class, method = SpirePatch.CONSTRUCTOR)
    public static class SeedEmeraldOption {
        @SpirePostfixPatch
        public static void seed(EmeraldOption option) {
            try {
                option.magicNumber = option.baseMagicNumber = AbstractDungeon.miscRng.random(2, 3);
            } catch (NullPointerException e) {

            }
        }
    }

    @SpirePatch(clz = OnyxOption.class, method = SpirePatch.CONSTRUCTOR)
    public static class SeedOnyxOption {
        @SpirePostfixPatch
        public static void seed(OnyxOption option) {
            try {
                option.magicNumber = option.baseMagicNumber = AbstractDungeon.miscRng.random(2, 3);
            } catch (NullPointerException e) {

            }
        }
    }

    @SpirePatch(clz = DiamondOption.class, method = SpirePatch.CONSTRUCTOR)
    public static class SeedDiamondOption {
        @SpirePostfixPatch
        public static void seed(DiamondOption option) {
            try {
                option.magicNumber = option.baseMagicNumber = AbstractDungeon.miscRng.random(1, 3);
            } catch (NullPointerException e) {

            }
        }
    }

    @SpirePatch(clz = AmethystOption.class, method = SpirePatch.CONSTRUCTOR)
    public static class SeedAmethystOption {
        @SpirePostfixPatch
        public static void seed(AmethystOption option) {
            try {
                option.magicNumber = option.baseMagicNumber = AbstractDungeon.miscRng.random(2, 5);
            } catch (NullPointerException e) {

            }
        }
    }
}
