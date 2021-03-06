package ascensionminus.patches;

import java.lang.reflect.Field;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.dungeons.Exordium;
import com.megacrit.cardcrawl.dungeons.TheBeyond;
import com.megacrit.cardcrawl.dungeons.TheCity;

public class MoreUpgradedCardsPatch {

	@SpirePatch(clz = Exordium.class, method = "initializeLevelSpecificChances")
	public static class ExordiumPatch {
		public static void Postfix(Exordium __instance) {
			if (AbstractDungeon.ascensionLevel <= -7) {
				try {
					Field field = AbstractDungeon.class.getDeclaredField("cardUpgradedChance");
					field.setAccessible(true);
					field.setFloat(null, 0.25F);
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SpirePatch(clz = TheCity.class, method = "initializeLevelSpecificChances")
	public static class TheCityPatch {
		public static void Postfix(TheCity __instance) {
			if (AbstractDungeon.ascensionLevel <= -7) {
				try {
					Field field = AbstractDungeon.class.getDeclaredField("cardUpgradedChance");
					field.setAccessible(true);
					field.setFloat(null, 0.5F);
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@SpirePatch(clz = TheBeyond.class, method = "initializeLevelSpecificChances")
	public static class TheBeyondPatch {
		public static void Postfix(TheBeyond __instance) {
			if (AbstractDungeon.ascensionLevel <= -7) {
				try {
					Field field = AbstractDungeon.class.getDeclaredField("cardUpgradedChance");
					field.setAccessible(true);
					field.setFloat(null, 0.75F);
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
