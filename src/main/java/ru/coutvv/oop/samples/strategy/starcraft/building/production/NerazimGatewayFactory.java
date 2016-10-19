package ru.coutvv.oop.samples.strategy.starcraft.building.production;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.Stalker;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.Zealot;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.buff.special.InvisibilityBuff;

public class NerazimGatewayFactory implements GatewayFactory {

	public Unit createStalker() {
		Unit result = new InvisibilityBuff(new Stalker());
		return result;
	}

	public Unit createZealot() {
		Unit result = new InvisibilityBuff(new Zealot());
		return result;
	}

}
