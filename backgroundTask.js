// backgroundTask.js
import { AppRegistry } from 'react-native';

const backgroundTask = async (taskData) => {
  console.log('Background task executed', taskData);
  // Perform your background task here
};

AppRegistry.registerHeadlessTask('BackgroundTask', () => backgroundTask);
