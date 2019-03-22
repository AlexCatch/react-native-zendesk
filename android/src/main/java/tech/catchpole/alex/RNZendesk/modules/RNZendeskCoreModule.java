package tech.catchpole.alex.RNZendesk.modules;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.zendesk.logger.Logger;
import com.zendesk.sdk.model.access.AnonymousIdentity;
import com.zendesk.sdk.model.access.Identity;
import com.zendesk.sdk.model.access.JwtIdentity;
import com.zendesk.sdk.network.impl.ZendeskConfig;

public class RNZendeskCoreModule extends ReactContextBaseJavaModule {

    public RNZendeskCoreModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNZendeskCore";
    }

    @ReactMethod
    public void setLoggable(boolean loggable) {
        Logger.setLoggable(loggable);
    }

    @ReactMethod
    public void initialize(ReadableMap data) {
        String zendeskUrl = data.getString("zendeskUrl");
        String applicationId = data.getString("applicationId");
        String oauthClientId = data.getString("oauthClientId");
        ZendeskConfig.INSTANCE.init(
                getReactApplicationContext(),
                zendeskUrl,
                applicationId,
                oauthClientId
        );
    }

    @ReactMethod
    public void setAnonymousIdentity() {
        Identity identity = new AnonymousIdentity.Builder()
                .build();
        ZendeskConfig.INSTANCE.setIdentity(identity);
    }

    @ReactMethod
    public void setAnonymousIdentityWithDetails(String name, String email) {
        Identity identity = new AnonymousIdentity.Builder()
                .withNameIdentifier(name)
                .withEmailIdentifier(email)
                .build();
        ZendeskConfig.INSTANCE.setIdentity(identity);
    }

    @ReactMethod
    public void setJWTIdentity(String jwtIdentity) {
        Identity jwtUserIdentity = new JwtIdentity(jwtIdentity);
        ZendeskConfig.INSTANCE.setIdentity(jwtUserIdentity);
    }
}
