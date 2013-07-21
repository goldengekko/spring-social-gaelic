/*
 * INSERT COPYRIGHT HERE
 */

package org.springframework.social.gaelic.api;

/**
 *
 * @author sosandstrom
 */
public class GaelicProfile {
    
    private String id;

    private String username;
    
    private String email;
    
    private String password;

    private Long state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
