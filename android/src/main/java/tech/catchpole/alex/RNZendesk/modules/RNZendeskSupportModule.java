package tech.catchpole.alex.RNZendesk.modules;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.zendesk.sdk.feedback.BaseZendeskFeedbackConfiguration;
import com.zendesk.sdk.feedback.ZendeskFeedbackConfiguration;
import com.zendesk.sdk.feedback.ui.ContactZendeskActivity;
import com.zendesk.sdk.model.request.CustomField;
import com.zendesk.sdk.network.impl.ZendeskConfig;
import com.zendesk.sdk.requests.RequestActivity;
import com.zendesk.sdk.requests.ViewRequestActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RNZendeskSupportModule extends ReactContextBaseJavaModule {

    private ZendeskFeedbackConfiguration configuration;

    public RNZendeskSupportModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNZendeskSupport";
    }

    @ReactMethod
    public void setConfiguration(final ReadableMap data) {
        configuration = new BaseZendeskFeedbackConfiguration() {
            @Override
            public String getRequestSubject() {
                if (data.hasKey("subject")) {
                    return data.getString("subject");
                }

                return "";
            }

            @Override
            public List<String> getTags() {
                if (data.hasKey("tags")) {
                    ArrayList<Object> tagArray = data.getArray("tags").toArrayList();
                    List<String> strings = new ArrayList<>(tagArray.size());
                    for (Object object : tagArray) {
                        strings.add(Objects.toString(object, null));
                    }
                    return strings;
                }

                return new ArrayList<>();
            }

            @Override
            public String getAdditionalInfo() {
                if (data.hasKey("additionalInfo")) {
                    return data.getString("additionalInfo");
                }

                return "";
            }
        };
    }

    @ReactMethod
    public void startCreateTicketScreen(Promise promise) {
        Activity activity = getCurrentActivity();

        if (activity == null) {
            promise.reject(new ActivityNotFoundException());
            return;
        }

        ContactZendeskActivity.startActivity(activity, configuration);
        promise.resolve(true);
    }

    @ReactMethod
    public void showOpenTicketScreen(Promise promise) {
        Activity activity = getCurrentActivity();

        if (activity == null) {
            promise.reject(new ActivityNotFoundException());
            return;
        }

        RequestActivity.startActivity(activity, configuration);
        promise.resolve(true);
    }

    @ReactMethod
    public void showSpecificTicket(ReadableMap map, Promise promise) {
        Activity activity = getCurrentActivity();

        if (activity == null) {
            promise.reject(new ActivityNotFoundException());
            return;
        }

        if (!map.hasKey("subject")) {
            promise.reject(new Exception("Missing required parameter 'subject'"));
            return;
        }

        if (!map.hasKey("requestId")) {
            promise.reject(new Exception("Missing required parameter 'requestId'"));
            return;
        }

        Intent intent = new Intent(activity, ViewRequestActivity.class);

        intent.putExtra(ViewRequestActivity.EXTRA_SUBJECT, map.getString("subject"));
        intent.putExtra(ViewRequestActivity.EXTRA_REQUEST_ID, map.getString("requestId"));

        activity.startActivity(intent);
        promise.resolve(true);
    }
}
