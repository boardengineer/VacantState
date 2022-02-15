package vacantstate;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import battleaimod.BattleAiMod;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import savestate.AbstractCardModifierState;
import savestate.CardState;
import savestate.StateFactories;
import savestate.orbs.OrbState;
import savestate.powers.PowerState;
import theVacant.cards.AbstractVacantCard;
import theVacant.cards.Modifiers.MaterializeModifier;
import theVacant.cards.Skills.Enchant;
import theVacant.cards.Skills.Sneeze;
import theVacant.cards.Special.*;
import theVacant.orbs.*;
import theVacant.powers.*;
import vacantstate.cardmodifiier.MaterializeModifierState;
import vacantstate.cards.AbstractVacantCardState;
import vacantstate.cards.SneezeState;
import vacantstate.orbs.*;
import vacantstate.powers.*;

import java.util.Optional;

import static theVacant.characters.TheVacant.Enums.COLOR_GOLD;

@SpireInitializer
public class VacantState implements PostInitializeSubscriber, EditRelicsSubscriber, EditCardsSubscriber {
    public static void initialize() {
        BaseMod.subscribe(new vacantstate.VacantState());
    }

    @Override
    public void receivePostInitialize() {
        populateCardFactories();
        populatePowerFactory();

        BattleAiMod.cardPlayHeuristics.add(VacantPlayOrder.COMPARATOR);

        populateOrbFactories();
        populateCardModifierFactories();
    }

    private void populateCurrentActionsFactory() {
    }

    private void populateCardModifierFactories() {
        StateFactories.cardModifierFactories
                .put(MaterializeModifier.ID, new AbstractCardModifierState.CardModifierStateFactories(modifier -> new MaterializeModifierState(modifier), json -> new MaterializeModifierState(json)));
    }

    private void populateCardFactories() {
        // TODO add a single lookup instead of a bunch of conditionals
        CardState.CardFactories sneezeFactories = new CardState.CardFactories(card -> {
            if (card instanceof Sneeze) {
                return Optional.of(new SneezeState(card));
            }
            return Optional.empty();
        }, json -> {
            JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();
            if (parsed.get("card_id").getAsString().equals(Sneeze.ID)) {
                return Optional.of(new SneezeState(json));
            }
            return Optional.empty();
        });

        CardState.CardFactories cardFactories = new CardState.CardFactories(card -> {
            if (card instanceof AbstractVacantCard) {
                return Optional.of(new AbstractVacantCardState(card));
            }
            return Optional.empty();
        }, json -> {
            JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();
            String type = "";
            if (parsed.has("type")) {
                type = parsed.get("type").getAsString();
            }
            if (type.equals(AbstractVacantCardState.TYPE_KEY)) {
                return Optional.of(new AbstractVacantCardState(json));
            }
            return Optional.empty();
        });

        StateFactories.cardFactories.add(sneezeFactories);
        StateFactories.cardFactories.add(cardFactories);
    }

    private void populateOrbFactories() {
        StateFactories.orbByClassMap
                .put(AmethystOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new AmethystOrbState(orb), json -> new AmethystOrbState(json)));
        StateFactories.orbByClassMap
                .put(DiamondOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new DiamondOrbState(orb), json -> new DiamondOrbState(json)));
        StateFactories.orbByClassMap
                .put(RubyOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new RubyOrbState(orb), json -> new RubyOrbState(json)));
        StateFactories.orbByClassMap
                .put(EmeraldOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new EmeraldOrbState(orb), json -> new EmeraldOrbState(json)));
        StateFactories.orbByClassMap
                .put(OnyxOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new OnyxOrbState(orb), json -> new OnyxOrbState(json)));
        StateFactories.orbByClassMap
                .put(OpalOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new OpalOrbState(orb), json -> new OpalOrbState(json)));
        StateFactories.orbByClassMap
                .put(SapphireOrb.class
                        .getSimpleName(), new OrbState.OrbFactories(orb -> new SapphireOrbState(orb), json -> new SapphireOrbState(json)));
    }

    private void populatePowerFactory() {
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