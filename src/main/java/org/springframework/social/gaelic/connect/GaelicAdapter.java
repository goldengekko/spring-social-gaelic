/*
 * INSERT COPYRIGHT HERE
 */

package org.springframework.social.gaelic.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.gaelic.api.Gaelic;
import org.springframework.social.gaelic.api.GaelicProfile;

/**
 *
 * @author sosandstrom
 */
public class GaelicAdapter implements ApiAdapter<Gaelic> {

    public GaelicAdapter() {
    }

    @Override
    public boolean test(Gaelic a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setConnectionValues(Gaelic gaelic, ConnectionValues cv) {
        GaelicProfile profile = gaelic.getProfile();
        cv.setProviderUserId(profile.getId());
    }

    @Override
    public UserProfile fetchUserProfile(Gaelic gaelic) {
        GaelicProfile profile = gaelic.getProfile();
        final UserProfileBuilder BUILDER = new UserProfileBuilder();
        return BUILDER
                .setUsername(profile.getId())
                .setEmail(profile.getEmail())
                .build();
    }

    @Override
    public void updateStatus(Gaelic a, String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
