package ru.coutvv.oop.samples.abstest.tempmethod;

public abstract class AbstractBuildingProcess implements BuildingProcess {
	
	protected double progress;
	protected boolean isReady;
	
	protected double x,y;
	
//	protected 

	@Override
	public void createProcess(double x, double y) {
		this.x = x;
		this.y = y;
		isReady = false;
		progress = 0;
	}

	/**
	 * Шаблонный метод задаёт "скелет" алгоритма
	 * в методе, оставляя определение реализации некоторых
	 * шагов субклассам. Субклассы могут переопределять 
	 * некоторые части алгоритма без изменения его структуры
	 */
	@Override
	public void progressPerFrame(){
		if(checkBuildCondition()) {
			if(progress < 100) {
				changePerFrame();
			} else {
				this.isReady = true;
			}
		}
	};

	@Override
	public double getProgress() {
		return progress;
	}

	@Override
	public boolean isReady() {
		return isReady;
	}
	
	abstract boolean checkBuildCondition();
	
	abstract void changePerFrame();

}
