// App.js
import React from 'react';
import { View, Button, NativeModules, StyleSheet } from 'react-native';

const App = () => {
  const triggerBackgroundTask = () => {
    NativeModules.HeadlessJsTaskServiceModule.startService();
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
