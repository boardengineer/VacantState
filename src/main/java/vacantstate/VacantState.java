package vacantstate;

import basemod.BaseMod;
import basemod.ReflectionHacks;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import battleaimod.BattleAiMod;
import battleaimod.SilentLogger;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import savestate.AbstractCardModifierState;
import savestate.CardState;
import savestate.StateFactories;
import savestate.actions.ActionState;
import savestate.orbs.OrbState;
import savestate.powers.PowerState;
import theVacant.actions.*;
import theVacant.cards.AbstractVacantCard;
import theVacant.cards.Modifiers.MaterializeModifier;
import theVacant.cards.Skills.Enchant;
import theVacant.cards.Skills.Sneeze;
import theVacant.cards.Special.*;
import theVacant.orbs.*;
import theVacant.powers.*;
import theVacant.util.TextureLoader;
import vacantstate.actions.*;
import vacantstate.cardmodifiier.MaterializeModifierState;
import vacantstate.cards.AbstractVacantCardState;
import vacantstate.cards.SneezeState;
import vacantstate.orbs.*;
import vacantstate.powers.*;

import static theVacant.characters.TheVacant.Enums.COLOR_GOLD;

@SpireInitializer
public class VacantState implements PostInitializeSubscriber, EditRelicsSubscriber, EditCardsSubscriber {
    public static void initialize() {
        BaseMod.subscribe(new vacantstate.VacantState());
    }

    @Override
    public void receivePostInitialize() {
        populateMaps();
    }

    public static void populateMaps() {
        populateCardFactories();
        populatePowerFactory();

        BattleAiMod.cardPlayHeuristics.add(VacantPlayOrder.COMPARATOR);

        populateOrbFactories();
        populateCardModifierFactories();
        popualteActionFactories();

        ReflectionHacks.setPrivateStaticFinal(TextureLoader.class, "logger", new SilentLogger());
    }

    private static void popualteActionFactories() {
        StateFactories.actionByClassMap
                .put(ChipOrbAction.class, new ActionState.ActionFactories(action -> new ChipOrbActionState(action)));
        StateFactories.actionByClassMap
                .put(MoveFromExhaustToDrawAction.class, new ActionState.ActionFactories(action -> new MoveFromExhaustToDrawActionState(action)));
        StateFactories.actionByClassMap
                .put(ReduceOrbSizeAction.class, new ActionState.ActionFactories(action -> new ReduceOrbSizeActionState(action)));
        StateFactories.actionByClassMap
                .put(UpdateCardsInHandAction.class, new ActionState.ActionFactories(action -> new UpdateCardsInHandActionState()));
        StateFactories.actionByClassMap
                .put(VacantMillAction.class, new ActionState.ActionFactories(action -> new VacantMillActionState(action)));
    }

    private static void populateCardModifierFactories() {
        StateFactories.cardModifierFactories
                .put(MaterializeModifier.ID, new AbstractCardModifierState.CardModifierStateFactories(modifier -> new MaterializeModifierState(modifier), json -> new MaterializeModifierState(json)));
    }

    private static void populateCardFactories() {
        CardState.CardFactories sneezeFactories = new CardState.CardFactories(card -> new SneezeState(card), json -> new SneezeState(json), jsonObject -> new SneezeState(jsonObject));
        StateFactories.cardFactoriesByType.put(Sneeze.class, sneezeFactories);
        StateFactories.cardFactoriesByCardId.put(Sneeze.ID, sneezeFactories);

        CardState.CardFactories vacantCardFactories = new CardState.CardFactories(card -> new AbstractVacantCardState(card), json -> new AbstractVacantCardState(json), jsonObject -> new AbstractVacantCardState(jsonObject));
        StateFactories.cardFactoriesByType.put(AbstractVacantCard.class, vacantCardFactories);
        StateFactories.cardFactoriesByTypeName.put(AbstractVacantCardState.TYPE_KEY, vacantCardFactories);
    }

