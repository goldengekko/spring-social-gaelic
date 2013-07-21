/*
 * INSERT COPYRIGHT HERE
 */

package org.springframework.social.gaelic.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.gaelic.api.Gaelic;
import org.springframework.social.gaelic.api.impl.GaelicTemplate;

/**
 *
 * @author sosandstrom
 */
public class GaelicServiceProvider extends AbstractOAuth2ServiceProvider<Gaelic> {
    
    final String instanceUrl;
    
    public GaelicServiceProvider(String instanceUrl, String consumerKey, String consumerSecret) {
        this(instanceUrl, consumerKey, consumerSecret,
                String.format("%s/authorize", instanceUrl),
                String.format("%s/token", instanceUrl));
    }

    public GaelicServiceProvider(String instanceUrl, String clientId, String clientSecret, String authorizeUrl, String tokenUrl) {
        super(new GaelicOAuth2Template(clientId, clientSecret, authorizeUrl, tokenUrl));
        this.instanceUrl = instanceUrl;
    }

    @Override
    public Gaelic getApi(String accessToken) {
        final GaelicTemplate template = new GaelicTemplate(accessToken, instanceUrl);
        return template;
    }
    
}
