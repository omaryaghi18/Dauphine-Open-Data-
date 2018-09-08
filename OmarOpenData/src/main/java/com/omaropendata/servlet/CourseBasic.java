package com.omaropendata.servlet;



import com.omaropendata.dao.Dao;
import com.omaropendata.entity.Course;
import com.omaropendata.utils.JPAutil;
import com.omaropendata.utils.ServletHelper;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Omar
 */
@WebServlet("/course-id")
public class CourseBasic extends HttpServlet {

    /**
     *  acces to database
     */
    @Inject
    private Dao dao;
    /**
     * mapper json to object and object to json
     */
    @Inject
   


    private static final Logger LOGGER = Logger.getLogger(CourseBasic.class.getName());


    /**
     * return course from specific iD (JSON format)
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final ServletOutputStream out = new ServletHelper().configureAndGetOutputStream(response);
        // Add content type (JSON format)
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");



        // check parameter
        String idCourse = request.getParameter("id");

        // check if exist else throw Illegal Argument exception
        if(idCourse == null){
            throw new IllegalArgumentException("We need id of a Course ! ");
        }

        LOGGER.info("we return course with id  : "+ idCourse);

        // get All the Course
        Course course = dao.getCourse(idCourse);

        if (course != null) {
            LOGGER.info(" successful find course with id : "+idCourse);
           
           
         // convert to JSON
            
             //Jsonb jsonb = JsonbBuilder.create();
             Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withFormatting(true));
             final String json = jsonb.toJson(course);
             out.println(json);

        }
        else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.println("Impossible to find course with id : "+ idCourse);
        }

    }

}
