package ru.coutvv.oop.samples.graph.architecture.time;

import java.util.ArrayList;
import java.util.List;

import ru.coutvv.oop.samples.abstest.command.Command;
import ru.coutvv.oop.samples.abstest.command.CommandCenter;
import ru.coutvv.oop.samples.abstest.command.UnitCommandCenter;
import ru.coutvv.oop.samples.abstest.command.impl.UnitCommandMove;
import ru.coutvv.oop.samples.graph.architecture.DrawableObject;
import ru.coutvv.oop.samples.graph.architecture.model.DrawableUnit;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Probe;

public class SimpleScene implements Scene {
	List<DrawableObject> objs = new ArrayList<>();
	Probe probe1, probe2;
	int tirell = 1;
	private CommandCenter cc;
	public SimpleScene(int probeTexture) {
		
		cc = new UnitCommandCenter();
		
		
		
		probe1 = new Probe();
		probe2 = new Probe();
		DrawableObject obj = new DrawableUnit(probe1, 400,400, probeTexture);
		objs.add(obj);
		objs.add(new DrawableUnit(probe2, 50, 50, probeTexture));
		

		Command cmd = new UnitCommandMove(probe2, 200, 200);
		
		cc.addCommand(cmd);
	}

	@Override
	public List<DrawableObject> getObjects() {
		return objs;
	}

	@Override
	public void turnAround() {
		try {
			if(!(probe1.getX() <= 800 && probe1.getX() >= 0)){
				tirell = -tirell;
			}
			probe1.setX(probe1.getX() + tirell);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cc.executeCommands();
		
	}

}
