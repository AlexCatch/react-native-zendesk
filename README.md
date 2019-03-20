
# react-native-zendesk

react-native-zendesk is a wrapper around the V1 SDKs for Zendesk (V2 causes some issues with Expo). It's still in really early development and only supports a few features from support for Android currently.

100% not safe for production yet (unless you're brave).

## Getting started

`$ npm install react-native-zendesk --save`

### Mostly automatic installation

`$ react-native link react-native-zendesk`

### Manual installation

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import tech.catchpole.alex.react-native-zendesk.RNZendeskPackage;` to the imports at the top of the file
  - Add `new RNZendeskPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-zendesk'
  	project(':react-native-zendesk').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-zendesk/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-zendesk')
  	```

## Usage
TODO
  
