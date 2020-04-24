import React from 'react';
import Icon from 'react-native-vector-icons/Ionicons';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import {HomeStack} from './stacks/HomeStack';
import {colors} from '../styles/Colors';
Icon.loadFont();

const Tab = createBottomTabNavigator();

export default function TabNavigator() {
  return (
    <Tab.Navigator
      screenOptions={({route}) => ({
        tabBarIcon: ({focused, color, size}) => {
          let iconName;
          if (route.name === 'Home') {
            iconName = 'md-home';
          } else if (route.name === 'Postings') {
              iconName = 'md-chatbubbles';
          } else if (route.name === 'User') {
            iconName = 'md-person';
          } else if (route.name === 'Info') {
            iconName = 'md-information-circle';
          }

          // You can return any component that you like here!
          return (
            <Icon name={iconName} size={size} color={color} type={'ionicon'} />
          );
        },
      })}
      tabBarOptions={{
        activeTintColor: colors.primary_light_green,
        inactiveTintColor: colors.secondary_light_green,
        activeBackgroundColor: colors.primary_white,
        inactiveBackgroundColor: colors.primary_white,
        style: {height: 70, borderTopWidth: 0},
        showLabel: false,
      }}>
      <Tab.Screen name="Home" component={HomeStack} />
      <Tab.Screen name="Postings" component={HomeStack} />
      <Tab.Screen name="User" component={HomeStack} />
      <Tab.Screen name="Info" component={HomeStack} />
    </Tab.Navigator>
  );
}
