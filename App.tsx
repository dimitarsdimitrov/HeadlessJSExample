// App.js
import React from 'react';
import { View, Button, NativeModules, StyleSheet } from 'react-native';
const { HeadlessJsTaskServiceModule } = NativeModules;

const App = () => {
  const triggerBackgroundTask = () => {
    console.log('   NativeModules.HeadlessJsTaskServiceModule: ', HeadlessJsTaskServiceModule);
    // Make sure method name matches the native module
    if (HeadlessJsTaskServiceModule && typeof HeadlessJsTaskServiceModule.startService === 'function') {
      HeadlessJsTaskServiceModule.startService();
    } else {
      console.error('startBackgroundTask method not found in HeadlessJsTaskServiceModule');
    }
  };

  return (
    <View style={styles.container}>
      <Button title="Start Background Task" onPress={triggerBackgroundTask} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});


export default App;
