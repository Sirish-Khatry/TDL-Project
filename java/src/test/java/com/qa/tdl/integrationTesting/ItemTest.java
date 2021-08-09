package com.qa.tdl.integrationTesting;

import java.beans.Transient;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.junit.jupiter.api.Test;
import com.qa.tdl.entity.Item;
import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class)
        .withIgnoredAnnotations(Entity.class, Id.class, Embeddable.class, MappedSuperclass.class, Transient.class)
        .verify();
	}

}
