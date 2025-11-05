package com.genologics.ri.globaltoken;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * A class that's not in the API but can be used as a root element to check
 * that the serialisation of {@link GlobalToken} and {@link GlobalTokens}
 * works. When there is something in the API that actually uses these types,
 * this field is unnecessary.
 */
@XmlType(name = "globalTokenHolder")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "global-token-holder")
public class GlobalTokenHolder implements Serializable
{
    private static final long serialVersionUID = -4152106020350196442L;

    @XmlElement(name = "global-token")
    GlobalToken token;

    @XmlElement(name = "global-tokens")
    GlobalTokens tokenList;

    public GlobalTokenHolder()
    {
    }

    public GlobalToken getToken()
    {
        return token;
    }

    public void setToken(GlobalToken token)
    {
        this.token = token;
    }

    public GlobalTokens getList()
    {
        return tokenList;
    }

    public void setList(GlobalTokens list)
    {
        this.tokenList = list;
    }

}
