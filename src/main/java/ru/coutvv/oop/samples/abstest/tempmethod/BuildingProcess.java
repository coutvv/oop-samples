package ru.coutvv.oop.samples.abstest.tempmethod;

public interface BuildingProcess {
	
	/**
	 * Начать строительство
	 */
	void createProcess(double x, double y);
	
	/**
	 * Строим за фрейм
	 */
	void progressPerFrame();
	
	/**
	 * Получение прогресса строительство
	 * @return
	 */
	double getProgress();
	
	/**
	 * Готовность здания
	 * @return
	 */
	boolean isReady();
	
}
