package vacantstate.cards;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.megacrit.cardcrawl.cards.AbstractCard;
import savestate.CardState;
import theVacant.cards.AbstractVacantCard;

public class AbstractVacantCardState extends CardState {
    public static final String TYPE_KEY = "AbstractVacantCard";

    private final boolean rebound;
    private final boolean getBonusMillToMagic;
    private final boolean isHeavy;
    private final boolean postMillAction;

    public AbstractVacantCardState(AbstractCard card) {
        super(card);

        AbstractVacantCard realCard = (AbstractVacantCard) card;

        this.rebound = realCard.rebound;
        this.getBonusMillToMagic = realCard.getBonusMillToMagic;
        this.isHeavy = realCard.isHeavy;
        this.postMillAction = realCard.postMillAction;
    }

    public AbstractVacantCardState(String json) {
        super(json);

        JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();

        this.rebound = parsed.get("rebound").getAsBoolean();
        this.getBonusMillToMagic = parsed.get("getBonusMillToMagic").getAsBoolean();
        this.isHeavy = parsed.get("isHeavy").getAsBoolean();
        this.postMillAction = parsed.get("postMillAction").getAsBoolean();
    }

    public AbstractVacantCardState(JsonObject cardJson) {
        super(cardJson);

        this.rebound = cardJson.get("rebound").getAsBoolean();
        this.getBonusMillToMagic = cardJson.get("getBonusMillToMagic").getAsBoolean();
        this.isHeavy = cardJson.get("isHeavy").getAsBoolean();
        this.postMillAction = cardJson.get("postMillAction").getAsBoolean();
    }

    @Override
    public AbstractCard loadCard() {
        AbstractVacantCard result = (AbstractVacantCard) super.loadCard();

        result.rebound = rebound;
        result.getBonusMillToMagic = getBonusMillToMagic;
        result.isHeavy = isHeavy;
        result.postMillAction = postMillAction;

        return result;
    }

    @Override
    public String encode() {
        String result = super.encode();

        JsonObject parsed = new JsonParser().parse(result).getAsJsonObject();

        parsed.addProperty("rebound", rebound);
        parsed.addProperty("getBonusMillToMagic", getBonusMillToMagic);
        parsed.addProperty("isHeavy", isHeavy);
        parsed.addProperty("postMillAction", postMillAction);

        parsed.addProperty("type", TYPE_KEY);

        return parsed.toString();
    }

    @Override
    public JsonObject jsonEncode() {
        JsonObject result = super.jsonEncode();

        result.addProperty("rebound", rebound);
        result.addProperty("getBonusMillToMagic", getBonusMillToMagic);
        result.addProperty("isHeavy", isHeavy);
        result.addProperty("postMillAction", postMillAction);

        result.addProperty("type", TYPE_KEY);

        return result;
    }
}
