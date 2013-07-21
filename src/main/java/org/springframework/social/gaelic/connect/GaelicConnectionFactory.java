/*
 * INSERT COPYRIGHT HERE
 */

package org.springframework.social.gaelic.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.gaelic.api.Gaelic;

/**
 *
 * @author sosandstrom
 */
public class GaelicConnectionFactory extends OAuth2ConnectionFactory<Gaelic> {
    
    public static final String PROVIDER_ID = "gaelic";

    public GaelicConnectionFactory(String instanceUrl, String consumerKey, String consumerSecret) {
        super(PROVIDER_ID, new GaelicServiceProvider(instanceUrl, consumerKey, consumerSecret), 
                new GaelicAdapter());
    }

}
