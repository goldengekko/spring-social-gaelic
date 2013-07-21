/*
 * INSERT COPYRIGHT HERE
 */

package org.springframework.social.gaelic.api;

import org.springframework.social.ApiBinding;

/**
 *
 * @author sosandstrom
 */
public interface Gaelic extends ApiBinding {
    GaelicProfile getProfile();
    GaelicProfile getProfile(String userId);
}
