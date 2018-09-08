package com.omaropendata.dao;


import biweekly.ICalendar;
import ezvcard.VCard;
import com.omaropendata.entity.Course;
import com.omaropendata.entity.Person;
import com.omaropendata.entity.Planning;
import com.omaropendata.entity.Triple;
import com.omaropendata.mapper.ICalendarMapper;
import com.omaropendata.mapper.VcardMapper;
import com.omaropendata.utils.JPAutil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Omar
 */
@ApplicationScoped
/**
 * Class who contains query
 */
public class Dao {


    /**
     * Object for DB access
     */
    @Inject
    private JPAutil jpaUtil;

    /**
     *  VcardMapper map person to vcard
     */
    @Inject
    private VcardMapper vcardMapper;

    /**
     * Mapper for planning to Icalendar
     */
    @Inject
    private ICalendarMapper iCalendarMapper;

    public EntityManager getEntityManager(){
        return jpaUtil.getEntityManager("OmarOpenData");
    }

    /**
     *  return specific person from idPerson
     * @param idPerson
     * @return Person format VCard
     */
    public VCard getPerson(String idPerson){
        EntityManager entityManager = this.getEntityManager();
        Person person = entityManager.find(Person.class, idPerson);
        Objects.requireNonNull(person);
        return vcardMapper.encodePersonToVcard(person);
    }

    /**
     *  return course with idCourse
     * @param idCourse
     * @return
     */
    public Course getCourse(String idCourse){
        EntityManager entityManager = this.getEntityManager();
        Course course = entityManager.find(Course.class, idCourse);
        return course;
    }
    /**
     *  return Planning with idPlanning
     * @param idPlanning id of a planning
     * @return Icalendar fomrmat
     */
    public ICalendar getPlanning(String idPlanning){
        EntityManager entityManager = this.getEntityManager();
        Planning planning = entityManager.find(Planning.class, idPlanning);
        Objects.requireNonNull(planning);

        return iCalendarMapper.encodePlanningToICalendar(planning);
    }
    
    /**
     * add new triple
     * @param subject
     * @param predicate
     * @param object
     * @return
     */
    public Triple addTriple(String subject,String predicate,String object){
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction tx = this.getEntityManager().getTransaction();
        Triple triple = new Triple();
        triple.setSubject(subject);
        triple.setPredicate(predicate);
        triple.setObject(object);
        tx.begin();
        entityManager.persist(triple);

        tx.commit();
        return triple;
    }

    /**
     * get all data for a subject
     * @param subject use in createQuery
     * @return list of triple
     */
    public List<Triple> getTriple(String subject){
        EntityManager entityManager = this.getEntityManager();
        List triples =  entityManager.createQuery("SELECT u FROM Triple u WHERE u.subject=:subject",Triple.class).getResultList();

        return triples;
    }
}
