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
                name="Trending"
                component={TrendingLabelsScreen}
                options={HeaderOptionsWithTitle('Trending')}
            />
            <Stack.Screen
                name="TrendingPostings"
                component={TrendingPostingsScreen}
                options={HeaderOptionsWithTitle('TrendingPostings')}
            />
        </Stack.Navigator>
    );
}
