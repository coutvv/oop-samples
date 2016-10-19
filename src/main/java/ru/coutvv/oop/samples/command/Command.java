package ru.coutvv.oop.samples.command;

/**
 * Паттерн Команда инкапсулирует запрос в виде 
 * объекта, делая возможной параметризацию клиентских
 * объектов с другими запросами, организацию 
 * очереди или регистрацию запросов, а также
 * поддержку отмены операций
 * 
 * @author lomovtsevrs
 */
public interface Command {
	void execute();
	void undo();
}
