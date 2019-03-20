import { NativeModules } from 'react-native';

export default class ReactNativeZendesk {
    static core = NativeModules.ReactNativeZendeskCore;
    static support = NativeModules.ReactNativeZendeskSupport;

    static initialize(data) {
        return ReactNativeZendesk.core.initialize(data);
    }

    static setLoggable(loggable) {
        return ReactNativeZendesk.core.setLoggable(loggable);
    }

    static setAnonymousIdentity() {
        return ReactNativeZendesk.core.setAnonymousIdentity();
    }

    static setAnonymousIdentityWithDetails(name, email) {
        return ReactNativeZendesk.core.setAnonymousIdentityWithDetails(name, email);
    }

    static setJWTIdentity(jwtIdentity) {
        return ReactNativeZendesk.core.setJWTIdentity(jwtIdentity);
    }

    static setConfiguration(data) {
        return ReactNativeZendesk.support.setConfiguration(data);
    }

    static startCreateTicketScreen() {
        return ReactNativeZendesk.support.startCreateTicketScreen();
    }

    static showOpenTicketScreen() {
        return ReactNativeZendesk.support.showOpenTicketScreen();
    }

    static showSpecificTicket(data) {
        return ReactNativeZendesk.support.showSpecificTicket(data);
    }
}