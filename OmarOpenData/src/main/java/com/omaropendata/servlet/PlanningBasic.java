package com.omaropendata.servlet;


import biweekly.ICalendar;
import ezvcard.VCard;
import com.omaropendata.entity.Person;
import com.omaropendata.entity.Planning;
import com.omaropendata.mapper.ICalendarMapper;
import com.omaropendata.mapper.VcardMapper;
import com.omaropendata.dao.Dao;
import com.omaropendata.utils.ServletHelper;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by omar
 */
@WebServlet("/planning-id")
public class PlanningBasic extends HttpServlet {


    /**
     * Object for DB access
     */
    @Inject
    private Dao dao;


    /**
     * mapper beetwen Planning class and Icalendar
     */
    @Inject
    private ICalendarMapper iCalendarMapper;

    private static final Logger LOGGER = Logger.getLogger(PlanningBasic.class.getName());


    /**
     * return planning from specific iD (JSON format)
     * parameter id : id of a planning
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("resource")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final ServletOutputStream out = new ServletHelper().configureAndGetOutputStream(response);
        // Add content type (mime type of icalendar)
        response.setContentType("text/calendar");
        response.setCharacterEncoding("UTF-8");
        // check parameter
        String idPlanning = request.getParameter("id");
        // check if exist else throw Illegal Argument exception
        if(idPlanning == null){
            throw new IllegalArgumentException(" Please Enter Planning ID ! ");
        }

        LOGGER.info("The planning found with this ID  : "+ idPlanning);

        // get planning
        ICalendar iCalendar = dao.getPlanning(idPlanning);
        if (iCalendar == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.println("Unabel to find any Planning : "+ idPlanning);
            return ;
        }

        LOGGER.info(" Planning found with the id : "+idPlanning);
        out.println(String.valueOf(iCalendar));
    }

}