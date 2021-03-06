import {createStackNavigator} from '@react-navigation/stack';
import React from 'react';
import {HomeScreen} from '../../features/home/HomeScreen';
import {HeaderOptionsWithTitle} from '../header/HeaderOptions';

const Stack = createStackNavigator();

export default function HomeStack() {
  return (
      <Stack.Navigator>
        <Stack.Screen
            name="Home"
            component={HomeScreen}
            options={HeaderOptionsWithTitle('CoronaOverflow')}
        />
      </Stack.Navigator>
  );
}
