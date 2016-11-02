package ru.coutvv.oop.samples.abstest.tempmethod;

public class ProtossBuildingProcess extends AbstractBuildingProcess {

	double protossBuildSpeed = 0.1;
	
	boolean checkBuildCondition() {
		
		return true; //строимся всегда ибо протоссы же!
	}

	void changePerFrame() {
			this.progress += protossBuildSpeed;	
	}


}
