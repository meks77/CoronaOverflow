/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import 'react-native-gesture-handler';
import React from 'react';

import AppContainer from './navigation/AppContainer';
import {SafeAreaView, StatusBar} from 'react-native';
import {colors} from './styles/Colors';

export class App extends React.Component {
  render() {
    return (
        <>
          <StatusBar
              backgroundColor={colors.primary_white}
              barStyle={'dark-content'}
          />
          <SafeAreaView style={{flex: 1}}>
            <AppContainer />
          </SafeAreaView>
        </>
    );
  }
}

export default App;
