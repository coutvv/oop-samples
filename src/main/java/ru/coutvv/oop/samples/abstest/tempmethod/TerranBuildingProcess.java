package ru.coutvv.oop.samples.abstest.tempmethod;

import ru.coutvv.oop.samples.starcraft.unit.Unit;

public class TerranBuildingProcess extends AbstractBuildingProcess {
	
	Unit csv;
	
	public  TerranBuildingProcess(Unit csv) {
		this.csv = csv;
	}
	
	

	@Override
	boolean checkBuildCondition() {
		double dist = csv.getX()*csv.getX() + csv.getY()*csv.getY();
		Math.sqrt(dist);
		return dist < scvBuild;
	}
	/**
	 * Расстояние на котором ксмка может строить
	 */
	final double scvBuild = 5;
	/**
	 * Скорость строительства
	 */
	final double scvSpeed = 0.2;

	@Override
	void changePerFrame() {
		this.progress += scvSpeed;
	}

}
