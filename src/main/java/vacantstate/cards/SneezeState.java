package vacantstate.cards;

import basemod.ReflectionHacks;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.cards.AbstractCard;
import savestate.CardState;
import theVacant.cards.Skills.Sneeze;

public class SneezeState extends CardState {
    private final int retainBonus;

    public SneezeState(AbstractCard card) {
        super(card);

        this.retainBonus = ReflectionHacks.getPrivate(card, Sneeze.class, "retainBonus");
    }

    public SneezeState(String json) {
        super(json);

        JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();

        this.retainBonus = parsed.get("retainBonus").getAsInt();
    }

    @Override
    public AbstractCard loadCard() {
        AbstractCard result = super.loadCard();

        ReflectionHacks.setPrivate(result, Sneeze.class, "retainBonus", retainBonus);

        return result;
    }

    @Override
    public String encode() {
        String result = super.encode();

        JsonObject parsed = new JsonParser().parse(result).getAsJsonObject();

        parsed.addProperty("retainBonus", retainBonus);

        return parsed.toString();
    }
}
