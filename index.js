import { NativeModules } from 'react-native';

export default class RNZendesk {
    static core = NativeModules.RNZendeskCore;
    static support = NativeModules.RNZendeskSupport;

    static initialize(data) {
        return RNZendesk.core.initialize(data);
    }

    static setLoggable(loggable) {
        return RNZendesk.core.setLoggable(loggable);
    }

    static setAnonymousIdentity() {
        return RNZendesk.core.setAnonymousIdentity();
    }

    static setAnonymousIdentityWithDetails(name, email) {
        return RNZendesk.core.setAnonymousIdentityWithDetails(name, email);
    }

    static setJWTIdentity(jwtIdentity) {
        return RNZendesk.core.setJWTIdentity(jwtIdentity);
    }

    static setConfiguration(data) {
        return RNZendesk.support.setConfiguration(data);
    }

    static startCreateTicketScreen() {
        return RNZendesk.support.startCreateTicketScreen();
    }

    static showOpenTicketScreen() {
        return RNZendesk.support.showOpenTicketScreen();
    }

    static showSpecificTicket(data) {
        return RNZendesk.support.showSpecificTicket(data);
    }
}