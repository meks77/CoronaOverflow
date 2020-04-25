import {createStackNavigator} from '@react-navigation/stack';
import React from 'react';
import {HeaderOptionsNoTitle, HeaderOptionsWithTitle} from '../header/HeaderOptions';
import {LabelsScreen} from "../../features/postings/LabelsScreen";
import {PostingsScreen} from "../../features/postings/PostingsScreen";

const Stack = createStackNavigator();

export default function PostingsStack() {
    return (
        <Stack.Navigator>
            <Stack.Screen
                name="Labels"
                component={LabelsScreen}
                options={HeaderOptionsWithTitle('')}
            />
            <Stack.Screen
                name="Postings"
                component={PostingsScreen}
                options={HeaderOptionsWithTitle('Postings')}
            />
        </Stack.Navigator>
    );
}
