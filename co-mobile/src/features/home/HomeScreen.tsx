import React from 'react';
import {ScrollView} from 'react-native';
import {Text} from 'react-native-elements';
import {colors} from '../../styles/Colors';

export class HomeScreen extends React.Component {
  render() {
    return (
      <ScrollView style={{flex: 1, backgroundColor: colors.light_grey}}>
        <Text>HomeScreen</Text>
      </ScrollView>
    );
  }
}