import React from 'react';
import Icon from 'react-native-vector-icons/Ionicons';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import {colors} from '../styles/Colors';
import PostingsStack from "./stacks/PostingsStack";
import HomeStack from "./stacks/HomeStack";
import UserStack from "./stacks/UserStack";
import InfoStack from "./stacks/InfoStack";
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
        activeTintColor: colors.dark_grey,
        inactiveTintColor: colors.light_grey,
        activeBackgroundColor: colors.primary_white,
        inactiveBackgroundColor: colors.primary_white,
        style: {height: 70, borderTopWidth: 0},
        showLabel: false,
      }}>
      <Tab.Screen name="Home" component={HomeStack} />
      <Tab.Screen name="Postings" component={PostingsStack} />
      <Tab.Screen name="User" component={UserStack} />
      <Tab.Screen name="Info" component={InfoStack} />
    </Tab.Navigator>
  );
}
