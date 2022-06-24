
package com.ezbooking.method;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ezbooking.method package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Display_QNAME = new QName("http://method.ezbooking.com/", "display");
    private final static QName _DisplayBook_QNAME = new QName("http://method.ezbooking.com/", "displayBook");
    private final static QName _DisplayBookResponse_QNAME = new QName("http://method.ezbooking.com/", "displayBookResponse");
    private final static QName _DisplayResponse_QNAME = new QName("http://method.ezbooking.com/", "displayResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ezbooking.method
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Display }
     * 
     */
    public Display createDisplay() {
        return new Display();
    }

    /**
     * Create an instance of {@link DisplayBook }
     * 
     */
    public DisplayBook createDisplayBook() {
        return new DisplayBook();
    }

    /**
     * Create an instance of {@link DisplayBookResponse }
     * 
     */
    public DisplayBookResponse createDisplayBookResponse() {
        return new DisplayBookResponse();
    }

    /**
     * Create an instance of {@link DisplayResponse }
     * 
     */
    public DisplayResponse createDisplayResponse() {
        return new DisplayResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Display }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://method.ezbooking.com/", name = "display")
    public JAXBElement<Display> createDisplay(Display value) {
        return new JAXBElement<Display>(_Display_QNAME, Display.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://method.ezbooking.com/", name = "displayBook")
    public JAXBElement<DisplayBook> createDisplayBook(DisplayBook value) {
        return new JAXBElement<DisplayBook>(_DisplayBook_QNAME, DisplayBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://method.ezbooking.com/", name = "displayBookResponse")
    public JAXBElement<DisplayBookResponse> createDisplayBookResponse(DisplayBookResponse value) {
        return new JAXBElement<DisplayBookResponse>(_DisplayBookResponse_QNAME, DisplayBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://method.ezbooking.com/", name = "displayResponse")
    public JAXBElement<DisplayResponse> createDisplayResponse(DisplayResponse value) {
        return new JAXBElement<DisplayResponse>(_DisplayResponse_QNAME, DisplayResponse.class, null, value);
    }

}
