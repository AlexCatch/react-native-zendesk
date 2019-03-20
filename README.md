
# react-native-zendesk

## Getting started

`$ npm install react-native-zendesk --save`

### Mostly automatic installation

`$ react-native link react-native-zendesk`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-zendesk` and add `RNZendesk.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNZendesk.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

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
```javascript
import RNZendesk from 'react-native-zendesk';

// TODO: What to do with the module?
RNZendesk;
```
  