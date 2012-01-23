package servlet;


import java.io.Serializable;


/**
 * MSM silently fails on non serializable
 *
 * Best practice DTO Style, one big get/set rather than granular ones.
 */
public class SessionObj implements Serializable {
    public int count;
    public long last;
}
