package ascensionminus.patches;

import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic.RelicTier;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;

public class BattleRewardPatch {
	@SpirePatch(clz = AbstractRoom.class, method = "update")
	public static class RicherBosses {
		@SpireInsertPatch(rloc = 115, localvars = { "tmp" })
		public static void Insert(AbstractRoom __instance, @ByRef int[] tmp) {
			if (AbstractDungeon.ascensionLevel <= -8)
				tmp[0] = MathUtils.round(tmp[0] * 1.5F);
		}
	}

	@SpirePatch(clz = AbstractRoom.class, method = "update")
	public static class GainMaxHpAfterBoss {
		@SpireInsertPatch(rloc = 107)
		public static void Insert(AbstractRoom __instance) {
			if (__instance instanceof MonsterRoomBoss) {
				if (AbstractDungeon.ascensionLevel <= -11)
					AbstractDungeon.player.increaseMaxHp(AbstractDungeon.player.getAscensionMaxHPLoss(), true);
			}
		}
	}

	@SpirePatch(clz = AbstractRoom.class, method = "update")
	public static class NormalEnemiesDropRelic {
		@SpireInsertPatch(rloc = 157)
		public static void Insert(AbstractRoom __instance) {
			if (AbstractDungeon.ascensionLevel <= -14)
				if (AbstractDungeon.potionRng.random(0, 99) < 20)
					__instance.addRelicToRewards(AbstractDungeon.returnRandomRelicTier());
		}
	}

	@SpirePatch(clz = AbstractRoom.class, method = "update")
	public static class ElitesDropCard {
		@SpireInsertPatch(rloc = 134)
		public static void Insert(AbstractRoom __instance) {
			if (AbstractDungeon.ascensionLevel <= -15)
				__instance.addCardToRewards();
		}
	}

	@SpirePatch(clz = AbstractRoom.class, method = "update")
	public static class BossDropRelic {
		@SpireInsertPatch(rloc = 107)
		public static void Insert(AbstractRoom __instance) {
			if (AbstractDungeon.ascensionLevel <= -16)
				__instance.addRelicToRewards(AbstractDungeon.returnRandomRelic(RelicTier.RARE));
		}
	}

	@SpirePatch(clz = AbstractRoom.class, method = "update")
	public static class RewardsContainPotion {
		@SpireInsertPatch(rloc = 170)
		public static void Insert(AbstractRoom __instance) {
			if (AbstractDungeon.ascensionLevel <= -17)
				__instance.rewards.add(new RewardItem(AbstractDungeon.returnRandomPotion()));
		}
	}
}
