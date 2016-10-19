package ru.coutvv.oop.samples.starcraft.building.production;

import ru.coutvv.oop.samples.starcraft.unit.Unit;
/**
 * Абстрактная фабрика неопределённой касты
 * 
 * @author lomovtsevrs
 */
public interface GatewayFactory {
	public Unit createStalker();
	public Unit createZealot();
}
