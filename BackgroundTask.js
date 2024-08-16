// backgroundTask.js
import { AppRegistry } from 'react-native';

console.log('BackgroundTask.js file loaded');

const BackgroundTask = async (taskData) => {
  console.log('start');
  try {
    console.log('Background task executed !!!!!!!!!!!', taskData);
    // Your task code here
  } catch (error) {
    console.error('Error in background task:', error);
  }
  console.log('Background task end');
};

AppRegistry.registerHeadlessTask('BackgroundTask', () => BackgroundTask);


