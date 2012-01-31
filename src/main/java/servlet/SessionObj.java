package servlet;


import java.io.Serializable;


/**
 * MSM silently fails on non serializable
 */
public class SessionObj implements Serializable {

    //IMPORTANT
    static final long serialVersionUID = 1L;

    public int count;
    public long last;
    public byte[] weight;
}
