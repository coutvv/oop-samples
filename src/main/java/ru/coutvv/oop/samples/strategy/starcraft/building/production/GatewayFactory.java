package ru.coutvv.oop.samples.strategy.starcraft.building.production;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
/**
 * Абстрактная фабрика неопределённой касты
 * 
 * @author lomovtsevrs
 */
public interface GatewayFactory {
	public Unit createStalker();
	public Unit createZealot();
}
