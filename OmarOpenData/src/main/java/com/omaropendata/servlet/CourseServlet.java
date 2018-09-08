package com.omaropendata.servlet;

import com.omaropendata.entity.Course;
//import com.omaropendata.mapper.JsonMapper;
import com.omaropendata.utils.JPAutil;
import com.omaropendata.utils.ServletHelper;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Omar
 */
@WebServlet("/course")
public class CourseServlet extends HttpServlet {

   
    

    /**
     * mapper json to object and object to json
     */
    @Inject
   // private JsonMapper jsonMapper;


    private static final Logger LOGGER = Logger.getLogger(CourseServlet.class.getName());


    /**
     * return all Course (JSON format)
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        @SuppressWarnings("resource")
        final ServletOutputStream out = new ServletHelper().configureAndGetOutputStream(response);
        // Add content type (JSON format)
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        EntityManager entityManager = JPAutil.getEntityManager("OmarOpenData");

        LOGGER.info("we retrieve the list of courses");

        // get All the Course
        List<Course> courses = entityManager.createQuery("select c from Course c").getResultList();

        if (courses != null) {
            LOGGER.info(" list of courses size : " + courses.size());
        }

        // convert to JSON
       // String json = jsonMapper.convertObjectToJson(courses);
        //Jsonb jsonb = JsonbBuilder.create();
        Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withFormatting(true));
        final String json = jsonb.toJson(courses);
        out.println(json);
    }


}
