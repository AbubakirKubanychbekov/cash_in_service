package com.ak.cash_in_service.dto.response;

import com.ak.cash_in_service.enums.Status;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlRegistry;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;
import org.glassfish.jaxb.core.annotation.XmlLocation;
import org.glassfish.jaxb.runtime.XmlAccessorFactory;

/**
 * @author Abubakir Dev
 */
@Getter @Setter
@XmlRootElement(name = "MessageResponse")
public class MessageResponse {
    private Status status;
    private String message;
}
