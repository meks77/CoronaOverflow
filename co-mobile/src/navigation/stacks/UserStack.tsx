import {createStackNavigator} from '@react-navigation/stack';
import React from 'react';
import {HeaderOptionsWithTitle} from '../header/HeaderOptions';
import {UserScreen} from "../../features/user/UserScreen";

const Stack = createStackNavigator();

export default function UserStack() {
    return (
        <Stack.Navigator>
            <Stack.Screen
                name="User"
                component={UserScreen}
                options={HeaderOptionsWithTitle('User')}
            />
        </Stack.Navigator>
    );
}