    private static void populateOrbFactories() {
        StateFactories.orbByClassMap
                .put(AmethystOrb.class, new OrbState.OrbFactories(orb -> new AmethystOrbState(orb), json -> new AmethystOrbState(json), jsonObject -> new AmethystOrbState(jsonObject)));
        StateFactories.orbClassByName.put(AmethystOrb.class.getSimpleName(), AmethystOrb.class);

        StateFactories.orbByClassMap
                .put(DiamondOrb.class, new OrbState.OrbFactories(orb -> new DiamondOrbState(orb), json -> new DiamondOrbState(json), jsonObject -> new DiamondOrbState(jsonObject)));
        StateFactories.orbClassByName.put(DiamondOrb.class.getSimpleName(), DiamondOrb.class);

        StateFactories.orbByClassMap
                .put(RubyOrb.class, new OrbState.OrbFactories(orb -> new RubyOrbState(orb), json -> new RubyOrbState(json), jsonObject -> new RubyOrbState(jsonObject)));
        StateFactories.orbClassByName.put(RubyOrb.class.getSimpleName(), RubyOrb.class);

        StateFactories.orbByClassMap
                .put(EmeraldOrb.class, new OrbState.OrbFactories(orb -> new EmeraldOrbState(orb), json -> new EmeraldOrbState(json), jsonObject -> new EmeraldOrbState(jsonObject)));
        StateFactories.orbClassByName.put(EmeraldOrb.class.getSimpleName(), EmeraldOrb.class);

        StateFactories.orbByClassMap
                .put(OnyxOrb.class, new OrbState.OrbFactories(orb -> new OnyxOrbState(orb), json -> new OnyxOrbState(json), jsonObject -> new OnyxOrbState(jsonObject)));
        StateFactories.orbClassByName.put(OnyxOrb.class.getSimpleName(), OnyxOrb.class);

        StateFactories.orbByClassMap
                .put(OpalOrb.class, new OrbState.OrbFactories(orb -> new OpalOrbState(orb), json -> new OpalOrbState(json), jsonObject -> new OpalOrbState(jsonObject)));
        StateFactories.orbClassByName.put(OpalOrb.class.getSimpleName(), OpalOrb.class);

        StateFactories.orbByClassMap
                .put(SapphireOrb.class, new OrbState.OrbFactories(orb -> new SapphireOrbState(orb), json -> new SapphireOrbState(json), jsonObject -> new SapphireOrbState(jsonObject)));
        StateFactories.orbClassByName.put(SapphireOrb.class.getSimpleName(), SapphireOrb.class);
    }

    private static void populatePowerFactory() {
        StateFactories.powerByIdMap
                .put(AbyssPower.POWER_ID, new PowerState.PowerFactories(power -> new AbyssPowerState(power)));
        StateFactories.powerByIdMap
                .put(AquamarinePower.POWER_ID, new PowerState.PowerFactories(power -> new AquamarinePowerState(power)));
        StateFactories.powerByIdMap
                .put(BurdenBreakPower.POWER_ID, new PowerState.PowerFactories(power -> new BurdenBreakPowerState(power)));
        StateFactories.powerByIdMap
                .put(CleanseSoulPower.POWER_ID, new PowerState.PowerFactories(power -> new CleanseSoulPowerState(power)));
        StateFactories.powerByIdMap
                .put(DoomPower.POWER_ID, new PowerState.PowerFactories(power -> new DoomPowerState(power)));
        StateFactories.powerByIdMap
                .put(ForgeSoulPower.POWER_ID, new PowerState.PowerFactories(power -> new ForgeSoulPowerState(power)));
        StateFactories.powerByIdMap
                .put(GloomPower.POWER_ID, new PowerState.PowerFactories(power -> new GloomPowerState(power)));
        StateFactories.powerByIdMap
                .put(ImmaterializePower.POWER_ID, new PowerState.PowerFactories(power -> new ImmaterializePowerState(power)));
        StateFactories.powerByIdMap
                .put(InvisibleGemOrbPower.POWER_ID, new PowerState.PowerFactories(power -> new InvisibleGemOrbPowerState(power)));
        StateFactories.powerByIdMap
                .put(MemoriaPower.POWER_ID, new PowerState.PowerFactories(power -> new MemoriaPowerState(power)));
        StateFactories.powerByIdMap
                .put(PickaxePower.POWER_ID, new PowerState.PowerFactories(power -> new PickaxePowerState(power)));
        StateFactories.powerByIdMap
                .put(ReapPower.POWER_ID, new PowerState.PowerFactories(power -> new ReapPowerState(power)));
        StateFactories.powerByIdMap
                .put(RecoverPower.POWER_ID, new PowerState.PowerFactories(power -> new RecoverPowerState(power)));
        StateFactories.powerByIdMap
                .put(RequiemPower.POWER_ID, new PowerState.PowerFactories(power -> new RequiemPowerState(power)));
        StateFactories.powerByIdMap
                .put(RunicThoughtsPower.POWER_ID, new PowerState.PowerFactories(power -> new RunicThoughtsPowerState(power)));
        StateFactories.powerByIdMap
                .put(ShroudPower.POWER_ID, new PowerState.PowerFactories(power -> new ShroudPowerState(power)));
        StateFactories.powerByIdMap
                .put(TemperancePower.POWER_ID, new PowerState.PowerFactories(power -> new TemperancePowerState(power)));
        StateFactories.powerByIdMap
                .put(VoidEmbracePower.POWER_ID, new PowerState.PowerFactories(power -> new VoidEmbracePowerState(power)));
        StateFactories.powerByIdMap
                .put(VoidPower.POWER_ID, new PowerState.PowerFactories(power -> new VoidPowerState(power)));
    }

    @Override
    public void receiveEditRelics() {
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new RubyOption());
        BaseMod.addCard(new SapphireOption());
        BaseMod.addCard(new OpalOption());
        BaseMod.addCard(new EmeraldOption());
        BaseMod.addCard(new OnyxOption());
        BaseMod.addCard(new DiamondOption());
        BaseMod.addCard(new AmethystOption());

        // Need support for card modifier
        BaseMod.removeCard(Enchant.ID, COLOR_GOLD);
    }
}