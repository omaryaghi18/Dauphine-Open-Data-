package com.omaropendata.servlet;


import com.omaropendata.entity.Person;
import com.omaropendata.utils.JPAutil;
import com.omaropendata.utils.ServletHelper;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Omar
 */
@WebServlet("/person")
public class PersonServlet extends HttpServlet {


    private static final Logger LOGGER = Logger.getLogger(PersonServlet.class.getName());


    /**
     * return all Person (JSON format)
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        @SuppressWarnings("resource")
        final ServletOutputStream out = new ServletHelper().configureAndGetOutputStream(response);
        
        // Add content type (JSON format)
        //TODO: remettre en application JSON avec la librairie JSON-B // librairie ajouté , mais les dependancies sont pas trouvé , MVN error
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");


       // EntityManager entityManager = JPAutil.getEntityManager("OmarOpenData");

     // TODO JPA perssisting operation
        
        
     		 EntityManagerFactory factory;
     		 EntityManager entityManager;
     		factory =  Persistence.createEntityManagerFactory("OmarOpenData");
     		entityManager = factory.createEntityManager();
     	//	final ServletOutputStream out = new ServletHelper().configureAndGetOutputStream(response);
     		out.println("Start DAO opretation");
     		out.flush();
        
        
        
        LOGGER.info("Retriving list of Persons");

        // get All the Person
        List<Person> persons = entityManager.createQuery("select p from Person p").getResultList();

        if (persons != null) {
            LOGGER.info(" list of persons size : " + persons.size());
        }
        
        // transformer en JSON 

        Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withFormatting(true));
        final String json = jsonb.toJson(persons);
        out.println(Arrays.toString(persons.toArray()));
    }
}