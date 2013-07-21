/*
 * INSERT COPYRIGHT HERE
 */

package org.springframework.social.gaelic.api.impl;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.gaelic.api.Gaelic;
import org.springframework.social.gaelic.api.GaelicProfile;

/**
 * 
 * @author sosandstrom
 */
public class GaelicTemplate extends AbstractOAuth2ApiBinding implements Gaelic {

    static final Logger         LOG              = LoggerFactory.getLogger(GaelicTemplate.class);

    private String              instanceUrl;

    public GaelicTemplate(final String accessToken, String instanceUrl) {
        super(accessToken);
        final SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory() {
            @Override
            protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
                super.prepareConnection(connection, httpMethod);
                connection.setRequestProperty("Authorization", String.format("OAuth %s", accessToken));
                LOG.debug("Authorization: OAuth {}", accessToken);
            }
        };
        requestFactory.setConnectTimeout(15000);
        requestFactory.setReadTimeout(15000);
        setRequestFactory(requestFactory);
        this.instanceUrl = instanceUrl;
    }


    @Override
    public GaelicProfile getProfile() {
        return getProfile("me");
    }

    @Override
    public GaelicProfile getProfile(String userId) {
        final String url = String.format("%s/profile/v10/{id}", instanceUrl);
        GaelicProfile profile = getRestTemplate().getForObject(url, GaelicProfile.class, userId);

        return profile;
    }

    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

}
