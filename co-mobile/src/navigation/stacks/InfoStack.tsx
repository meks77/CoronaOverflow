import {createStackNavigator} from '@react-navigation/stack';
import React from 'react';
import {HeaderOptionsNoTitle} from '../header/HeaderOptions';
import {InfoScreen} from "../../features/info/InfoScreen";

const Stack = createStackNavigator();

export default function InfoStack() {
    return (
        <Stack.Navigator>
            <Stack.Screen
                name="Info"
                component={InfoScreen}
                options={HeaderOptionsNoTitle}
            />
        </Stack.Navigator>
    );
}
