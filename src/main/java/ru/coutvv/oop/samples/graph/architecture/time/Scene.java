package ru.coutvv.oop.samples.graph.architecture.time;

import java.util.List;

import ru.coutvv.oop.samples.graph.architecture.DrawableObject;

/**
 * Интерфейс сцены мира(физика)
 * @author lomovtsevrs
 */
public interface Scene {

	/**
	 * Получить все объекты для отрисовки
	 * @return
	 */
	List<DrawableObject> getObjects();
	
	/**
	 * Сделать изменения
	 */
	void turnAround();
}
