package com.omaropendata.mapper;




import ezvcard.VCard;
import ezvcard.property.Expertise;
import ezvcard.property.StructuredName;
import com.omaropendata.entity.Person;
import javax.enterprise.context.ApplicationScoped;

/**
 * A mapper class used to convert Person entities to VCard entities  
 * @author Omar
 *
 */
@ApplicationScoped
public class VcardMapper {

	public VcardMapper() {
	}
	
	/**
	 * Convert a person entity into an VCard entity
	 * @param person the person entity to encode, cannot be null
	 * @return the person encoded as a VCard entity
	 */
	public VCard encodePersonToVcard(Person person) {
		
		VCard vcard = new VCard();
		
		StructuredName n = new StructuredName();
		
		n.setFamily(person.getLastName());
		n.setGiven(person.getFirstName());
		vcard.setStructuredName(n);
		vcard.setFormattedName(person.getFirstName() + " " + person.getLastName());
			
		person.getEmails().forEach((mail) -> {
			vcard.addEmail(mail);
		});
		
		if (!person.getStructures().isEmpty()) {
			vcard.setOrganization(person.getStructures().get(0));		
		}
		
		if (person.getNumber() != null) {
		vcard.addTelephoneNumber(person.getNumber());
		}
		
		if (person.getRole() != null) {
			vcard.addExpertise(new Expertise(person.getRole().toString()));
		}
		
		return vcard;
	}
	
}

