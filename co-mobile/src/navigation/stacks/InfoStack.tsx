import {createStackNavigator} from '@react-navigation/stack';
import React from 'react';
import {HeaderOptionsWithTitle} from '../header/HeaderOptions';
import {InfoScreen} from "../../features/info/InfoScreen";

const Stack = createStackNavigator();

export default function InfoStack() {
    return (
        <Stack.Navigator>
            <Stack.Screen
                name="Info"
                component={InfoScreen}
                options={HeaderOptionsWithTitle('Info')}
            />
        </Stack.Navigator>
    );
}
