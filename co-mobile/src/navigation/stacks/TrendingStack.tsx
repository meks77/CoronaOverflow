import {createStackNavigator} from '@react-navigation/stack';
import React from 'react';
import {HeaderOptionsWithTitle} from '../header/HeaderOptions';
import {TrendingLabelsScreen} from "../../features/trending/TrendingLabelsScreen";
import {TrendingPostingsScreen} from "../../features/trending/TrendingPostingsScreen";

const Stack = createStackNavigator();

export default function TrendingStack() {
    return (
        <Stack.Navigator>
            <Stack.Screen
                name="Labels"
                component={TrendingLabelsScreen}
                options={HeaderOptionsWithTitle('Trending')}
            />
            <Stack.Screen
                name="Postings"
                component={TrendingPostingsScreen}
                options={HeaderOptionsWithTitle('Postings')}
            />
        </Stack.Navigator>
    );
}
