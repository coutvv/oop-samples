package ru.coutvv.oop.samples.graph.architecture.time;

import java.util.List;

import ru.coutvv.oop.samples.graph.architecture.DrawableObject;

/**
 * Интерфейс сцены мира(физика) фасад? 
 * @author lomovtsevrs
 */
public interface Scene {

	/**
	 * Получить все объекты для отрисовки
	 * @return
	 */
	List<DrawableObject> getObjects();
	
	/**
	 * Сделать изменения за фрейм(передвижения юнитов, полёт пули и так далее)
	 */
	void turnAround();
}
