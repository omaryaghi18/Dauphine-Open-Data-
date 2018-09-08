package com.omaropendata.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by Omar YAGHI 
 *
 * enumeration of function types in the directory
 *
 * (non-exhaustive list 
 */
public enum FunctionType {
    MAITRE_DE_CONFERENCES,
    ENS_VAC,
    PROFESSEUR_DES_UNIVERSITES
}
