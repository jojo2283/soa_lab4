package com.jellyone.oscars.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getOscarLosersRequest", namespace = "http://jellyone.com/oscars")
public class GetOscarLosersRequest {
    // пустой запрос
}