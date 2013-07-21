/*
 * INSERT COPYRIGHT HERE
 */

package org.springframework.social.gaelic.connect;

import org.springframework.social.oauth2.OAuth2Template;

/**
 *
 * @author sosandstrom
 */
class GaelicOAuth2Template extends OAuth2Template {

    public GaelicOAuth2Template(String consumerKey, String consumerSecret, String authorizeUrl, String tokenUrl) {
        this(consumerKey, consumerSecret, authorizeUrl, null, tokenUrl);
    }

    public GaelicOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String authenticateUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, authenticateUrl, accessTokenUrl);
        setUseParametersForClientAuthentication(true);
    }

}
