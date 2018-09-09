package com.omaropendata.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


import com.google.common.base.Optional;
import com.google.common.base.Strings;



/**
 * Function No.1 Course object to represent a Dauphine course.
 * @author     Omar
 * @version     %I%, %G%
 * @since       1.0
 */
@Entity()
public class Course implements Serializable {
	

	private static final long serialVersionUID = 1L;
	/**
     * Not <code>null</code>,  The id Course
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private String idCourse;
	/**
     *Not <code>null</code>,  the description course
     */
	private String descriptions = "";
	/**
     *Not <code>null</code>, List of teachers and what kind of course they will teach
     */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private List<CoursePart> coursePart = new ArrayList<>() ;
	
	/**
	 * Returns the list of course Part ( (TD, 20h, Teacher),()...),
	 *
	 * @return not <code>null</code>.
	 */
	public List<CoursePart> getCoursePart() {
		return coursePart;
	}

	/**
	 * Sets the list of course Part.
	 *
	 * @param coursePart
	 *            Not <code>null</code>, will be converted to an empty string.
	 */
	public void setCoursePart(List<CoursePart> coursePart) {
		this.coursePart = coursePart;
	}

	/**
     * Not <code>null</code>, The name of the course
     */ 
	@Column(nullable = false)
	private String courseName = "";
	/**
     *May be <code>null</code>, the language of the course in witch it written 
     */
	@Column(nullable = true)
	private Locale locale ;
	/**
     *Not <code>null</code>, The course's credit
     */
	@Column(nullable = false)
	private int credits;
	/**
     *Not <code>null</code>, The course specialty
     */
	@Column(nullable = false)
	private TypeSpecialty specialty;
	
	 /** 
	  * Course constructor without fields
     */
	public Course() {
		
	}

	/** 
	  * Course constructor with fields
	  * 
	  * @param courseName Not <code>null</code>,  the name of the course ( Big Data, ...)
    */
	public Course( String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Returns this course's id, or an empty string if unknown.
	 *
	 * @return not <code>null</code>.
	 */
	public String getIdCourse() {
		return idCourse;
	}

	/**
	 * Sets this course's id.
	 *
	 * @param idCourse
	 *         Not  <code>null</code>,
	 */
	public void setIdCourse(String idCourse) {
		this.idCourse = idCourse;
	}

	/**
	 * Returns this course's description, or an empty string if unknown.
	 *
	 * @return not <code>null</code>.
	 */
	public String getDescription() {
		return descriptions;
	}
 
	/**
	 * Sets this course's description.
	 *
	 * @param description  Not <code>null</code>.
	 */
	public void setDescription(String description) {
		this.descriptions = description;
	}
	/**
	 * Returns this course's name, or an empty string if unknown.
	 *
	 * @return not <code>null</code>.
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets this course's name.
	 *
	 * @param courseName Not <code>null</code>.
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	/**
	 * Returns this course's locale.
	 * 
	 *@return not  <code>null</code>.
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Sets this course's locale.
	 *
	 * @param locale may be <code>null</code>,
	 */
	public void setLocale(Locale locale) {
		this.locale= (locale);
	}

	/**
	 * Returns this course's credits.
	 *
	 *@return not <code>null</code>.
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets this course's credits.
	 *
	 * @param credits
	 * not <code>null</code>.
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * Returns this course's specialty.
	 *
	 * @return not <code>null</code>.
	 */
	public TypeSpecialty getSpecialty() {
		return specialty;
	}

	/**
	 * Sets this course's specialty.
	 *
	 * @param specialty Not <code>null</code>,
	 */
	public void setSpecialty(TypeSpecialty specialty) {
		this.specialty= specialty;
	}
	
	
	
}
