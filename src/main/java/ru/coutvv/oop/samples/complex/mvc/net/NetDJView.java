package ru.coutvv.oop.samples.complex.mvc.net;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.coutvv.oop.samples.complex.mvc.model.BeatModel;
import ru.coutvv.oop.samples.complex.mvc.model.BeatModelInterface;
import ru.coutvv.oop.samples.complex.mvc.model.heart.HeartAdapter;
import ru.coutvv.oop.samples.complex.mvc.model.heart.HeartModel;

/**
 * Сервлет-контроллер
 * 
 * @author lomovtsevrs
 */
public class NetDJView extends HttpServlet {

	public void init() throws ServletException {
		BeatModelInterface beatModel = new BeatModel();
		beatModel.init();
		getServletContext().setAttribute("beatModel", beatModel);

//		BeatModelInterface heart = new HeartAdapter(new HeartModel());
//		heart.init();
//		getServletContext().setAttribute("beatModel", heart);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		BeatModelInterface model = (BeatModelInterface) getServletContext().getAttribute("beatModel");
		String bpm = request.getParameter("bpm");
		if(bpm == null) {
			bpm = model.getBPM() + "";
		}
		String set = request.getParameter("set");
		if(set != null) {
			int bpmNumber = 90;
			bpmNumber = Integer.parseInt(bpm);
			model.setBPM(bpmNumber);
		}
		
		String increase = request.getParameter("increase");
		if(increase != null) {
			model.setBPM(model.getBPM() + 1);
		}
		
		String decrease = request.getParameter("decrease");
		if(decrease != null) {
			model.setBPM(model.getBPM()-1);
		}
		
		String on = request.getParameter("on");
		if(on != null) {
			model.on();
		}
		
		String off = request.getParameter("off");
		if(off != null) {
			model.off();
		}
		
		request.setAttribute("beatModel", model);
//		RequestDispatcher disp = request.getRequestDispatcher("/jsp/DJView.jsp");
//		disp.forward(request, response);
		response.sendRedirect("/jetty-jsp-example/jsp/DJView.jsp");
	}
}
